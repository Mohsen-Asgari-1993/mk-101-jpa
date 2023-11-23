package ir.maktabsharif101.jpaexample.repository.impl;

import ir.maktabsharif101.jpaexample.base.repository.BaseEntityRepositoryImpl;
import ir.maktabsharif101.jpaexample.domain.Permission;
import ir.maktabsharif101.jpaexample.repository.PermissionRepository;

import javax.persistence.EntityManager;

public class PermissionRepositoryImpl extends BaseEntityRepositoryImpl<Permission, Long> implements PermissionRepository {

    public PermissionRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    protected Class<Permission> getEntityClass() {
        return Permission.class;
    }
}
