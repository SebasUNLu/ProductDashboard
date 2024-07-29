package com.example.productDashboard.controllers;

import com.example.productDashboard.DTOs.CategoryDTO;
import com.example.productDashboard.Entities.Category;
import com.example.productDashboard.Services.CategoryService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService service;

    @GetMapping("/{id}")
    public CategoryDTO getCategory(@PathVariable Long id){
        return service.getCategory(id);
    }

    @GetMapping
    public List<CategoryDTO> getCategories(){
        return service.getCategories();
    }

    @PostMapping
    public CategoryDTO createCategory(@RequestBody @Valid Category category){
        System.out.println("Pasa por aqui");
        return service.createCategory(category);
    }

    @DeleteMapping("/{id}")
    public void deleteCategory(@PathVariable Long id) {
        service.deleteCategory(id);
    }

    @PutMapping("/{category_id}")
    public CategoryDTO updateCategory(@RequestBody Category updateCategory, @PathVariable Long category_id) {
        return service.updateCategory(category_id, updateCategory);
    }

}
