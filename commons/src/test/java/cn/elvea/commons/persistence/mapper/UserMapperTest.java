package cn.elvea.commons.persistence.mapper;


import cn.elvea.commons.domain.User;
import cn.elvea.commons.test.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class UserMapperTest extends BaseTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void test() {
        Pageable pageable = new PageRequest(1, 1);
        List<User> list = this.userMapper.findByPage(pageable);
        Assert.assertTrue(list.size() == 1);
    }
}
