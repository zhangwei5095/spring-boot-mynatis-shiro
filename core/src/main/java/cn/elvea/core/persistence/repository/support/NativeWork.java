package cn.elvea.core.persistence.repository.support;

import org.springframework.dao.DataAccessException;

import java.sql.Connection;
import java.sql.SQLException;

public interface NativeWork {
    void doNativeWork(Connection con) throws SQLException, DataAccessException;
}
