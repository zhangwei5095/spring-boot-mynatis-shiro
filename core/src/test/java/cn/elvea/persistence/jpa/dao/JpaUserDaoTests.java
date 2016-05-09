package cn.elvea.persistence.jpa.dao;

import cn.elvea.test.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class JpaUserDaoTests extends BaseTest {
    @Autowired
    JpaUserDao jpaUserDao;

    @Test
    public void test() {
        Assert.assertTrue(true);
    }
}
