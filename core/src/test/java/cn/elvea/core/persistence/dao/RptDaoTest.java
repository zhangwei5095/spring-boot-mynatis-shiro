package cn.elvea.core.persistence.dao;

import cn.elvea.core.test.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class RptDaoTest extends BaseTest {
    @Autowired
    RptDao rptDao;

    @Test
    public void test() {
        Assert.assertTrue(true);
    }
}
