package ir.maktabsharif101.jpaexample.repository.impl;

import ir.maktabsharif101.jpaexample.base.repository.BaseEntityRepositoryImpl;
import ir.maktabsharif101.jpaexample.domain.Role;
import ir.maktabsharif101.jpaexample.repository.RoleRepository;

import javax.persistence.EntityManager;

public class RoleRepositoryImpl extends BaseEntityRepositoryImpl<Role, Long> implements RoleRepository {

    public RoleRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    protected Class<Role> getEntityClass() {
        return Role.class;
    }
}
