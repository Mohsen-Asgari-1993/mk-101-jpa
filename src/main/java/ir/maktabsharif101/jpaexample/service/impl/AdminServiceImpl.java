package ir.maktabsharif101.jpaexample.service.impl;

import ir.maktabsharif101.jpaexample.domain.Admin;
import ir.maktabsharif101.jpaexample.repository.AdminRepository;
import ir.maktabsharif101.jpaexample.service.AdminService;
import ir.maktabsharif101.jpaexample.service.base.BaseUserServiceImpl;

public class AdminServiceImpl extends BaseUserServiceImpl<Admin, AdminRepository> implements AdminService {

    public AdminServiceImpl(AdminRepository baseRepository) {
        super(baseRepository);
    }
}
