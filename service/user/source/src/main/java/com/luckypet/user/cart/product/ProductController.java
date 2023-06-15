package com.luckypet.user.cart.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@SuppressWarnings("unused")
@RestController
@RequestMapping(value = "/product")
@CrossOrigin(origins = "http://localhost:3000")
public class ProductController {
    @Autowired
    private ProductService productService;

    @RequestMapping(method = RequestMethod.HEAD)
    public void head() {
    }
    
    @GetMapping
    public List<Product> getProducts() {
        return productService.getAll();
    }
    
    @GetMapping("/{id}")
    public List<Product> getProduct(@PathVariable(name = "id") int id) {
        return productService.getById(id);
    }
}
