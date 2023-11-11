package com.yanisdib.nintendostore.category;

public class CategoryNotFoundException extends RuntimeException {

    CategoryNotFoundException(String identifier) {
        super("Could not find category " + identifier);
    }

}
