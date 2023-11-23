package ir.maktabsharif101.jpaexample.service.impl;

import ir.maktabsharif101.jpaexample.base.service.BaseEntityServiceImpl;
import ir.maktabsharif101.jpaexample.domain.Permission;
import ir.maktabsharif101.jpaexample.repository.PermissionRepository;
import ir.maktabsharif101.jpaexample.service.PermissionService;

public class PermissionServiceImpl extends BaseEntityServiceImpl<Permission, Long, PermissionRepository>
        implements PermissionService {

    public PermissionServiceImpl(PermissionRepository baseRepository) {
        super(baseRepository);
    }
}
