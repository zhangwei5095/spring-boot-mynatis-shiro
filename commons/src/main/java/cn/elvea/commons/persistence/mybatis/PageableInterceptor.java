package cn.elvea.commons.persistence.mybatis;

import cn.elvea.commons.utils.JdbcUtils;
import org.apache.ibatis.executor.Executor;
import org.apache.ibatis.executor.parameter.ParameterHandler;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.mapping.SqlSource;
import org.apache.ibatis.plugin.*;
import org.apache.ibatis.scripting.defaults.DefaultParameterHandler;
import org.apache.ibatis.session.ResultHandler;
import org.apache.ibatis.session.RowBounds;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.domain.Pageable;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.Properties;

/**
 * yBatis分页插件
 */
@Intercepts({@Signature(
        type = Executor.class,
        method = "query",
        args = {MappedStatement.class, Object.class, RowBounds.class, ResultHandler.class})})
public class PageableInterceptor implements Interceptor {
    private static Logger logger = LoggerFactory.getLogger(PageableInterceptor.class);

    static int MAPPED_STATEMENT_INDEX = 0;
    static int PARAMETER_INDEX = 1;
    static int ROWBOUNDS_INDEX = 2;
    static int RESULT_HANDLER_INDEX = 3;

    private static final String DEFAULT_PAGE_SQL_ID = ".*Page$"; // 需要拦截的ID(正则匹配)

    @Override
    public void setProperties(Properties properties) {

    }

    @Override
    public Object plugin(Object o) {
        return Plugin.wrap(o, this);
    }

    @Override
    @SuppressWarnings({"unchecked"})
    public Object intercept(Invocation invocation) throws Throwable {
        final Executor executor = (Executor) invocation.getTarget();
        final Object[] queryArgs = invocation.getArgs();
        final MappedStatement mappedStatement = (MappedStatement) queryArgs[MAPPED_STATEMENT_INDEX];
        final Object parameterObject = queryArgs[PARAMETER_INDEX];
        final RowBounds rowBounds = (RowBounds) queryArgs[ROWBOUNDS_INDEX];
        BoundSql boundSql = mappedStatement.getBoundSql(parameterObject);

        if (mappedStatement.getId().matches(DEFAULT_PAGE_SQL_ID)) {
            if (parameterObject == null) {
                throw new NullPointerException("parameterObject is null!");
            } else {
                if (parameterObject instanceof Pageable) {
                    Pageable pageable = (Pageable) parameterObject;

                    // 获取数据库连接
                    Connection con = mappedStatement.getConfiguration().getEnvironment().getDataSource().getConnection();
                    // 执行总记录数查询
                    int total = queryTotal(pageable, mappedStatement, boundSql, con);

                    String pageSql = getPageSql(boundSql.getSql(), pageable);
                    if (logger.isDebugEnabled()) {
                        logger.debug("page sql : [] ", pageSql);
                    }

                    BoundSql newBoundSql = copyFromBoundSql(mappedStatement, boundSql, pageSql);
                    MappedStatement newMappedStatement = copyFromMappedStatement(mappedStatement, new BoundSqlSqlSource(newBoundSql));
                    queryArgs[ROWBOUNDS_INDEX] = new RowBounds(RowBounds.NO_ROW_OFFSET, RowBounds.NO_ROW_LIMIT);
                    queryArgs[MAPPED_STATEMENT_INDEX] = newMappedStatement;
                }
            }
        }
        return invocation.proceed();
    }

    public static BoundSql copyFromBoundSql(MappedStatement ms, BoundSql boundSql, String sql) {
        BoundSql newBoundSql = new BoundSql(ms.getConfiguration(), sql, boundSql.getParameterMappings(), boundSql.getParameterObject());
        for (ParameterMapping mapping : boundSql.getParameterMappings()) {
            String prop = mapping.getProperty();
            if (boundSql.hasAdditionalParameter(prop)) {
                newBoundSql.setAdditionalParameter(prop, boundSql.getAdditionalParameter(prop));
            }
        }
        return newBoundSql;
    }

    private static MappedStatement copyFromMappedStatement(MappedStatement ms, SqlSource newSqlSource) {
        MappedStatement.Builder builder = new MappedStatement.Builder(ms.getConfiguration(), ms.getId(), newSqlSource, ms.getSqlCommandType());

        builder.resource(ms.getResource());
        builder.fetchSize(ms.getFetchSize());
        builder.statementType(ms.getStatementType());
        builder.keyGenerator(ms.getKeyGenerator());
        String[] keyProperties = ms.getKeyProperties();
        builder.keyProperty(keyProperties == null ? null : keyProperties[0]);

        //setStatementResultMap()
        builder.parameterMap(ms.getParameterMap());

        //setStatementTimeout()
        builder.timeout(ms.getTimeout());

        //setStatementResultMap()
        builder.resultMaps(ms.getResultMaps());
        builder.resultSetType(ms.getResultSetType());

        //setStatementCache()
        builder.cache(ms.getCache());
        builder.flushCacheRequired(ms.isFlushCacheRequired());
        builder.useCache(ms.isUseCache());

        return builder.build();
    }

    public static class BoundSqlSqlSource implements SqlSource {
        private BoundSql boundSql;

        public BoundSqlSqlSource(BoundSql boundSql) {
            this.boundSql = boundSql;
        }

        public BoundSql getBoundSql(Object parameterObject) {
            return boundSql;
        }
    }

    private int queryTotal(Pageable pageable, MappedStatement mappedStatement, BoundSql boundSql, Connection con) {
        String sql = getCountSql(boundSql.getSql());
        if (logger.isDebugEnabled()) {
            logger.debug("page count sql : [] ", sql);
        }

        int total = 0;

        List<ParameterMapping> parameterMappings = boundSql.getParameterMappings();
        BoundSql countBoundSql = new BoundSql(mappedStatement.getConfiguration(), sql, parameterMappings, pageable);
        ParameterHandler parameterHandler = new DefaultParameterHandler(mappedStatement, pageable, countBoundSql);

        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            stmt = con.prepareStatement(sql);
            parameterHandler.setParameters(stmt);
            rs = stmt.executeQuery();
            if (rs.next()) {
                total = rs.getInt(1);
            }
        } catch (SQLException e) {
            logger.error("query total record failure.\n", e);
        } finally {
            JdbcUtils.close(rs, stmt);
        }
        return total;
    }

    private String getCountSql(String sql) {
        int index = sql.indexOf("from");
        return "select count(*) " + sql.substring(index);
    }

    private String getPageSql(String sql, Pageable pageable) {
        if (pageable != null && pageable.getPageSize() > 0) {
            StringBuilder pageSql = getMySQLPageSql(sql, pageable);
            return pageSql.toString();
        } else {
            return sql;
        }
    }

    public StringBuilder getMySQLPageSql(String sql, Pageable pageable) {
        StringBuilder pageSql = new StringBuilder(100);
        pageSql.append(sql);
        pageSql.append(" limit " + pageable.getOffset() + "," + pageable.getPageSize());
        return pageSql;
    }
}
