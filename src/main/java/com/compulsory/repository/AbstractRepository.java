package com.compulsory.repository;

public interface AbstractRepository <T>{
    void create(T entity);
    void findById(T entity);
    void findByName(T entity);
}
