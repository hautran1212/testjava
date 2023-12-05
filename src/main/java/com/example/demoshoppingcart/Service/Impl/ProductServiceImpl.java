package com.example.demoshoppingcart.Service.Impl;

import com.example.demoshoppingcart.Entity.ProductEntity;
import com.example.demoshoppingcart.Responsitory.ProductRepository;
import com.example.demoshoppingcart.Service.ProductService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;


    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;

    }


    @Override
    public List<ProductEntity> getAll() {
        return productRepository.findAll();
    }

    @Override
    public void create(ProductEntity product) {
        productRepository.save(product);
    }

    @Override
    public Optional<ProductEntity> findById(Long id) {
        return productRepository.findById(id);
    }

    @Override
    public void save(ProductEntity product) {
        productRepository.save(product);
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }


}
