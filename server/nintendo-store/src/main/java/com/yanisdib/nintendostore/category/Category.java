package com.yanisdib.nintendostore.category;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.HashSet;
import java.util.Set;

@Document("categories")
public class Category {

    @Id
    private String id;
    private String name;
    private String description;
    private Set<Category> subcategories;

    public Category() {
        this.name = "";
        this.description = "";
        this.subcategories = new HashSet<Category>();
    }

    public Category(String name) {
        this.name = name;
        this.description = "";
        this.subcategories = new HashSet<Category>();
    }

    public Category(
            String name,
            String description,
            Set<Category> subcategories
    ) {
        this.name = name;
        this.description = description;
        this.subcategories = subcategories;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Set<Category> getSubcategories() {
        return subcategories;
    }

    public void setSubcategories(Set<Category> subcategories) {
        this.subcategories = subcategories;
    }

}
