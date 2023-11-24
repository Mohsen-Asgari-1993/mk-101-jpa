package ir.maktabsharif101.jpaexample.repository.impl;

import ir.maktabsharif101.jpaexample.base.repository.BaseEntityRepositoryImpl;
import ir.maktabsharif101.jpaexample.domain.Wallet;
import ir.maktabsharif101.jpaexample.repository.WalletRepository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.List;

public class WalletRepositoryImpl extends BaseEntityRepositoryImpl<Wallet, Long> implements WalletRepository {

    public WalletRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    protected Class<Wallet> getEntityClass() {
        return Wallet.class;
    }

    @Override
    public Wallet findByCustomerId(Long customerId) {
        TypedQuery<Wallet> query = entityManager.createQuery(
                "select w from Wallet w where w.customer.id = :customerId",
                getEntityClass()
        );
        query.setParameter("customerId", customerId);
        return query.getSingleResult();
    }

    @Override
    public List<Wallet> findAll() {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Wallet> query = criteriaBuilder.createQuery(getEntityClass());
        Root<Wallet> root = query.from(getEntityClass());
        query.select(root);

        TypedQuery<Wallet> typedQuery = entityManager.createQuery(query);

        typedQuery.setHint(
                "javax.persistence.fetchgraph",
                entityManager.getEntityGraph(Wallet.ENTITY_GRAPH)
        );
//        typedQuery.setHint(
//                "javax.persistence.loadgraph", entityGraph
//        );
        return typedQuery.getResultList();
    }
}
