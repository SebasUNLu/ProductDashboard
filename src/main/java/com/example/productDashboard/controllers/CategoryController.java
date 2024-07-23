package com.example.productDashboard.controllers;

import com.example.productDashboard.DTOs.CategoryDTO;
import com.example.productDashboard.Entities.Category;
import com.example.productDashboard.Services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

    @Autowired
    private CategoryService service;

    @GetMapping("/category/{id}")
    public CategoryDTO getCategory(@PathVariable Long id){
        return service.getCategory(id);
    }

    @GetMapping("/category")
    public List<CategoryDTO> getCategories(){
        return service.getCategories();
    }

    @PostMapping("/category")
    public CategoryDTO createCategory(@RequestBody Category category){
        return service.createCategory(category);
    }

    @DeleteMapping("/category/{id}")
    public void deleteCategory(@PathVariable Long id) {
        service.deleteCategory(id);
    }

    @PutMapping("/category/{category_id}")
    public CategoryDTO updateCategory(@RequestBody Category updateCategory, @PathVariable Long category_id) {
        return service.updateCategory(category_id, updateCategory);
    }

}
