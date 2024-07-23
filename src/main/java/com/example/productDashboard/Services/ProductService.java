package com.example.productDashboard.Services;

import com.example.productDashboard.Entities.Product;
import com.example.productDashboard.Repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

// Es el Modelo, contiene toda la lógica de trabajo, para separarlo del controlador
@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    public ProductService(ProductRepository repository){
        this.repository = repository;
    }

    public Product getProduct(Long id) {
        return repository.findById(id).orElse(null);
    }

    public List<Product> getProducts() {
        return repository.findAll();
    }

    public Product createProduct(Product product) {
        Product newProduct = repository.save(product);
        return newProduct;
    }

    public void deleteProduct(Long id) {
        repository.deleteById(id);
    }

    public Product updateProducts(Product updateProduct) {
        Product product = repository.save(updateProduct);
        return product;
    }
}
