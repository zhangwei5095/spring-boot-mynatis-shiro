package cn.elvea.persistence.jdbc.dao;

import cn.elvea.test.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class JdbcUserDaoTests extends BaseTest {
    @Autowired
    JdbcUserDao jdbcUserDao;

    @Test
    public void test() {
        Assert.assertTrue(true);
    }
}
