package ir.maktabsharif101.jpaexample.service.base;

import ir.maktabsharif101.jpaexample.base.service.BaseEntityServiceImpl;
import ir.maktabsharif101.jpaexample.domain.BaseUser;
import ir.maktabsharif101.jpaexample.repository.base.BaseUserRepository;

import java.util.Optional;

public class BaseUserServiceImpl<T extends BaseUser, R extends BaseUserRepository<T>>
        extends BaseEntityServiceImpl<T, Long, R> implements BaseUserService<T> {

    public BaseUserServiceImpl(R baseRepository) {
        super(baseRepository);
    }

    @Override
    public boolean existsByUsername(String username) {
        return baseRepository.existsByUsername(username);
    }

    @Override
    public boolean existsByMobileNumber(String mobileNumber) {
        return baseRepository.existsByMobileNumber(mobileNumber);
    }

    @Override
    public Optional<T> findByUsername(String username) {
        return baseRepository.findByUsername(username);
    }
}
