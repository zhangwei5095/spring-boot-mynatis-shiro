package cn.elvea.core.persistence.repository;

import cn.elvea.core.persistence.repository.support.Callback;
import cn.elvea.core.persistence.repository.support.NativeCallback;
import cn.elvea.core.persistence.repository.support.ReturningCallback;
import cn.elvea.core.persistence.repository.support.ReturningNativeCallback;
import cn.elvea.core.utils.JdbcUtils;
import com.google.common.collect.Lists;
import org.apache.commons.lang3.StringUtils;
import org.hibernate.Session;
import org.hibernate.jdbc.ReturningWork;
import org.hibernate.jdbc.Work;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.JpaEntityInformationSupport;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@NoRepositoryBean
@SuppressWarnings({"unchecked"})
public class BaseRepositoryImpl<T, PK extends Serializable> extends SimpleJpaRepository<T, PK> implements BaseRepository<T, PK> {
    private EntityManager entityManager = null;
    private JpaEntityInformation<T, ?> entityInformation = null;

    public BaseRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);

        this.entityManager = entityManager;
        this.entityInformation = entityInformation;
    }

    public BaseRepositoryImpl(Class<T> domainClass, EntityManager entityManager) {
        this(JpaEntityInformationSupport.getEntityInformation(domainClass, entityManager), entityManager);
    }

    @Override
    public void execute(Callback callback) throws DataAccessException {
        callback.execute(entityManager);
    }

    @Override
    public <E> E execute(ReturningCallback<E> callback) throws DataAccessException {
        return callback.execute(entityManager);
    }

    @Override
    public void execute(final NativeCallback callback) throws DataAccessException {
        Session session = entityManager.unwrap(Session.class);

        session.doWork(new Work() {
            @Override
            public void execute(Connection connection) throws SQLException {
                callback.execute(connection);
            }
        });
    }

    @Override
    public <E> E execute(final ReturningNativeCallback<E> callback) throws DataAccessException {
        Session session = entityManager.unwrap(Session.class);

        return session.doReturningWork(new ReturningWork<E>() {
            @Override
            public E execute(Connection connection) throws SQLException {
                return callback.execute(connection);
            }
        });
    }

    @Override
    public int execute(final String jpql) throws DataAccessException {
        return execute(jpql, new Object[]{});
    }

    @Override
    public int execute(final String jpql, final Object[] params) throws DataAccessException {
        Query query = createQuery(jpql, params);
        return query.executeUpdate();
    }

    @Override
    public int execute(final String jpql, final Map<String, Object> params) throws DataAccessException {
        Query query = createQuery(jpql, params);
        return query.executeUpdate();
    }

    @Override
    public <E> List<E> query(final String jpql) {
        Query query = createQuery(jpql, new Object[]{});
        return query.getResultList();
    }

    @Override
    public <E> List<E> query(final String jpql, final Object[] params) {
        Query query = createQuery(jpql, params);
        return query.getResultList();
    }

    @Override
    public <E> List<E> query(final String jpql, final Map<String, Object> params) {
        Query query = createQuery(jpql, params);
        return query.getResultList();
    }

    @Override
    public <E> E queryForObject(final String jpql) {
        Query query = createQuery(jpql, new Object[]{});
        return (E) query.getSingleResult();
    }

    @Override
    public <E> E queryForObject(final String jpql, final Object[] params) {
        Query query = createQuery(jpql, params);
        return (E) query.getSingleResult();
    }

    @Override
    public <E> E queryForObject(final String jpql, final Map<String, Object> params) {
        Query query = createQuery(jpql, params);
        return (E) query.getSingleResult();
    }

    @Override
    public <E> Page<E> queryPage(final String jpql, final Pageable pageable) {
        return queryPage(jpql, pageable, new Object[]{});
    }

    @Override
    public <E> Page<E> queryPage(final String jpql, final Pageable pageable, final Object[] params) {
        Long total = queryTotalCount(jpql, params);

        Query query = createQuery(jpql, params);
        query.setFirstResult(pageable.getOffset());
        query.setMaxResults(pageable.getPageSize());

        List<E> content = total > pageable.getOffset() ? query.getResultList() : Lists.newArrayList();

        return new PageImpl<E>(content, pageable, total);
    }

    @Override
    public <E> Page<E> queryPage(final String jpql, final Pageable pageable, final Map<String, Object> params) {
        Query query = createQuery(jpql, params);
        query.setFirstResult(pageable.getOffset());
        query.setMaxResults(pageable.getPageSize());

        Long total = queryTotalCount(jpql, params);
        List<E> content = total > pageable.getOffset() ? query.getResultList() : Lists.newArrayList();

        return new PageImpl<E>(content, pageable, total);
    }

    private Query createQuery(final String queryString, final Object[] params) {
        Query query = entityManager.createQuery(queryString);
        if (params != null) {
            for (int i = 0; i < params.length; i++) {
                query.setParameter(i, params[i]);
            }
        }
        return query;
    }

    private Query createQuery(final String queryString, final Map<String, Object> params) {
        Query query = entityManager.createQuery(queryString);
        for (String key : params.keySet()) {
            query.setParameter(key, params.get(key));
        }
        return query;
    }

    private Long queryTotalCount(final String jpql, final Map<String, Object> params) {
        String fromJpql = jpql;
        fromJpql = "from " + StringUtils.substringAfter(fromJpql, "from");
        fromJpql = StringUtils.substringBefore(fromJpql, "order by");

        String countHql = "select count(*) " + fromJpql;
        try {
            return queryForObject(countHql, params);
        } catch (Exception e) {
            throw new RuntimeException("jpql can't be auto count, hql is:" + countHql, e);
        }
    }

    private Long queryTotalCount(final String jpql, final Object[] params) {
        String fromJpql = jpql;
        fromJpql = "from " + StringUtils.substringAfter(fromJpql, "from");
        fromJpql = StringUtils.substringBefore(fromJpql, "order by");

        String countHql = "select count(*) " + fromJpql;
        try {
            return queryForObject(countHql, params);
        } catch (Exception e) {
            throw new RuntimeException("jpql can't be auto count, hql is:" + countHql, e);
        }
    }

    @Override
    public DatabaseMetaData getDatabaseMetaData() throws SQLException {
        return execute(new ReturningNativeCallback<DatabaseMetaData>() {
            @Override
            public DatabaseMetaData execute(Connection con) throws SQLException, DataAccessException {
                return JdbcUtils.getDatabaseMetaData(con);
            }
        });
    }

    @Override
    public String getDatabaseType() throws SQLException {
        return execute(new ReturningNativeCallback<String>() {
            @Override
            public String execute(Connection con) throws SQLException, DataAccessException {
                return JdbcUtils.getDatabaseType(JdbcUtils.getDatabaseMetaData(con));
            }
        });
    }

    @Override
    public String createTempTable(final List<Long> data) throws SQLException {
        return execute(new ReturningNativeCallback<String>() {
            @Override
            public String execute(Connection con) throws SQLException, DataAccessException {
                return JdbcUtils.createTemporaryTable(con, data);
            }
        });
    }

    @Override
    public String createTempTable(final Map<String, String> nameTypeMap, final List<Map<String, Object>> data) throws SQLException {
        return execute(new ReturningNativeCallback<String>() {
            @Override
            public String execute(Connection con) throws SQLException, DataAccessException {
                return JdbcUtils.createTemporaryTable(con, nameTypeMap, data);
            }
        });
    }

    @Override
    public void dropTemporaryTable(final String temporaryTableName) throws SQLException {
        execute(new NativeCallback() {
            @Override
            public void execute(Connection con) throws SQLException, DataAccessException {
                JdbcUtils.dropTemporaryTable(con, temporaryTableName);
            }
        });
    }
}
