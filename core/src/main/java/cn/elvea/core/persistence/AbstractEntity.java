package cn.elvea.core.persistence;

public abstract class AbstractEntity implements IdEntity {
    @Override
    public boolean equals(Object obj) {
        if (obj instanceof IdEntity) {
            IdEntity entity = (IdEntity) obj;
            return (getId() != null && entity.getId() != null && getId().longValue() == entity.getId().longValue());
        }
        return false;
    }
}
