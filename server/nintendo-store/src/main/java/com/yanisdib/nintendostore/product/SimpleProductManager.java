package com.yanisdib.nintendostore.product;


import java.util.List;

public interface SimpleProductManager {

    ProductPayload findByName(String name) throws ProductNotFoundException;

    ProductPayload findByReference(String reference) throws ProductNotFoundException;

    List<ProductPayload> findAllByCategory(String category);

}
