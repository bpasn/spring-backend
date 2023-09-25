package com.firstApp.firstApp.services;

import org.springframework.data.domain.Example;

public interface BaseService<T> {
    void delete(String id);
    void update(Example<T> example);
    void create(Example<T> example);

}
