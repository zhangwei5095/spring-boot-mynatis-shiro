package cn.elvea.commons.persistence.mapper;

import cn.elvea.commons.domain.Role;
import cn.elvea.commons.test.BaseTest;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.List;

public class RoleMapperTest extends BaseTest {
    @Autowired
    private RoleMapper roleMapper;

    @Test
    public void test() {
        Pageable pageable = new PageRequest(1, 1);
        List<Role> list = this.roleMapper.findByPage(pageable);
        Assert.assertTrue(list.size() == 1);
    }
}
