package cn.elvea.core.persistence.repository;

import cn.elvea.core.domain.Role;
import cn.elvea.core.test.BaseTest;
import com.google.common.collect.Maps;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.annotation.Commit;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Transactional
@Commit
public class RoleRepositoryTest extends BaseTest {
    @Autowired
    RoleRepository roleRepository;

    @Test
    public void testCrud() {
        Role role = new Role();
        role.setCode(String.valueOf(new Date().getTime()));
        roleRepository.save(role);
        roleRepository.flush();
        Assert.assertNotNull(role.getId());
        roleRepository.delete(role.getId());
        roleRepository.flush();
    }

    @Test
    public void testExec() {
        Role role = roleRepository.findByCode("sysadmin");
        Assert.assertNotNull(role);

        roleRepository.execute("update Role r set r.description = '" + String.valueOf(new Date().getTime()) + "' ");

        Map<String, Object> params = Maps.newHashMap();
        params.put("desc", "Admin");
        params.put("id", 1l);
        roleRepository.execute("update Role r set r.description = :desc where r.id = :id ", params);

        roleRepository.execute("update Role r set r.description = ?0 where r.id = ?1 ", new Object[]{"MGR", 2l});

    }

    @Test
    public void testQueryForOject() {
        Role role = roleRepository.queryForObject(" select r from Role r where r.code = 'sysadmin'");
        Assert.assertNotNull(role);

        Map<String, Object> params = Maps.newHashMap();
        params.put("code", "sysadmin");
        role = roleRepository.queryForObject(" select r from Role r where r.code = :code", params);
        Assert.assertNotNull(role);

        role = roleRepository.queryForObject(" select r from Role r where r.code = ?0", new Object[]{"sysadmin"});
        Assert.assertNotNull(role);
    }

    @Test
    public void testQuery() {
        List<Role> roles = roleRepository.query(" select r from Role r ");
        Assert.assertTrue(roles.size() > 0);

        Map<String, Object> params = Maps.newHashMap();
        params.put("code", "sysadmin");
        roles = roleRepository.query(" select r from Role r where r.code = :code", params);
        Assert.assertTrue(roles.size() > 0);

        roles = roleRepository.query(" select r from Role r where r.code = ?0", new Object[]{"sysadmin"});
        Assert.assertTrue(roles.size() > 0);
    }

    @Test
    public void testQueryPage() {
        Pageable pageable = new PageRequest(0, 1);
        Page<Role> page = roleRepository.queryPage("select r from Role r order by r.id", pageable);
        Assert.assertTrue(page.getTotalElements() == 2);
        Assert.assertTrue(page.getContent().size() == 1);

        Map<String, Object> params = Maps.newHashMap();
        params.put("code", "sysadmin");
        page = roleRepository.queryPage("select r from Role r where code = :code order by r.id", pageable, params);
        Assert.assertTrue(page.getTotalElements() == 1);
        Assert.assertTrue(page.getContent().size() == 1);

        page = roleRepository.queryPage(" select r from Role r where r.code = ?0", pageable, new Object[]{"sysadmin"});
        Assert.assertTrue(page.getTotalElements() == 1);
        Assert.assertTrue(page.getContent().size() == 1);
    }
}
