package cn.elvea.core.persistence.repository.support;

import org.springframework.dao.DataAccessException;

import java.sql.Connection;
import java.sql.SQLException;

public interface NativeCallback {
    void execute(Connection con) throws SQLException, DataAccessException;
}
