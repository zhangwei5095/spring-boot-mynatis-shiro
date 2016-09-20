package cn.elvea.repository;

import cn.elvea.commons.persistence.repository.BaseEntityRepository;
import cn.elvea.domain.Attachment;
import org.springframework.stereotype.Repository;

@Repository
public interface AttachmentRepository extends BaseEntityRepository<Attachment, Long> {
}
