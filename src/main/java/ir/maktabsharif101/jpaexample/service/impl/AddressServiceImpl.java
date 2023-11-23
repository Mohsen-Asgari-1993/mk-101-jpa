package ir.maktabsharif101.jpaexample.service.impl;

import ir.maktabsharif101.jpaexample.base.service.BaseEntityServiceImpl;
import ir.maktabsharif101.jpaexample.domain.Address;
import ir.maktabsharif101.jpaexample.repository.AddressRepository;
import ir.maktabsharif101.jpaexample.service.AddressService;

public class AddressServiceImpl extends BaseEntityServiceImpl<Address, Long, AddressRepository>
        implements AddressService {

    public AddressServiceImpl(AddressRepository baseRepository) {
        super(baseRepository);
    }
}
