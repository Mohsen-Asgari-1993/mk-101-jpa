package ir.maktabsharif101.jpaexample.repository.base;

import ir.maktabsharif101.jpaexample.base.repository.BaseEntityRepositoryImpl;
import ir.maktabsharif101.jpaexample.domain.BaseUser;

import javax.persistence.EntityManager;
import javax.persistence.NonUniqueResultException;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public abstract class BaseUserRepositoryImpl<T extends BaseUser>
        extends BaseEntityRepositoryImpl<T, Long> implements BaseUserRepository<T> {

    public BaseUserRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    public boolean existsByUsername(String username) {
        TypedQuery<Long> query = entityManager.createQuery(
                "select count(u) from " + getEntityClass().getSimpleName() + " u where u.username = :username",
                Long.class
        );
        query.setParameter("username", username);
        return query.getSingleResult() > 0;
    }

    @Override
    public boolean existsByMobileNumber(String mobileNumber) {
        TypedQuery<Long> query = entityManager.createQuery(
                "select count(u) from " + getEntityClass().getSimpleName() + " u where u.mobileNumber = :mobileNumber",
                Long.class
        );
        query.setParameter("mobileNumber", mobileNumber);
        return query.getSingleResult() > 0;
    }

    @Override
    public Optional<T> findByUsername(String username) {
        TypedQuery<T> query = entityManager.createQuery(
                "select u from " + getEntityClass().getSimpleName() + " u where u.username = :username",
                getEntityClass()
        );
        query.setParameter("username", username);
        List<T> resultList = query.getResultList();
        if (resultList.size() == 1) {
            return Optional.of(
                    resultList.get(0)
            );
        } else if (resultList.size() == 0) {
            return Optional.empty();
        }
        throw new NonUniqueResultException();
    }
}
