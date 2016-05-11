package cn.elvea.persistence.dao;

import cn.elvea.test.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class RptDaoTests extends BaseTest {
    @Autowired
    RptDao jdbcRptDao;

    @Test
    public void test() {
        Assert.assertTrue(true);
    }
}
