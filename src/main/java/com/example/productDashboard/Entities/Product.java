package com.example.productDashboard.Entities;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "products")
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotNull(message = "name can't be null or empty")
    @Size(min = 2, max = 15, message = "name length must be within 2 and 15 characters")
    @Column(name = "name")
    private String name;

    @NotNull(message = "description can't be null or empty")
    @Size(min = 5, max = 30, message = "description must be within 5 and 30 characters")
    @Column(name = "description")
    private String description;

    @NotNull(message = "price can't be null")
    @Min(value = 0, message = "price can't be below 0")
    @Column(name = "price")
    private Float price;

    @NotNull(message = "enabled can't be null")
    @Column(name = "enabled")
    private Boolean enabled;

    @NotNull(message = "type can't be null or empty")
    @Size(min = 2, max = 15, message = "type must be within 2 and 15 characters")
    @Column(name = "type")
    private String type;

    @NotNull(message = "promotion can't be null or empty")
    @Size(min = 2, max = 15, message = "promotion must be within 2 and 15 characters")
    @Column(name = "promotion")
    private String promotion;

    @NotNull(message = "celiac_appropriate can't be null")
    @Column(name = "celiac_appropriate")
    private Boolean celiac_appropriate;

    @NotNull(message = "vegetarian_appropriate can't be null")
    @Column(name = "vegetarian_appropriate")
    private Boolean vegetarian_appropriate;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "id_subcategory")
    private SubCategory subCategory;

    @JsonIgnore
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "createdAt")
    private Date createdAt;

    @JsonIgnore
    @UpdateTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updatedAt")
    private Date updatedAt;


    public Product() {
    }

    public Product(Long id, String name, String description, Float price, Boolean enabled, List<String> images, String type, String promotion, Boolean celiac_appropriate, Boolean vegetarian_appropriate, SubCategory subCategory, Date createdAt, Date updatedAt) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.enabled = enabled;
        this.type = type;
        this.promotion = promotion;
        this.celiac_appropriate = celiac_appropriate;
        this.vegetarian_appropriate = vegetarian_appropriate;
        this.subCategory = subCategory;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Float getPrice() {
        return price;
    }

    public void setPrice(Float price) {
        this.price = price;
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getPromotion() {
        return promotion;
    }

    public void setPromotion(String promotion) {
        this.promotion = promotion;
    }

    public Boolean getCeliac_appropriate() {
        return celiac_appropriate;
    }

    public void setCeliac_appropriate(Boolean celiac_appropriate) {
        this.celiac_appropriate = celiac_appropriate;
    }

    public SubCategory getSubCategory() {
        return subCategory;
    }

    public void setSubCategory(SubCategory subCategory) {
        this.subCategory = subCategory;
    }

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public Date getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Date updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Boolean getVegetarian_appropriate() {
        return vegetarian_appropriate;
    }

    public void setVegetarian_appropriate(Boolean vegetarian_appropriate) {
        this.vegetarian_appropriate = vegetarian_appropriate;
    }
}
