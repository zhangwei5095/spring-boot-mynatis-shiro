package cn.elvea.core.persistence.jpa.repository;

import org.springframework.data.jpa.repository.support.JpaEntityInformation;
import org.springframework.data.jpa.repository.support.JpaEntityInformationSupport;
import org.springframework.data.jpa.repository.support.SimpleJpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

import javax.persistence.EntityManager;
import java.io.Serializable;

@NoRepositoryBean
public class BaseRepositoryImpl<T, PK extends Serializable> extends SimpleJpaRepository<T, PK> implements BaseRepository<T, PK> {
    private EntityManager entityManager = null;
    private JpaEntityInformation<T, ?> entityInformation = null;

    public BaseRepositoryImpl(JpaEntityInformation<T, ?> entityInformation, EntityManager entityManager) {
        super(entityInformation, entityManager);

        this.entityManager = entityManager;
        this.entityInformation = entityInformation;
    }

    public BaseRepositoryImpl(Class<T> domainClass, EntityManager entityManager) {
        this(JpaEntityInformationSupport.getEntityInformation(domainClass, entityManager), entityManager);
    }

    @Override
    public void test() {
        System.out.println("........");
    }
}
