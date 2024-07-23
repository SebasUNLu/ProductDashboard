package com.example.productDashboard.DTOs;


import com.example.productDashboard.Entities.Category;
import com.example.productDashboard.Entities.Product;

import java.util.List;

public class SubCategoryDTO {

    private Long id;
    private String name;
    private Category category;
    private List<Product> products;

    public SubCategoryDTO(){}

    public SubCategoryDTO(Long id, String name, Category category, List<Product> products) {
        this.id = id;
        this.name = name;
        this.category = category;
        this.products = products;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
