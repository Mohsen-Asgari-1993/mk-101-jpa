package ir.maktabsharif101.jpaexample.base.repository.util;

import java.util.List;

public class PageImpl<T> implements Page<T> {

    private final List<T> content;

    private final Pageable pageable;

    private final long totalElements;

    public PageImpl(List<T> content, Pageable pageable, long totalElements) {
        this.content = content;
        this.pageable = pageable;
        this.totalElements = totalElements;
    }

    @Override
    public List<T> getContent() {
        return content;
    }

    @Override
    public Pageable getPageable() {
        return pageable;
    }

    @Override
    public long getTotalElements() {
        return totalElements;
    }

    @Override
    public long getTotalPages() {
        return (long) Math.ceil((double) getTotalElements() / pageable.getPageSize());
    }

    @Override
    public String toString() {
        return "PageImpl{" +
                "content=" + content +
                ", pageable=" + pageable +
                ", totalElements=" + totalElements +
                ", totalPages=" + getTotalPages() +
                '}';
    }
}
