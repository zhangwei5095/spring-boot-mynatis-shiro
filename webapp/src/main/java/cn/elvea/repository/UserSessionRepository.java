package cn.elvea.repository;

import cn.elvea.domain.UserSession;

import java.io.Serializable;

public interface UserSessionRepository extends EntityRepository<UserSession> {
    UserSession findBySessionId(Serializable sessionId);
}
