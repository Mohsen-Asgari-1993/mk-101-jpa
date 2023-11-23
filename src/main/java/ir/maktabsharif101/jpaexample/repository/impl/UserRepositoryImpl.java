package ir.maktabsharif101.jpaexample.repository.impl;

import ir.maktabsharif101.jpaexample.domain.BaseUser;
import ir.maktabsharif101.jpaexample.repository.UserRepository;
import ir.maktabsharif101.jpaexample.repository.base.BaseUserRepositoryImpl;

import javax.persistence.EntityManager;

public class UserRepositoryImpl extends BaseUserRepositoryImpl<BaseUser> implements UserRepository {

    public UserRepositoryImpl(EntityManager entityManager) {
        super(entityManager);
    }

    @Override
    protected Class<BaseUser> getEntityClass() {
        return BaseUser.class;
    }
}
