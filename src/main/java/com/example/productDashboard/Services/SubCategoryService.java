package com.example.productDashboard.Services;

import com.example.productDashboard.DTOs.CategoryDTO;
import com.example.productDashboard.DTOs.SubCategoryDTO;
import com.example.productDashboard.Entities.Category;
import com.example.productDashboard.Entities.SubCategory;
import com.example.productDashboard.Repositories.CategoryRepository;
import com.example.productDashboard.Repositories.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

@Service
public class SubCategoryService {

    @Autowired
    private SubCategoryRepository repository;

    @Autowired
    private CategoryRepository categoryRepository;

    public SubCategoryService(SubCategoryRepository repository, CategoryRepository categoryRepository){
        this.repository = repository;
        this.categoryRepository = categoryRepository;
    }

    private SubCategoryDTO createDTO(SubCategory subcategory){
        return new SubCategoryDTO(subcategory.getId(), subcategory.getName(), subcategory.getCategory(), subcategory.getProducts());
    }

    public SubCategoryDTO getSubCategory(Long id) {
        SubCategory subcategory = repository.findById(id).orElse(null);
        return createDTO(subcategory);
    }

    public List<SubCategoryDTO> getSubCategories() {
        List<SubCategory> list = repository.findAll();
        List<SubCategoryDTO> retList = new ArrayList<>();
        for(SubCategory subCat: list){
            retList.add(createDTO(subCat));
        }
        return retList;
    }

    public SubCategoryDTO createSubCategory(SubCategory subCategory, Long category_id) {
        Category category = categoryRepository.findById(category_id).orElse(null);
        subCategory.setCategory(category);
        SubCategory newSubCat = repository.save(subCategory);
        return createDTO(newSubCat);
    }

    public void deleteSubCategory(Long id) {
        repository.deleteById(id);
    }

    public SubCategoryDTO updateSubCategory(Long subCategory_id, SubCategory updateSubCategory) {
        SubCategory subCat = repository.findById(subCategory_id).orElse(null);
        subCat.setName(updateSubCategory.getName());
        repository.save(subCat);
        return createDTO(subCat);
    }
}
