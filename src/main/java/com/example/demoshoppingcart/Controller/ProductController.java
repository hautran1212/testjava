package com.example.demoshoppingcart.Controller;

import com.example.demoshoppingcart.Entity.ProductEntity;
import com.example.demoshoppingcart.Service.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("products")
public class ProductController {
    private final ProductService productService;


    public ProductController(ProductService productService) {
        this.productService = productService;

    }

    @GetMapping
    public String list(Model model){
        model.addAttribute("products", productService.getAll());
        model.addAttribute("product", new ProductEntity());
        return "ProductList";
    }
    @GetMapping("add")
    public String showAddProduct(Model model){
        model.addAttribute("product", new ProductEntity());
        return "Add";
    }
    @GetMapping("detail")
    public String showDetailProduct(@RequestParam(name = "productId") Long productId, Model model){
        System.out.println(productId);
        Optional<ProductEntity> optionalProductEntity = productService.findById(productId);
        ProductEntity product = optionalProductEntity.orElse(new ProductEntity());
        model.addAttribute("product", product);
        return "DetailProduct";
    }


    @PostMapping
    public String addProduct(@ModelAttribute ProductEntity product, Model model) {
        productService.create(product);
        List<ProductEntity> products = productService.getAll();
        model.addAttribute("products", products);
        return "ProductList";
    }
    @PostMapping("updateorDelete")
    public ModelAndView updateProduct(@ModelAttribute ProductEntity product, @RequestParam String action){
        if ("update".equals(action)) {
            System.out.println(product.getId());
            System.out.println(product.getName());
            System.out.println(product.getPrice());
            productService.save(product);
            return new ModelAndView("redirect:/products");
        } else if("delete".equals(action)){
            productService.deleteById(product.getId());
            return new ModelAndView("redirect:/products");
        }
        return new ModelAndView("redirect:/products");
    }

}
