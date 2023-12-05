package com.example.demoshoppingcart.Service;

import com.example.demoshoppingcart.Entity.ProductEntity;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    List<ProductEntity> getAll();
    void create(ProductEntity product);

    Optional<ProductEntity> findById(Long id);
    void save(ProductEntity product);

    void deleteById(Long id);
}
