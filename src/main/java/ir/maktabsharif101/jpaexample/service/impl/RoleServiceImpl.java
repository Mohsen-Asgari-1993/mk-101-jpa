package ir.maktabsharif101.jpaexample.service.impl;

import ir.maktabsharif101.jpaexample.base.service.BaseEntityServiceImpl;
import ir.maktabsharif101.jpaexample.domain.Role;
import ir.maktabsharif101.jpaexample.repository.RoleRepository;
import ir.maktabsharif101.jpaexample.service.RoleService;

public class RoleServiceImpl extends BaseEntityServiceImpl<Role, Long, RoleRepository>
        implements RoleService {

    public RoleServiceImpl(RoleRepository baseRepository) {
        super(baseRepository);
    }
}
