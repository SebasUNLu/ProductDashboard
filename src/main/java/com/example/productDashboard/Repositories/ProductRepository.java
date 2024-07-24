package com.example.productDashboard.Repositories;

import com.example.productDashboard.Entities.Product;
import com.example.productDashboard.Entities.SubCategory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    public List<Product> findBySubCategory(SubCategory subCategory);

}
