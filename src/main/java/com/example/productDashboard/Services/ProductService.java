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
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository){
        this.productRepository = productRepository;
    }

    private List<Product> list = new ArrayList<>();

    public Product getProduct(Long id) {
        return productRepository.findById(id).orElse(null);
    }

    public List<Product> getProducts() {
        return productRepository.findAll();
    }

    public Product createProduct(Product product) {
        Product newProduct = productRepository.save(product);
        return newProduct;
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }

    public Product updateProducts(Product updateProduct) {
        Product product = productRepository.save(updateProduct);
        return product;
    }
}
