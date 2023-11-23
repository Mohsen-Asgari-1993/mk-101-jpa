package ir.maktabsharif101.jpaexample.repository.impl;

import ir.maktabsharif101.jpaexample.base.repository.BaseEntityRepositoryImpl;
import ir.maktabsharif101.jpaexample.domain.Address;
import ir.maktabsharif101.jpaexample.repository.AddressRepository;

import javax.persistence.EntityManager;

public class AddressRepositoryImpl extends BaseEntityRepositoryImpl<Address, Long> implements AddressRepository {

    public AddressRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    protected Class<Address> getEntityClass() {
        return Address.class;
    }
}
