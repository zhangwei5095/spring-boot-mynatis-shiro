package cn.elvea.core.persistence.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.CannotGetJdbcConnectionException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceUtils;

import javax.sql.DataSource;
import java.sql.Connection;

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
