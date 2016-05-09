package cn.elvea.persistence.jpa.repository;

import cn.elvea.entity.User;
import cn.elvea.test.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

public class JpaUserRepositoryTests extends BaseTest {
    @Autowired
    JpaUserRepository jpaUserRepository;

    @Test
    @Transactional
    @Commit
    public void test() {
        User user = new User();
        user.setUsername("test");
        jpaUserRepository.save(user);

        user = jpaUserRepository.findByUsername("test");
        Assert.assertNotNull(user);
        Assert.assertNotNull(user.getId());

        jpaUserRepository.delete(user.getId());

        user = jpaUserRepository.findByUsername("test");
        Assert.assertNull(user);
    }
}
