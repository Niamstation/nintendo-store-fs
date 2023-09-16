package com.yanisdib.nintendostore.product;

public class ProductNotFoundException extends RuntimeException {

    ProductNotFoundException(String id) {
        super("Could not find product " + id);
    }

}
