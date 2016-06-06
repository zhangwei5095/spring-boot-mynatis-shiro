package cn.elvea.repository;

import cn.elvea.core.persistence.repository.BaseEntityRepository;
import cn.elvea.domain.UserSession;
import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface UserSessionRepository extends BaseEntityRepository<UserSession, Long> {
    UserSession findBySessionId(Serializable sessionId);
}
