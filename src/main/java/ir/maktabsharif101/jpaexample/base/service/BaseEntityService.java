package ir.maktabsharif101.jpaexample.base.service;

import ir.maktabsharif101.jpaexample.base.domain.BaseEntity;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

public interface BaseEntityService<T extends BaseEntity<ID>, ID extends Serializable> {

    T save(T t);

    List<T> findAll();

    long count();

    Optional<T> findById(ID id);

    void deleteAll();

    void deleteById(ID id);

    boolean existsById(ID id);

//    TODO add page and sort query

}
