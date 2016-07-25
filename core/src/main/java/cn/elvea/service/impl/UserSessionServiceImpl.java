package cn.elvea.service.impl;

import cn.elvea.commons.persistence.repository.BaseEntityRepository;
import cn.elvea.commons.service.jpa.BaseEntityServiceImpl;
import cn.elvea.domain.UserSession;
import cn.elvea.repository.UserSessionRepository;
import cn.elvea.security.filter.CaptchaAuthFilter;
import cn.elvea.service.UserSessionService;
import org.apache.shiro.session.Session;
import org.apache.shiro.session.mgt.SimpleSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Date;

@Service
@Transactional
public class UserSessionServiceImpl extends BaseEntityServiceImpl<UserSession, Long> implements UserSessionService {
    @Autowired
    UserSessionRepository userSessionRepository;

    @Override
    public BaseEntityRepository<UserSession, Long> getEntityRepository() {
        return userSessionRepository;
    }

    public Session findBySessionId(Serializable sessionId) {
        UserSession userSession = userSessionRepository.findBySessionId(sessionId);
        return coverUserSessionToSession(userSession);
    }

    public void createUserSession(Session session) {
        UserSession userSession = coverSessionToUserSession(session);
        if (userSession != null) {
            if (session.getAttribute(CaptchaAuthFilter.Shiro_Session_Username_Key) != null) {
                String username = (String) session.getAttribute(CaptchaAuthFilter.Shiro_Session_Username_Key);
                userSession.setUsername(username);
            }
            userSessionRepository.save(userSession);
        }
    }

    public void deleteUserSession(Session session) {
        UserSession userSession = userSessionRepository.findBySessionId(String.valueOf(session.getId()));
        if (userSession != null) {
            if (session.getAttribute(CaptchaAuthFilter.Shiro_Session_Username_Key) != null) {
                String username = (String) session.getAttribute(CaptchaAuthFilter.Shiro_Session_Username_Key);
                userSession.setUsername(username);
            }
            userSession.setEndDatetime(new Date());
            userSessionRepository.save(userSession);
        }
    }

    public void updateUserSession(Session session) {
        UserSession userSession = userSessionRepository.findBySessionId(String.valueOf(session.getId()));
        if (userSession != null) {
            if (session.getAttribute(CaptchaAuthFilter.Shiro_Session_Username_Key) != null) {
                String username = (String) session.getAttribute(CaptchaAuthFilter.Shiro_Session_Username_Key);
                userSession.setUsername(username);
            }
            userSession.setLastAccessDatetime(new Date());
            userSessionRepository.save(userSession);
        }
    }

    private UserSession coverSessionToUserSession(Session session) {
        UserSession userSession = new UserSession();
        userSession.setSessionId(String.valueOf(session.getId()));
        userSession.setLastAccessDatetime(session.getLastAccessTime());
        userSession.setHost(session.getHost());
        userSession.setStartDatetime(session.getStartTimestamp());
        return userSession;
    }

    private Session coverUserSessionToSession(UserSession userSession) {
        SimpleSession session = new SimpleSession();
        session.setId(userSession.getId());
        session.setLastAccessTime(userSession.getLastAccessDatetime());
        session.setHost(userSession.getHost());
        session.setStartTimestamp(userSession.getStartDatetime());
        return session;
    }
}
