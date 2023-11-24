package ir.maktabsharif101.jpaexample.base.repository.util;

public interface Pageable {

    int getPageNumber();

    int getPageSize();

    long getOffset();

    Pageable first();

    Pageable next();

    Pageable previous();

}
