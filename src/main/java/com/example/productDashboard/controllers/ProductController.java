package com.example.productDashboard.controllers;

import com.example.productDashboard.DTOs.CategoryDTO;
import com.example.productDashboard.DTOs.ProductDTO;
import com.example.productDashboard.Entities.Product;
import com.example.productDashboard.Services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private ProductService service;

    @GetMapping("/{id}")
    public ProductDTO getProduct(@PathVariable Long id) {
        return service.getProduct(id);
    }

    // Get Product list given a SubCategory
    @GetMapping("/subCategory/{subCategory_id}")
    public List<ProductDTO> getProdsBySubCat(@PathVariable Long subCategory_id) {
        return service.getProdsBySubCat(subCategory_id);
    }

    // Get Product list given a Category
    @GetMapping("/category/{category_id}")
    public List<ProductDTO> getProdsByCat(@PathVariable Long category_id) {
        return service.getProdsByCat(category_id);
    }

    @GetMapping
    public List<ProductDTO> getProducts(@RequestParam(required = false) String name) {
        if (name != null) {
            System.out.println("Nombre encontrado: " + name);
            return service.getProducts(name);
        }
        return service.getProducts();
    }

    @PostMapping
    public ProductDTO addProduct(@RequestBody @Valid Product product) {
        return service.createProduct(product);
    }

    // Add a SubCategory to a Product
    @PostMapping("/{product_id}/subCategory/{subCategory_id}")
    public ProductDTO addSubCategoryToProduct(@PathVariable Long product_id, @PathVariable Long subCategory_id) {
        return service.addSubCatToProd(product_id, subCategory_id);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable Long id) {
        service.deleteProduct(id);
    }

    @PutMapping("/{id}")
    public ProductDTO updateProducts(@PathVariable Long id, @RequestBody Product updateProduct) {
        return service.updateProducts(id, updateProduct);
    }

}
