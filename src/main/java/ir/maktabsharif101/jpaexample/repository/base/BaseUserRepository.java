package ir.maktabsharif101.jpaexample.repository.base;

import ir.maktabsharif101.jpaexample.base.repository.BaseEntityRepository;
import ir.maktabsharif101.jpaexample.domain.BaseUser;

import java.util.Optional;

public interface BaseUserRepository<T extends BaseUser> extends BaseEntityRepository<T, Long> {

    boolean existsByUsername(String username);

    boolean existsByMobileNumber(String mobileNumber);

    Optional<T> findByUsername(String username);
}
