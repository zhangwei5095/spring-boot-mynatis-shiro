package cn.elvea.core.persistence.repository;

import cn.elvea.core.persistence.repository.support.NativeWork;
import cn.elvea.core.persistence.repository.support.ReturningNativeWork;
import cn.elvea.core.persistence.repository.support.ReturningWork;
import cn.elvea.core.persistence.repository.support.Work;
import cn.elvea.core.utils.JdbcUtils;
import org.hibernate.Session;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.JpaEntityInformationSupport;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.io.Serializable;
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
    public void execute(Work action) throws DataAccessException {
        action.doWork(entityManager);
    }

    @Override
    public <E> E execute(ReturningWork<E> action) throws DataAccessException {
        return action.doReturningWork(entityManager);
    }

    @Override
    public void execute(final NativeWork action) throws DataAccessException {
        Session session = entityManager.unwrap(Session.class);

        session.doWork(action::doNativeWork);
    }

    @Override
    public <E> E execute(final ReturningNativeWork<E> action) throws DataAccessException {
        Session session = entityManager.unwrap(Session.class);
        return session.doReturningWork(action::doReturningWork);
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
    public <E> E queryForObject(final String jpql, final Object[] params) {
        Query query = createQuery(jpql, params);
        return (E) query.getSingleResult();
    }

    @Override
    public <E> E queryForObject(final String jpql, final Map<String, Object> params) {
        Query query = createQuery(jpql, params);
        return (E) query.getSingleResult();
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
        Query query = entityManager.createNamedQuery(queryString);
        for (String key : params.keySet()) {
            query.setParameter(key, params.get(key));
        }
        return query;
    }

    @Override
    public DatabaseMetaData getDatabaseMetaData() throws SQLException {
        return execute(JdbcUtils::getDatabaseMetaData);
    }

    @Override
    public String getDatabaseType() throws SQLException {
        return execute((ReturningNativeWork<String>) con -> {
            return JdbcUtils.getDatabaseType(JdbcUtils.getDatabaseMetaData(con));
        });
    }

    @Override
    public String createTempTable(final List<Long> data) throws SQLException {
        return execute((ReturningNativeWork<String>) con -> {
            return JdbcUtils.createTemporaryTable(con, data);
        });
    }

    @Override
    public String createTempTable(final Map<String, String> nameTypeMap, final List<Map<String, Object>> data) throws SQLException {
        return execute((ReturningNativeWork<String>) con -> {
            return JdbcUtils.createTemporaryTable(con, nameTypeMap, data);
        });
    }

    @Override
    public void dropTemporaryTable(final String temporaryTableName) throws SQLException {
        execute((NativeWork) con -> {
            JdbcUtils.dropTemporaryTable(con, temporaryTableName);
        });
    }
}
