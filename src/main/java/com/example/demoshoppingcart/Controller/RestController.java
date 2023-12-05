package com.example.demoshoppingcart.Controller;

import com.example.demoshoppingcart.Entity.ProductEntity;
import com.example.demoshoppingcart.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("rest")
public class RestController {

    @Autowired
    ProductService productService;

    @GetMapping("/products")
    public List<ProductEntity> getAllpro(){
        return productService.getAll();
    }

    @PostMapping("/products")
    public List<ProductEntity> createRest(@RequestBody ProductEntity product){
        productService.create(product);
        return productService.getAll();
    }


}
