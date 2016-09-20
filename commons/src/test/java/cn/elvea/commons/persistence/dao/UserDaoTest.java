package cn.elvea.commons.persistence.dao;

import cn.elvea.commons.test.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class UserDaoTest extends BaseTest {
    @Autowired
    UserDao userDao;

    @Test
    public void test() {
        Assert.assertTrue(true);
    }
}
