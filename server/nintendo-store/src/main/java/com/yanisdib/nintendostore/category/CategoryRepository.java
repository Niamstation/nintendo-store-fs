package com.yanisdib.nintendostore.category;

import com.yanisdib.nintendostore.product.ProductPayload;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends MongoRepository<Category, String> {

    @Query("{name:'?0'}")
    Optional<Category> findByName(String name);

    @Query("{category:'?0'}")
    List<Category> findAllByParent(String parentId);

    public long count();

}
