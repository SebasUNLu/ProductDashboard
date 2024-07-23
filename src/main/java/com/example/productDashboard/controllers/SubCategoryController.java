package com.example.productDashboard.controllers;

import com.example.productDashboard.DTOs.SubCategoryDTO;
import com.example.productDashboard.Entities.SubCategory;
import com.example.productDashboard.Services.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SubCategoryController {
    @Autowired
    private SubCategoryService service;

    @GetMapping("/subCategory/{id}")
    public SubCategoryDTO getSubCategory(@PathVariable Long id) {
        return service.getSubCategory(id);
    }

    @GetMapping("/subCategory")
    public List<SubCategoryDTO> getSubCategories() {
        return service.getSubCategories();
    }

    @PostMapping("/category/{category_id}/subCategory")
    public SubCategoryDTO createSubCategory(@PathVariable Long category_id, @RequestBody SubCategory subcategory) {
        SubCategoryDTO newSubCategory = service.createSubCategory(subcategory, category_id);
        return newSubCategory;
    }

    @DeleteMapping("/subCategory/{id}")
    public void deleteSubCategory(@PathVariable Long id) {
        service.deleteSubCategory(id);
    }


    @PutMapping("/subCategory/{subCategory_id}")
    public SubCategoryDTO updateSubCategory(@RequestBody SubCategory updateSubCategory, @PathVariable Long subCategory_id) {
        return service.updateSubCategory(subCategory_id, updateSubCategory);
    }

}
