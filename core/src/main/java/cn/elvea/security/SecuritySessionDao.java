package cn.elvea.security;

import cn.elvea.service.UserSessionService;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.eis.CachingSessionDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.Serializable;

public class SecuritySessionDao extends CachingSessionDAO {
    private static Logger logger = LoggerFactory.getLogger(SecuritySessionDao.class);

    @Autowired
    UserSessionService userSessionService;

    @Override
    protected Serializable doCreate(Session session) {
        logger.debug("do create session");
        Serializable sessionId = generateSessionId(session);
        assignSessionId(session, sessionId);

        userSessionService.createUserSession(session);
        return sessionId;
    }

    @Override
    protected void doDelete(Session session) {
        logger.debug("do delete session");
        userSessionService.deleteUserSession(session);
    }

    @Override
    protected void doUpdate(Session session) {
        logger.debug("do update session");
        userSessionService.updateUserSession(session);
    }

    @Override
    protected Session doReadSession(Serializable sessionId) {
        logger.debug("do read session");
        return userSessionService.findBySessionId(sessionId);
    }
}
