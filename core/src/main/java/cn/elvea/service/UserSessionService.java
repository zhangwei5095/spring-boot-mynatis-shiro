package cn.elvea.service;

import cn.elvea.commons.service.BaseEntityService;
import cn.elvea.domain.UserSession;
import org.apache.shiro.session.Session;

import java.io.Serializable;

public interface UserSessionService extends BaseEntityService<UserSession, Long> {
    Session findBySessionId(Serializable sessionId);

    void createUserSession(Session session);

    void deleteUserSession(Session session);

    void updateUserSession(Session session);
}
