package ir.maktabsharif101.jpaexample.repository.impl;

import ir.maktabsharif101.jpaexample.base.repository.BaseEntityRepositoryImpl;
import ir.maktabsharif101.jpaexample.domain.Wallet;
import ir.maktabsharif101.jpaexample.repository.WalletRepository;

import javax.persistence.EntityManager;

public class WalletRepositoryImpl extends BaseEntityRepositoryImpl<Wallet, Long> implements WalletRepository {

    public WalletRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    protected Class<Wallet> getEntityClass() {
        return Wallet.class;
    }
}
