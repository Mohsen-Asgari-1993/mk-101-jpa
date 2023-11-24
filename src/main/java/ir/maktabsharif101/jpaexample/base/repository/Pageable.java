package ir.maktabsharif101.jpaexample.base.repository;

public interface Pageable {

    int getPageNumber();

    int getPageSize();

    long getOffset();

    Pageable first();

    Pageable next();

    Pageable previous();

}
