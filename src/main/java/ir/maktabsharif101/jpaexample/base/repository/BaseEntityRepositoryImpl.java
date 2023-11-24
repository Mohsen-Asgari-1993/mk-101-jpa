package ir.maktabsharif101.jpaexample.base.repository;

import ir.maktabsharif101.jpaexample.base.domain.BaseEntity;
import lombok.RequiredArgsConstructor;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
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
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> query = criteriaBuilder.createQuery(getEntityClass());
        Root<T> root = query.from(getEntityClass());
        query.select(root);
        return entityManager.createQuery(query).getResultList();
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
    public Page<T> findAll(Pageable pageable) {

        if (pageable == null) {
            throw new RuntimeException("pageable is null");
        }

        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<T> query = criteriaBuilder.createQuery(getEntityClass());
        Root<T> root = query.from(getEntityClass());
        query.select(root);
        TypedQuery<T> typedQuery = entityManager.createQuery(query);
        typedQuery.setFirstResult((int) pageable.getOffset())
                .setMaxResults(pageable.getPageSize());
        List<T> content = typedQuery.getResultList();

        return new Page<T>() {
            @Override
            public List<T> getContent() {
                return content;
            }

            @Override
            public Pageable getPageable() {
                return pageable;
            }

            @Override
            public long getTotalElements() {
                return count();
            }

            @Override
            public long getTotalPages() {
                return (long) Math.ceil((double) getTotalElements() / pageable.getPageSize());
            }
        };
    }

    protected abstract Class<T> getEntityClass();

}
