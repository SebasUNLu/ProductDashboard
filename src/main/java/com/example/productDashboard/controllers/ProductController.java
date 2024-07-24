package com.example.productDashboard.controllers;

import com.example.productDashboard.DTOs.CategoryDTO;
import com.example.productDashboard.DTOs.ProductDTO;
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
    public ProductDTO getProduct(@PathVariable Long id) {
        return service.getProduct(id);
    }

    // Get Product list given a SubCategory
    @GetMapping("/product/subCategory/{subCategory_id}")
    public List<ProductDTO> getProdsBySubCat(@PathVariable Long subCategory_id){
        return service.getProdsBySubCat(subCategory_id);
    }

    @GetMapping("/product")
    public List<ProductDTO> getProducts() {
        return service.getProducts();
    }

    @PostMapping("/product")
    public ProductDTO addProduct(@RequestBody Product product) {
        return service.createProduct(product);
    }

    // Add a SubCategory to a Product
    @PostMapping("/product/{product_id}/subCategory/{subCategory_id}")
    public ProductDTO addSubCategoryToProduct(@PathVariable Long product_id, @PathVariable Long subCategory_id){
        return service.addSubCatToProd(product_id,subCategory_id);
    }

    @DeleteMapping("/product/{id}")
    public void deleteProduct(@PathVariable Long id) {
        service.deleteProduct(id);
    }

    @PutMapping("/product/{id}")
    public ProductDTO updateProducts(@PathVariable Long id, @RequestBody Product updateProduct) {
        return service.updateProducts(id, updateProduct);
    }

}
