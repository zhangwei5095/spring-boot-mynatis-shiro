package cn.elvea.service;

import cn.elvea.commons.service.BaseEntityService;
import cn.elvea.domain.User;

public interface UserService extends BaseEntityService<User, Long> {
    User findByUsername(String username);

    String encryptPassword(String plainPassword, String salt);

    String encryptPassword(User user);
}
