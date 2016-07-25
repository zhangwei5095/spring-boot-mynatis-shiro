package cn.elvea.commons.service.jpa;

import cn.elvea.commons.domain.User;
import cn.elvea.commons.persistence.repository.BaseEntityRepository;
import cn.elvea.commons.persistence.repository.UserRepository;
import cn.elvea.commons.persistence.repository.support.Callback;
import cn.elvea.commons.persistence.repository.support.NativeCallback;
import cn.elvea.commons.persistence.repository.support.ReturningCallback;
import cn.elvea.commons.persistence.repository.support.ReturningNativeCallback;
import cn.elvea.commons.utils.JdbcUtils;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.sql.*;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class UserService extends BaseEntityServiceImpl<User, Long> {
    @Autowired
    UserRepository userRepository;

    @Override
    protected BaseEntityRepository<User, Long> getEntityRepository() {
        return userRepository;
    }

    public long testWork() throws SQLException {
        userRepository.execute(new Callback() {
            @Override
            public void execute(EntityManager entityManager) throws DataAccessException {
                User user = new User();
                user.setUsername(String.valueOf(new Date().getTime()));

                entityManager.persist(user);
            }
        });

        return userRepository.execute(new ReturningCallback<Long>() {
            @Override
            public Long execute(EntityManager entityManager) throws DataAccessException {
                Query query = entityManager.createQuery("select count(id) from User ");
                return (Long) query.getSingleResult();
            }
        });
    }

    public int testNativeWork() throws SQLException {
        userRepository.execute(new NativeCallback() {
            @Override
            public void execute(Connection con) throws SQLException, DataAccessException {
                PreparedStatement stmt = null;
                try {
                    stmt = con.prepareStatement(" insert into users (username) values (?)");
                    stmt.setString(1, String.valueOf(new Date().getTime()));
                    stmt.executeUpdate();
                } finally {
                    JdbcUtils.close(stmt);
                }
            }
        });

        return userRepository.execute(new ReturningNativeCallback<Integer>() {
            @Override
            public Integer execute(Connection con) throws SQLException, DataAccessException {
                ResultSet rs = null;
                PreparedStatement stmt = null;
                try {
                    stmt = con.prepareStatement(" select count(id) cnt from users ");
                    rs = stmt.executeQuery();
                    if (rs.next()) {
                        return rs.getInt("cnt");
                    }
                } finally {
                    JdbcUtils.close(rs);
                    JdbcUtils.close(stmt);
                }
                return 0;
            }
        });
    }

    public int testCreateSimpleTempTable() throws SQLException {
        List<Long> data = Lists.newArrayList();
        data.add(1l);
        data.add(2l);
        data.add(3l);

        String tmpTableName = null;
        try {
            tmpTableName = userRepository.createTempTable(data);

            final String temporaryTableName = tmpTableName;
            return userRepository.execute(new ReturningNativeCallback<Integer>() {
                @Override
                public Integer execute(Connection con) throws SQLException, DataAccessException {
                    ResultSet rs = null;
                    PreparedStatement stmt = null;
                    try {
                        stmt = con.prepareStatement(" select count(id) cnt from " + temporaryTableName);
                        rs = stmt.executeQuery();
                        if (rs.next()) {
                            return rs.getInt("cnt");
                        }
                    } finally {
                        JdbcUtils.close(rs);
                        JdbcUtils.close(stmt);
                    }
                    return 0;
                }
            });
        } finally {
            userRepository.dropTemporaryTable(tmpTableName);
        }
    }

    public int testCreateTempTable() throws SQLException {
        Map<String, String> nameTypeMap = Maps.newHashMap();
        nameTypeMap.put("username", JdbcUtils.COL_TYPE_STRING);
        nameTypeMap.put("birthday", JdbcUtils.COL_TYPE_DATE);
        nameTypeMap.put("logindatetime", JdbcUtils.COL_TYPE_TIMESTAMP);
        nameTypeMap.put("cradit_1", JdbcUtils.COL_TYPE_DOUBLE);
        nameTypeMap.put("cradit_2", JdbcUtils.COL_TYPE_FLOAT);
        nameTypeMap.put("cradit_3", JdbcUtils.COL_TYPE_INTEGER);

        List<Map<String, Object>> data = Lists.newArrayList();
        for (int i = 0; i <= 100; i++) {
            Map<String, Object> row = Maps.newHashMap();
            row.put("username", String.valueOf(new Date().getTime()));
            row.put("birthday", new Timestamp(new Date().getTime()));
            row.put("logindatetime", new Timestamp(new Date().getTime()));
            row.put("cradit_1", 1.23f);
            row.put("cradit_2", 4.567f);
            row.put("cradit_3", 88);

            data.add(row);
        }

        String tmpTableName = null;
        try {
            tmpTableName = userRepository.createTempTable(nameTypeMap, data);

            final String temporaryTableName = tmpTableName;

            return userRepository.execute(new ReturningNativeCallback<Integer>() {
                @Override
                public Integer execute(Connection con) throws SQLException, DataAccessException {
                    int cnt = 0;

                    ResultSet rs = null;
                    PreparedStatement stmt = null;
                    try {
                        stmt = con.prepareStatement(" select count(*) cnt from " + temporaryTableName);
                        rs = stmt.executeQuery();
                        if (rs.next()) {
                            cnt = rs.getInt("cnt");
                        }
                    } finally {
                        JdbcUtils.close(rs);
                        JdbcUtils.close(stmt);
                    }
                    return cnt;
                }
            });
        } finally {
            userRepository.dropTemporaryTable(tmpTableName);
        }
    }
}
