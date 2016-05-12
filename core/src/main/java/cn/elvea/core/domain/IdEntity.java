package cn.elvea.core.domain;

import java.io.Serializable;

public interface IdEntity extends Serializable {
    void setId(Long id);

    Long getId();
}
