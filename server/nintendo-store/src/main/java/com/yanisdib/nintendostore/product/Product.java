package com.yanisdib.nintendostore.product;

import com.yanisdib.nintendostore.category.Category;
import com.yanisdib.nintendostore.constants.ProductAvailability;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.HashSet;
import java.util.Set;

@Document("products")
public class Product {

    @Id
    private String id;

    private String reference;
    private String name;
    private String description;
    private Set<Category> categories;
    private LocalDateTime releaseDate;
    private double unitPrice;
    private BigDecimal stock;
    private ProductAvailability productAvailability;

    public Product() {
        super();
        this.reference = "";
        this.name = "";
        this.description = "";
        this.releaseDate = LocalDateTime.now();
        this.unitPrice = 0.0;
        this.stock = new BigDecimal(0);
        this.productAvailability = ProductAvailability.UNRELEASED;
        this.categories = new HashSet<>();
    }

    public Product(
            String reference,
            String name,
            String description,
            Set<Category> categories,
            LocalDateTime releaseDate,
            double unitPrice,
            BigDecimal stock,
            ProductAvailability productAvailability
    ) {
        this.reference = reference;
        this.name = name;
        this.description = description;
        this.unitPrice = unitPrice;
        this.categories = categories;
        this.releaseDate = releaseDate;
        this.stock = stock;
        this.productAvailability = productAvailability;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Category> getCategories() {
        return categories;
    }

    public void setCategories(Set<Category> categories) {
        this.categories = categories;
    }

    public LocalDateTime getReleaseDate() {
        return releaseDate;
    }

    public void setReleaseDate(LocalDateTime releaseDate) {
        this.releaseDate = releaseDate;
    }

    public double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getStock() {
        return stock;
    }

    public void setStock(BigDecimal stock) {
        this.stock = stock;
    }

    public ProductAvailability getAvailability() {
        return productAvailability;
    }

    public void setAvailability(ProductAvailability productAvailability) {
        this.productAvailability = productAvailability;
    }

}
