package com.example.productDashboard.DTOs;

import com.example.productDashboard.Entities.SubCategory;

public class ProductDTO {

    public Long id;
    public String name;
    public String description;
    public Float price;
    public Boolean enabled;
    public String type;
    public String promotion;
    public Boolean celiac_appropriate;
    public Boolean vegetarian_appropriate;
    public SubCategory subCategory;


    public ProductDTO() {
    }

    public ProductDTO(Long id, String name, String description, Float price, Boolean enabled, String type, String promotion, Boolean celiac_appropriate, Boolean vegetarian_appropriate, SubCategory subCategory) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.enabled = enabled;
        this.type = type;
        this.promotion = promotion;
        this.celiac_appropriate = celiac_appropriate;
        this.vegetarian_appropriate = vegetarian_appropriate;
        this.subCategory = subCategory;
    }
}
