package ir.maktabsharif101.jpaexample.base.service;

import ir.maktabsharif101.jpaexample.base.domain.BaseEntity;
import ir.maktabsharif101.jpaexample.base.repository.BaseEntityRepository;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
public class BaseEntityServiceImpl<T extends BaseEntity<ID>, ID extends Serializable,
        R extends BaseEntityRepository<T, ID>>
        implements BaseEntityService<T, ID> {

    protected final R baseRepository;

    @Override
    public T save(T t) {
        return baseRepository.save(t);
    }

    @Override
    public List<T> findAll() {
        return baseRepository.findAll();
    }

    @Override
    public long count() {
        return baseRepository.count();
    }

    @Override
    public Optional<T> findById(ID id) {
        return baseRepository.findById(id);
    }

    @Override
    public void deleteAll() {
        baseRepository.beginTransaction();
        baseRepository.deleteAll();
        baseRepository.commitTransaction();
    }

    @Override
    public void deleteById(ID id) {
        baseRepository.beginTransaction();
        baseRepository.deleteById(id);
        baseRepository.commitTransaction();
    }

    @Override
    public boolean existsById(ID id) {
        return baseRepository.existsById(id);
    }
}
