package com.example.demoshoppingcart.Domain;

import com.example.demoshoppingcart.Entity.ProductEntity;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Component
@Scope(scopeName = "session", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class CartHolder {
    List<Cart> carts = new ArrayList<>();

    public List<Cart> getCarts(){
        return carts;
    }

    public void addToCart(ProductEntity product){
        Cart cart = carts.stream().filter(entity -> Objects.equals(entity.getProductEntity().getId(), product.getId())).findFirst().orElse(new Cart());

        if(cart.getAmount() <= 0){
            cart.setProductEntity(product);
            cart.setAmount(1);
            carts.add(cart);
            return;
        }
        cart.setAmount(cart.getAmount()+1);
    }

    public void removeCart(ProductEntity product){
        Cart cart = carts.stream().filter(entity -> Objects.equals(entity.getProductEntity().getId(), product.getId())).findFirst().orElse(new Cart());
        if (cart.getAmount() == 1){
            carts.remove(cart);
            return;
        }
        cart.setAmount(cart.getAmount()-1);
    }

}
