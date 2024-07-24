package com.example.productDashboard.Services;

import com.example.productDashboard.DTOs.ProductDTO;
import com.example.productDashboard.Entities.Product;
import com.example.productDashboard.Entities.SubCategory;
import com.example.productDashboard.Repositories.ProductRepository;
import com.example.productDashboard.Repositories.SubCategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository repository;

    @Autowired
    private SubCategoryRepository scRepository;

    public ProductService(ProductRepository repository, SubCategoryRepository scRepository) {
        this.repository = repository;
        this.scRepository = scRepository;
    }

    private ProductDTO createDTO(Product product) {
        return new ProductDTO(
                product.getId(),
                product.getName(),
                product.getDescription(),
                product.getPrice(),
                product.getEnabled(),
                product.getType(),
                product.getPromotion(),
                product.getCeliac_appropriate(),
                product.getVegetarian_appropriate(),
                product.getSubCategory()
        );
    }

    public ProductDTO getProduct(Long id) {
        Product product = repository.findById(id).orElse(null);
        return createDTO(product);
    }

    public List<ProductDTO> getProducts() {
        List<Product> prodList = repository.findAll();
        List<ProductDTO> retList = new ArrayList<>();
        for (Product prod : prodList) {
            retList.add(createDTO(prod));
        }
        return retList;
    }

    public ProductDTO createProduct(Product product) {
        Product newProduct = repository.save(product);
        return createDTO(newProduct);
    }

    public void deleteProduct(Long id) {
        repository.deleteById(id);
    }

    public ProductDTO updateProducts(Long product_id, Product updProd) {
        // THIS is horrible, but it's a big entity
        Product product = repository.findById(product_id).orElse(null);
        product.setName(updProd.getName() != null ? updProd.getName() : product.getName());
        product.setDescription(updProd.getDescription() != null ? updProd.getDescription() : product.getDescription());
        product.setPrice(updProd.getPrice() != null ? updProd.getPrice() : product.getPrice());
        product.setEnabled(updProd.getEnabled() != null ? updProd.getEnabled() : product.getEnabled());
        product.setType(updProd.getType() != null ? updProd.getType() : product.getType());
        product.setPromotion(updProd.getPromotion() != null ? updProd.getPromotion() : product.getPromotion());
        product.setCeliac_appropriate(updProd.getCeliac_appropriate() != null ? updProd.getCeliac_appropriate() : product.getCeliac_appropriate());
        product.setVegetarian_appropriate(updProd.getVegetarian_appropriate() != null ? updProd.getVegetarian_appropriate() : product.getVegetarian_appropriate());
        product.setSubCategory(updProd.getSubCategory() != null ? updProd.getSubCategory() : product.getSubCategory());
        repository.save(product);
        return createDTO(product);
    }

    // Add a SubCategory to a Product
    public ProductDTO addSubCatToProd(Long product_id, Long subCategory_id){
        Product product = repository.findById(product_id).orElseThrow();
        SubCategory subCat = scRepository.findById(subCategory_id).orElseThrow();
        product.setSubCategory(subCat);
        repository.save(product);
        return createDTO(product);
    }

    // Get Product list given a SubCategory
    public List<ProductDTO> getProdsBySubCat(Long subCat_id){
        SubCategory subCat = scRepository.findById(subCat_id).orElseThrow();
        List<Product> products = repository.findBySubCategory(subCat);
        List<ProductDTO> retList = new ArrayList<>();
        for (Product prod : products) {
            retList.add(createDTO(prod));
        }
        return retList;
    }
}
