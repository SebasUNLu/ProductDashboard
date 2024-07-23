package com.example.productDashboard.controllers;

import com.example.productDashboard.DTOs.SubCategoryDTO;
import com.example.productDashboard.Entities.SubCategory;
import com.example.productDashboard.RequestsBodies.SubCategoryPostBody;
import com.example.productDashboard.Services.SubCategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
public class SubCategoryController {
/*
    @Autowired
    private SubCategoryService service;

    @GetMapping("/subCategory/{id}")
    public SubCategory getSubCategory(@PathVariable Long id){
        return service.getSubCategory(id);
    }

    @GetMapping("/subCategory")
    public List<SubCategory> getSubCategories(){
        return service.getSubCategories();
    }

    @PostMapping("/subCategory")
    public SubCategoryDTO createSubCategory(@RequestBody SubCategoryPostBody reqSubCat){
        SubCategory ret = service.createSubCategory(reqSubCat.category_id, reqSubCat.subCat_name);
        return new SubCategoryDTO(ret.getId(), ret.getName(), ret.getCategory());
    }

    @DeleteMapping("/subCategory/{id}")
    public void deleteSubCategory(@PathVariable Long id) {
        service.deleteSubCategory(id);
    }

    @PutMapping("/subCategory")
    public SubCategory updateSubCategory(@RequestBody SubCategory updateSubCategory) {
        return service.updateSubCategory(updateSubCategory);
    }

*/
}
