package com.example.demoshoppingcart.Domain;

import com.example.demoshoppingcart.Entity.ProductEntity;

public class Cart {
    private ProductEntity productEntity;
    private Integer amount = 0;

    public ProductEntity getProductEntity() {
        return productEntity;
    }

    public void setProductEntity(ProductEntity productEntity) {
        this.productEntity = productEntity;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }
}
