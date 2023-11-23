package ir.maktabsharif101.jpaexample.repository.impl;

import ir.maktabsharif101.jpaexample.base.repository.BaseEntityRepositoryImpl;
import ir.maktabsharif101.jpaexample.domain.Wallet;
import ir.maktabsharif101.jpaexample.repository.WalletRepository;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;

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
                "select w from Wallet w where w.customerId = :customerId",
                getEntityClass()
        );
        query.setParameter("customerId", customerId);
        return query.getSingleResult();
    }
}
