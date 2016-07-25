package cn.elvea.service.impl;

import cn.elvea.commons.persistence.repository.BaseEntityRepository;
import cn.elvea.commons.service.jpa.BaseEntityServiceImpl;
import cn.elvea.domain.Attachment;
import cn.elvea.repository.AttachmentRepository;
import cn.elvea.service.AttachmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class AttachmentServiceImpl extends BaseEntityServiceImpl<Attachment, Long> implements AttachmentService {

    @Autowired
    AttachmentRepository attachmentRepository;

    @Override
    protected BaseEntityRepository<Attachment, Long> getEntityRepository() {
        return attachmentRepository;
    }
}
