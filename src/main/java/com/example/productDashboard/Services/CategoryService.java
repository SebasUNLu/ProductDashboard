package com.example.productDashboard.Services;

import com.example.productDashboard.DTOs.CategoryDTO;
import com.example.productDashboard.Entities.Category;
import com.example.productDashboard.Repositories.CategoryRepository;
import com.example.productDashboard.Repositories.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository repository;

    public CategoryService(CategoryRepository repository){
        this.repository = repository;
    }

    private CategoryDTO createDTO(Category category){
        return new CategoryDTO(category.getId(), category.getName(), category.getSubCategories());
    }

    public CategoryDTO getCategory(Long id) {
        Category category = repository.findById(id).orElse(null);
        return createDTO(category);
    }

    public List<CategoryDTO> getCategories() {
        List<Category> categories = repository.findAll();
        List<CategoryDTO> list = new ArrayList<CategoryDTO>();
        for (Category category: categories) {
            list.add(createDTO(category));
        }
        return list;
    }

    public CategoryDTO createCategory(Category category) {
        Category newCategory = repository.save(category);
        return createDTO(newCategory);
    }

    public void deleteCategory(Long id) {
        repository.deleteById(id);
    }

    public CategoryDTO updateCategory(Long category_id, Category updateCategory) {
        Category category = repository.findById(category_id).orElse(null);
        category.setName(updateCategory.getName());
        repository.save(category);
        return createDTO(category);
    }



}
