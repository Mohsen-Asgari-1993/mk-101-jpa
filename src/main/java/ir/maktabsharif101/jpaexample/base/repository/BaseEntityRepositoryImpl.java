package ir.maktabsharif101.jpaexample.base.repository;

import ir.maktabsharif101.jpaexample.base.domain.BaseEntity;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public abstract class BaseEntityRepositoryImpl<T extends BaseEntity<ID>, ID extends Serializable>
        implements BaseEntityRepository<T, ID> {

    protected final EntityManager entityManager;

    @Override
    public T save(T t) {
//        beginTransaction();
        if (t.getId() == null) {
            entityManager.persist(t);
        } else {
            t = entityManager.merge(t);
        }
//        commitTransaction();
        return t;
    }

    @Override
    public List<T> findAll() {
        TypedQuery<T> query = entityManager.createQuery(
                "from " + getEntityClass().getSimpleName(),
                getEntityClass()
        );
        return query.getResultList();
    }

    @Override
    public long count() {
        return entityManager.createQuery(
                "select count(t) from " + getEntityClass().getSimpleName() + " t",
                Long.class
        ).getSingleResult();
    }

    @Override
    public Optional<T> findById(ID id) {
        return Optional.ofNullable(
                entityManager.find(getEntityClass(), id)
        );
    }

    @Override
    public void deleteAll() {
//        beginTransaction();
        entityManager.createQuery(
                "delete from " + getEntityClass().getSimpleName()
        ).executeUpdate();
//        commitTransaction();
    }

    @Override
    public void deleteById(ID id) {
//        beginTransaction();
        Optional<T> optional = findById(id);
        optional.ifPresent(entityManager::remove);
//        commitTransaction();
    }

    @Override
    public boolean existsById(ID id) {
        TypedQuery<Long> query = entityManager.createQuery(
                "select count(t) from " + getEntityClass().getSimpleName() + " t where t.id = :id", Long.class
        );
        query.setParameter("id", id);
        return query.getSingleResult() > 0;
    }

    @Override
    public void beginTransaction() {
        EntityTransaction transaction = entityManager.getTransaction();
        if (!transaction.isActive()) {
            transaction.begin();
        }
    }

    @Override
    public void commitTransaction() {
        EntityTransaction transaction = entityManager.getTransaction();
        if (transaction.isActive()) {
            transaction.commit();
        }
    }

    @Override
    public void rollbackTransaction() {
        EntityTransaction transaction = entityManager.getTransaction();
        if (transaction.isActive()) {
            transaction.rollback();
        }
    }

    protected abstract Class<T> getEntityClass();

}
