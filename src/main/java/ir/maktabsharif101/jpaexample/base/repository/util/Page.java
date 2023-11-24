package ir.maktabsharif101.jpaexample.base.repository.util;

import java.util.List;

public interface Page<T> {

    List<T> getContent();

    Pageable getPageable();

    long getTotalElements();

    long getTotalPages();

}
