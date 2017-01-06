package com.hand.dto;

import java.util.List;

public class Page<T>{
    private int page;
    private int pageSize;
    private T entity;


    public int getPage() {
        return page;
    }

    public Page setPage(int page) {
        this.page = page;
        return this;
    }

    public int getPageSize() {
        return pageSize;
    }

    public Page setPageSize(int pageSize) {
        this.pageSize = pageSize;
        return this;
    }

    public int getOffset() {
        return (page - 1) * pageSize;
    }

    public T getEntity() {
        return entity;
    }

    public Page setEntity(T entity) {
        this.entity = entity;
        return this;
    }
}
