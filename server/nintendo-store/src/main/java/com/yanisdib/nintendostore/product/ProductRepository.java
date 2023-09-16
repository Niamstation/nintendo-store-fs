package com.yanisdib.nintendostore.product;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface ProductRepository extends MongoRepository<Product, String> {

    @Query("{name:'?0'}")
    ProductPayload findByName(String name);

    @Query("{category:'?0'}")
    List<ProductPayload> findAllByCategory(String category);

    @Query("{reference:'?0'}")
    ProductPayload findByReference(String reference);

    public long count();

}
