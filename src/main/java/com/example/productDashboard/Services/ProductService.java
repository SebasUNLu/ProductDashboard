package com.example.productDashboard.Services;

import com.example.productDashboard.Entities.Product;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductService {
    // Es el Modelo, contiene toda la lógica de trabajo, para separarlo del controlador

    private List<Product> list = new ArrayList<>();

    public Product getProduct(Integer id) {
        for (Product product : list) {
            if (product.getId() == id) {
                return product;
            }
        }
        return null;
    }

    public List<Product> getProducts() {
        return list;
    }

    public Product addProduct(Product product) {
        list.add(product);
        return product;
    }

    public void deleteProduct(Integer id) {
        for (Product product : list) {
            if (product.getId() == id) {
                list.remove(product);
                break;
            }
        }
    }

    public Product updateProducts(Integer id, Product updateProduct) {
        for (Product product : list) {
            if (product.getId() == id) {
                list.remove(product);
                list.add(updateProduct);
            }
        }
        return updateProduct;
    }
}
