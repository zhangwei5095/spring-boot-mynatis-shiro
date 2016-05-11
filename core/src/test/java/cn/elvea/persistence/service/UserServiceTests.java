package cn.elvea.persistence.service;

import cn.elvea.test.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.sql.SQLException;

@Transactional
@Commit
public class UserServiceTests extends BaseTest {
    @Autowired
    UserService userService;

    @Test
    public void testNativeWork() throws SQLException {
        Assert.assertTrue(userService.testNativeWork() > 0);
    }

    @Test
    public void testWork() throws SQLException {
        Assert.assertTrue(userService.testWork() > 0);
    }

    @Test
    public void testCreateSimpleTempTable() throws SQLException {
        Assert.assertTrue(userService.testCreateSimpleTempTable() > 0);
    }

    @Test
    public void testCreateTempTable() throws SQLException {
        Assert.assertTrue(userService.testCreateTempTable() > 0);
    }
}
