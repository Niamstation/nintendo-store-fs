package com.yanisdib.nintendostore.product;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public class ProductController {

    private final ProductManager manager;

    public ProductController(ProductManager manager) {
        this.manager = manager;
    }

    @GetMapping("/products")
    List<ProductPayload> all() {
        return manager.findAll();
    }

    @GetMapping("/products/{category}")
    List<ProductPayload> allByCategory(@PathVariable String category) {
        return manager.findAllByCategory(category);
    }

    @GetMapping("/products/{id}")
    ProductPayload oneById(@PathVariable String id) {
        return manager.findByName(id);
    }

    @GetMapping("/products/{name}")
    ProductPayload oneByName(@PathVariable String name) {
        return manager.findByName(name);
    }

    @GetMapping("/products/{reference}")
    ProductPayload oneByReference(@PathVariable String reference) {
        return manager.findByReference(reference);
    }

    @PutMapping("/products/{id}")
    ResponseEntity<String> update(@Validated @RequestBody ProductAddRequest addRequest, @PathVariable String id) {
        manager.update(addRequest, id);

        return ResponseEntity.ok().body(HttpStatus.OK +
                ": Product " +
                addRequest.name() +
                " successfully updated"
        );
    }

    @PostMapping("/products")
    ResponseEntity<String> store(@Validated @RequestBody ProductAddRequest addRequest) {

        manager.create(addRequest);

        return ResponseEntity.ok().body(HttpStatus.OK +
                ": Product " +
                addRequest.name() +
                " saved successfully"
        );
    }

}
