package com.example.productDashboard.Entities;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Objects;

@Setter @Getter @NoArgsConstructor @AllArgsConstructor
public class Product {
    private Integer id;
    private String name;
    private String description;
    private Float cost;
    private Boolean enabled;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name) && Objects.equals(description, product.description) && Objects.equals(cost, product.cost) && Objects.equals(enabled, product.enabled);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, description, cost, enabled);
    }

    @Override
    public String toString() {
        return "Product{" +
                "name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", cost=" + cost +
                ", enabled=" + enabled +
                '}';
    }
}
