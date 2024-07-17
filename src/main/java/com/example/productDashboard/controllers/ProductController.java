package com.example.productDashboard.controllers;

import com.example.productDashboard.Entities.Product;
import com.example.productDashboard.Services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/product/{id}")
    public Product getProduct(@PathVariable Long id) {
        return service.getProduct(id);
    }

    @GetMapping("/product")
    public List<Product> getProducts() {
        return service.getProducts();
    }

    @PostMapping("/product")
    public Product addProduct(@RequestBody Product product) {
        return service.createProduct(product);
    }

    @DeleteMapping("/product/{id}")
    public void deleteProduct(@PathVariable Long id) {
        service.deleteProduct(id);
    }

    @PutMapping("/product")
    public Product updateProducts(@RequestBody Product updateProduct) {
        return service.updateProducts(updateProduct);
    }

}
