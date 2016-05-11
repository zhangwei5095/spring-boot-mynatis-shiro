package cn.elvea.persistence.repository;

import cn.elvea.entity.User;
import cn.elvea.test.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

public class UserRepositoryTests extends BaseTest {
    @Autowired
    UserRepository userRepository;

    @Test
    @Transactional
    @Commit
    public void test() {
        User user = new User();
        user.setUsername("test");
        userRepository.save(user);

        user = userRepository.findByUsername("test");
        Assert.assertNotNull(user);
        Assert.assertNotNull(user.getId());

        userRepository.delete(user.getId());

        user = userRepository.findByUsername("test");
        Assert.assertNull(user);
    }
}
