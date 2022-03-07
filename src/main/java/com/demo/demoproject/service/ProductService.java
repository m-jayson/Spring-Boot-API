package com.demo.demoproject.service;

import com.demo.demoproject.model.Product;

import java.util.List;

public interface ProductService<ID extends Long,T extends Product> {
    ID add(T product);
    void modify(ID id,T product);
    void delete(ID id);
    List<T> all();
    T find(ID id);
}
