package cn.elvea.service;

import cn.elvea.commons.persistence.repository.BaseEntityRepository;
import cn.elvea.commons.service.BaseEntityService;
import cn.elvea.domain.User;
import cn.elvea.repository.UserRepository;
import cn.elvea.security.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.Assert;

@Service
@Transactional
public class UserService extends BaseEntityService<User, Long> {
    @Autowired
    private UserRepository userRepository;

    @Override
    protected BaseEntityRepository<User, Long> getEntityRepository() {
        return this.userRepository;
    }

    public User findByUsername(String username) {
        return userRepository.findByEmployeeNumber(username);
    }

    public String encryptPassword(String plainPassword, String salt) {
        Assert.notNull(plainPassword, "plainPassword can not be null.");
        Assert.notNull(salt, "salt can not be null.");

        return SecurityUtils.entryptPassword(plainPassword, salt);
    }

    public String encryptPassword(User user) {
        Assert.notNull(user, "User can not be null.");
        return encryptPassword(user.getEmployeeNumber(), user.getAgentEmployeeNumber());
    }
}
