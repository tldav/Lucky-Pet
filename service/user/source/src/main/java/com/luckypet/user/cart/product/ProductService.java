package com.luckypet.user.cart.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@SuppressWarnings({"unused", "Convert2MethodRef"})
@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;
    
    
    public List<Product> getAll() {
        return this.productRepository.findAll();
    }
    
    public List<Product> getById(int productId) {
        Product product = this.productRepository.findById(productId).orElse(null);
        if (product == null){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No product exists with id " + productId);
        }
        return List.of(product);
    }
}
