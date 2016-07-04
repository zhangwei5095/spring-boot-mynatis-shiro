package cn.elvea.commons.domain;

public abstract class AbstractEntity implements IdEntity {
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof IdEntity) {
            IdEntity entity = (IdEntity) obj;
            if (getId() != null && entity.getId() != null && getId().longValue() == entity.getId().longValue()) {
                return true;
            }
        }
        return false;
    }
}
