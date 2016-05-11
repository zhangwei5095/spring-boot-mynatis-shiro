package cn.elvea.core.persistence.repository;

import cn.elvea.core.persistence.repository.support.NativeWork;
import cn.elvea.core.persistence.repository.support.ReturningNativeWork;
import cn.elvea.core.persistence.repository.support.ReturningWork;
import cn.elvea.core.persistence.repository.support.Work;
import org.springframework.dao.DataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

@NoRepositoryBean
public interface BaseRepository<T, PK extends Serializable> extends JpaRepository<T, PK> {
    void execute(Work action) throws DataAccessException;

    <E> E execute(ReturningWork<E> action) throws DataAccessException;

    void execute(final NativeWork action) throws SQLException, DataAccessException;

    <E> E execute(final ReturningNativeWork<E> action) throws SQLException, DataAccessException;

    int execute(final String jpql) throws DataAccessException;

    int execute(final String jpql, Object[] params) throws DataAccessException;

    int execute(final String jpql, Map<String, Object> params) throws DataAccessException;

    <E> List<E> query(String sql, Object[] params) throws DataAccessException;

    <E> List<E> query(String sql, Map<String, Object> params) throws DataAccessException;

    <E> E queryForObject(String sql, Object[] params) throws DataAccessException;

    <E> E queryForObject(String sql, Map<String, Object> params) throws DataAccessException;

    /**
     * 获取数据库元数据
     *
     * @return DatabaseMetaData
     * @throws SQLException
     */
    DatabaseMetaData getDatabaseMetaData() throws SQLException;

    /**
     * 获取数据库类型
     *
     * @return String 数据库类型
     * @throws SQLException
     */
    String getDatabaseType() throws SQLException;

    /**
     * 创建简单临时表
     *
     * @param data 临时数据
     * @return String 临时表名
     * @throws SQLException
     */
    String createTempTable(final List<Long> data) throws SQLException;

    /**
     * 创建临时表
     *
     * @param nameTypeMap 表结构定义
     * @return String 临时表名
     * @throws SQLException
     */
    String createTempTable(final Map<String, String> nameTypeMap, final List<Map<String, Object>> data) throws SQLException;

    /**
     * 移除临时表
     *
     * @param temporaryTableName 临时表名
     * @throws SQLException
     */
    void dropTemporaryTable(final String temporaryTableName) throws SQLException;
}
