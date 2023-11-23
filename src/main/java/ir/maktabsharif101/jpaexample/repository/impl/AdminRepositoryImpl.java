package ir.maktabsharif101.jpaexample.repository.impl;

import ir.maktabsharif101.jpaexample.domain.Admin;
import ir.maktabsharif101.jpaexample.repository.AdminRepository;
import ir.maktabsharif101.jpaexample.repository.base.BaseUserRepositoryImpl;

import javax.persistence.EntityManager;

public class AdminRepositoryImpl extends BaseUserRepositoryImpl<Admin> implements AdminRepository {

    public AdminRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    protected Class<Admin> getEntityClass() {
        return Admin.class;
    }
}
