package com.example.demoshoppingcart.Responsitory;

import com.example.demoshoppingcart.Entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {

}
