package com.example.demoshoppingcart.Controller;

import com.example.demoshoppingcart.Domain.Cart;
import com.example.demoshoppingcart.Domain.CartHolder;
import com.example.demoshoppingcart.Entity.ProductEntity;
import com.example.demoshoppingcart.Service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("cart")

public class CartController {
    @Autowired
    private CartHolder cartHolder;

    @Autowired
    private ProductService productService;

    @GetMapping
    public String showCart(Model model){
        model.addAttribute("cart", cartHolder.getCarts());
        return "Cart";
    }


    @PostMapping
    public String addToCart(@ModelAttribute ProductEntity product, Model model){
        System.out.println("id: "+ product.getId());
        System.out.println("name: "+ product.getName());
        cartHolder.addToCart(product);
        List<ProductEntity> products = productService.getAll();
        model.addAttribute("products", products);
        return "ProductList";
    }
    @PostMapping("addOrRemove")
    public ModelAndView addOrRemove(@ModelAttribute Cart cart, @RequestParam String action){
        ProductEntity product = new ProductEntity();
        product.setId(cart.getProductEntity().getId());
        product.setName(cart.getProductEntity().getName());
        product.setPrice(cart.getProductEntity().getPrice());
        if("add".equals(action)){
            cartHolder.addToCart(product);
            return new ModelAndView("redirect:/cart");
        } else if("remove".equals(action)){
            cartHolder.removeCart(product);
            return new ModelAndView("redirect:/cart");
        }
        return new ModelAndView("redirect:/cart");
    }

}
