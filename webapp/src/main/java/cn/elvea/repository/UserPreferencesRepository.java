package cn.elvea.repository;

import cn.elvea.core.persistence.repository.BaseEntityRepository;
import cn.elvea.domain.UserPreferences;
import org.springframework.stereotype.Repository;

@Repository
public interface UserPreferencesRepository extends BaseEntityRepository<UserPreferences, Long> {
}
