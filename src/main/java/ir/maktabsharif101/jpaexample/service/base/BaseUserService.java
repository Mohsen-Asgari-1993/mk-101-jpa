package ir.maktabsharif101.jpaexample.service.base;

import ir.maktabsharif101.jpaexample.base.service.BaseEntityService;
import ir.maktabsharif101.jpaexample.domain.BaseUser;

import java.util.Optional;

public interface BaseUserService<T extends BaseUser> extends BaseEntityService<T, Long> {

    boolean existsByUsername(String username);

    boolean existsByMobileNumber(String mobileNumber);

    Optional<T> findByUsername(String username);
}
