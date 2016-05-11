package cn.elvea.core.persistence.dao;

import cn.elvea.core.utils.JdbcUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.ConnectionCallback;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceUtils;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public abstract class BaseDao {
    JdbcTemplate jdbcTemplate;
    NamedParameterJdbcTemplate namedParameterJdbcTemplate;
    DataSource dataSource;

    @Autowired
    public void init(DataSource dataSource) {
        this.dataSource = dataSource;
        this.jdbcTemplate = new JdbcTemplate(this.dataSource);
        this.namedParameterJdbcTemplate = new NamedParameterJdbcTemplate(this.dataSource);
    }

    /**
     * 获取数据库元数据
     *
     * @return DatabaseMetaData
     * @throws SQLException
     */
    public DatabaseMetaData getDatabaseMetaData() throws SQLException {
        return jdbcTemplate.execute(JdbcUtils::getDatabaseMetaData);
    }

    /**
     * 获取数据库类型
     *
     * @return String 数据库类型
     * @throws SQLException
     */
    public String getDatabaseType() throws SQLException {
        return jdbcTemplate.execute((ConnectionCallback<String>) con -> JdbcUtils.getDatabaseType(JdbcUtils.getDatabaseMetaData(con)));
    }

    /**
     * 创建简单临时表
     *
     * @param data 临时数据
     * @return String 临时表名
     * @throws SQLException
     */
    public String createTempTable(final List<Long> data) throws SQLException {
        return jdbcTemplate.execute((ConnectionCallback<String>) con -> JdbcUtils.createTemporaryTable(con, data));
    }

    /**
     * 创建临时表
     *
     * @param nameTypeMap 表结构定义
     * @return String 临时表名
     * @throws SQLException
     */
    public String createTempTable(final Map<String, String> nameTypeMap, final List<Map<String, Object>> data) throws SQLException {
        return jdbcTemplate.execute((ConnectionCallback<String>) con -> JdbcUtils.createTemporaryTable(con, nameTypeMap, data));
    }

    /**
     * 移除临时表
     *
     * @param temporaryTableName 临时表名
     * @throws SQLException
     */
    public void dropTemporaryTable(final String temporaryTableName) throws SQLException {
        jdbcTemplate.execute((ConnectionCallback<String>) con -> {
            JdbcUtils.dropTemporaryTable(con, temporaryTableName);
            return null;
        });
    }

    /**
     * 获取Spring管理到数据库连接
     */
    protected final Connection getConnection() throws CannotGetJdbcConnectionException {
        return DataSourceUtils.getConnection(dataSource);
    }

    /**
     * 释放Spring管理到数据库连接
     */
    protected final void releaseConnection(Connection con) {
        DataSourceUtils.releaseConnection(con, dataSource);
    }

}
