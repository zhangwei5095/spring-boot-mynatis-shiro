package cn.elvea.persistence.jpa.repository;

import cn.elvea.test.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class JpaRoleRepositoryTests extends BaseTest {
    @Autowired
    JpaRoleRepository jpaRoleRepository;

    @Test
    public void test() {
        Assert.assertTrue(true);
    }
}
