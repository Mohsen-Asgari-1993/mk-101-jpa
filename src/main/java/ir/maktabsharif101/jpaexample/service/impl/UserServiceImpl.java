package ir.maktabsharif101.jpaexample.service.impl;

import ir.maktabsharif101.jpaexample.domain.BaseUser;
import ir.maktabsharif101.jpaexample.repository.UserRepository;
import ir.maktabsharif101.jpaexample.service.UserService;
import ir.maktabsharif101.jpaexample.service.base.BaseUserServiceImpl;

public class UserServiceImpl extends BaseUserServiceImpl<BaseUser, UserRepository> implements UserService {

    public UserServiceImpl(UserRepository baseRepository) {
        super(baseRepository);
    }
}
