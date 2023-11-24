package ir.maktabsharif101.jpaexample.base.repository.util;

public class PageRequest implements Pageable {

    private final int page;

    private final int size;

    protected PageRequest(int page, int size) {
        if (page < 0) {
            throw new IllegalArgumentException("Page index must not be less than zero");
        }
        if (size < 1) {
            throw new IllegalArgumentException("Page size must not be less than one");
        }
        this.page = page;
        this.size = size;
    }

    public static PageRequest of(int page, int size) {
        return new PageRequest(page, size);
    }

    @Override
    public int getPageNumber() {
        return page;
    }

    @Override
    public int getPageSize() {
        return size;
    }

    @Override
    public long getOffset() {
        return (long) page * size;
    }

    @Override
    public Pageable first() {
        return new PageRequest(0, getPageSize());
    }

    @Override
    public Pageable next() {
        return new PageRequest(getPageNumber() + 1, getPageSize());
    }

    @Override
    public Pageable previous() {
        return getPageNumber() == 0 ? this : new PageRequest(getPageNumber() - 1, getPageSize());
    }
}
