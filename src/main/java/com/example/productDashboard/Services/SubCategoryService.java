package com.example.productDashboard.Services;

import com.example.productDashboard.Entities.Category;
import com.example.productDashboard.Entities.SubCategory;
import com.example.productDashboard.Repositories.CategoryRepository;
import com.example.productDashboard.Repositories.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SubCategoryService {

    @Autowired
    private SubCategoryRepository repository;

    @Autowired
    private CategoryService categoryService;

    public SubCategoryService(SubCategoryRepository repository, CategoryService categoryService){
        this.repository = repository;
        this.categoryService = categoryService;
    }

    public SubCategory getSubCategory(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<SubCategory> getSubCategories() {
        return repository.findAll();
    }

    /*public SubCategory createSubCategory(Long category_id, String subCat_name) {
        Category category = categoryService.getCategory(category_id);
        SubCategory newSubCategory = new SubCategory();
        newSubCategory.setName(subCat_name);
        newSubCategory.setCategory(category);
        return repository.save(newSubCategory);
    }*/

    public void deleteSubCategory(Long id) {
        repository.deleteById(id);
    }

    public SubCategory updateSubCategory(SubCategory updateSubCategory) {
        SubCategory subCategory = repository.save(updateSubCategory);
        return subCategory;
    }
}
