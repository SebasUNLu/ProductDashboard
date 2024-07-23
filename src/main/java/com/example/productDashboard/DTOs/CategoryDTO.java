package com.example.productDashboard.DTOs;

import com.example.productDashboard.Entities.SubCategory;

import java.util.List;

public class CategoryDTO {

    public Long id;
    public String name;
    public List<SubCategory> subCategories;

    public CategoryDTO(){}

    public CategoryDTO(Long id, String name, List<SubCategory> subCategories) {
        this.id = id;
        this.name = name;
        this.subCategories = subCategories;
    }
}
