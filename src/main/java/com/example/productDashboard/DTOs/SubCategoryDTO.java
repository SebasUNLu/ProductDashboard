package com.example.productDashboard.DTOs;


import com.example.productDashboard.Entities.Category;

public class SubCategoryDTO {

    private Long id;
    private String name;
    private Category category;

    public SubCategoryDTO(){}

    public SubCategoryDTO(Long id, String name, Category category) {
        this.id = id;
        this.name = name;
        this.category = category;
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
}
