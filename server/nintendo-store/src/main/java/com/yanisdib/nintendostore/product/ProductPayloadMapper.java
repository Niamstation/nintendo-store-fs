package com.yanisdib.nintendostore.product;

import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class ProductPayloadMapper implements Function<Product, ProductPayload> {

    @Override
    public ProductPayload apply(Product product) {
        return new ProductPayload(
                product.getId(),
                product.getReference(),
                product.getName(),
                product.getDescription(),
                product.getCategories(),
                product.getReleaseDate(),
                product.getUnitPrice(),
                product.getStock(),
                product.getAvailability()
        );
    }

}
