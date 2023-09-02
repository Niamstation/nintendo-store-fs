package com.yanisdib.nintendostore.product;

import com.yanisdib.nintendostore.constants.Availability;
import jdk.jfr.Category;
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
    private String name;
    private String description;
    private Set<Category> categories;
    private LocalDateTime releaseDate;
    private Double unitPrice;
    private BigDecimal stock;
    private Availability availability;

    public Product() {
        this.name = "";
        this.description = "";
        this.releaseDate = LocalDateTime.now();
        this.unitPrice = 0.0;
        this.stock = new BigDecimal(0);
        this.availability = Availability.UNRELEASED;
        this.categories = new HashSet<Category>();
    }

    public Product(
            String name,
            String description,
            Set<Category> categories,
            LocalDateTime releaseDate,
            Double unitPrice,
            BigDecimal stock,
            Availability availability
    ) {
        this.name = name;
        this.description = description;
        this.unitPrice = unitPrice;
        this.categories = categories;
        this.releaseDate = releaseDate;
        this.stock = stock;
        this.availability = availability;
    }

    public void setId(String id) {
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

    public Double getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(Double unitPrice) {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getStock() {
        return stock;
    }

    public void setStock(BigDecimal stock) {
        this.stock = stock;
    }

    public Availability getAvailability() {
        return availability;
    }

    public void setAvailability(Availability availability) {
        this.availability = availability;
    }

}
