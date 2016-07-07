package cn.elvea.commons.persistence.repository;

import cn.elvea.commons.persistence.repository.support.Callback;
import cn.elvea.commons.persistence.repository.support.NativeCallback;
import cn.elvea.commons.persistence.repository.support.ReturningCallback;
import cn.elvea.commons.persistence.repository.support.ReturningNativeCallback;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import java.io.Serializable;
import java.sql.DatabaseMetaData;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

/**
 * 拓展Spring Data JPA,封装一些基本的操作简化开发
 *
 * @param <T>
 * @param <PK>
 */
@NoRepositoryBean
public interface BaseEntityRepository<T, PK extends Serializable> extends JpaRepository<T, PK> {
    /**
     * 执行当前会话的原生JPA操作
     *
     * @param callback 需要执行的操作
     * @throws DataAccessException
     */
    void execute(final Callback callback) throws DataAccessException;

    /**
     * 执行当前会话的原生JPA操作,带返回值
     *
     * @param callback 需要执行的操作
     * @throws DataAccessException
     */
    <E> E execute(final ReturningCallback<E> callback) throws DataAccessException;

    /**
     * 执行当前会话的原生JDBC操作
     *
     * @param callback 需要执行的操作
     * @throws DataAccessException
     */
    void execute(final NativeCallback callback) throws SQLException, DataAccessException;

    /**
     * 执行当前会话的原生JDBC操作,带返回值
     *
     * @param callback 需要执行的操作
     * @throws DataAccessException
     */
    <E> E execute(final ReturningNativeCallback<E> callback) throws SQLException, DataAccessException;

    /**
     * 执行JPQL
     *
     * @throws DataAccessException
     */
    int execute(final String jpql) throws DataAccessException;

    /**
     * 执行JPQL
     *
     * @throws DataAccessException
     */
    int execute(final String jpql, final Object[] params) throws DataAccessException;

    /**
     * 执行JPQL
     *
     * @throws DataAccessException
     */
    int execute(final String jpql, final Map<String, Object> params) throws DataAccessException;

    /**
     * 执行查询
     *
     * @throws DataAccessException
     */
    <E> List<E> query(final String jpql) throws DataAccessException;

    /**
     * 执行查询
     *
     * @throws DataAccessException
     */
    <E> List<E> query(final String jpql, final Object[] params) throws DataAccessException;

    /**
     * 执行查询
     *
     * @throws DataAccessException
     */
    <E> List<E> query(final String jpql, final Map<String, Object> params) throws DataAccessException;

    /**
     * 执行查询,返回单个对象
     *
     * @throws DataAccessException
     */
    <E> E queryForObject(final String jpql) throws DataAccessException;

    /**
     * 执行查询,返回单个对象
     *
     * @throws DataAccessException
     */
    <E> E queryForObject(final String jpql, final Object[] params) throws DataAccessException;

    /**
     * 执行查询,返回单个对象
     *
     * @throws DataAccessException
     */
    <E> E queryForObject(final String jpql, final Map<String, Object> params) throws DataAccessException;

    /**
     * 执行查询,返回分页对象
     *
     * @throws DataAccessException
     */
    <E> Page<E> queryPage(final String jpql, final Pageable pageable) throws DataAccessException;

    /**
     * 执行查询,返回分页对象
     *
     * @throws DataAccessException
     */
    <E> Page<E> queryPage(final String jpql, final Pageable pageable, final Object[] params) throws DataAccessException;

    /**
     * 执行查询,返回分页对象
     *
     * @throws DataAccessException
     */
    <E> Page<E> queryPage(final String jpql, final Pageable pageable, final Map<String, Object> params) throws DataAccessException;

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
