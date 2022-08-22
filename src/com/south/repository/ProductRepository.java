package com.south.repository;

import com.south.entity.Product;

import java.util.List;

public interface ProductRepository {
    public List<Product> findAll(int index, int limit);
    public int count();

}
