package cn.elvea.commons.persistence.repository.support;

import org.springframework.dao.DataAccessException;

import java.sql.Connection;
import java.sql.SQLException;

public interface ReturningNativeCallback<T> {
    T execute(Connection con) throws SQLException, DataAccessException;
}
