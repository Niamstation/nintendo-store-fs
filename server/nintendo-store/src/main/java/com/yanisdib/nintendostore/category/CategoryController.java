package com.yanisdib.nintendostore.category;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CategoryController {

    private final CategoryManager manager;

    public CategoryController(CategoryManager manager) {
        this.manager = manager;
    }

    @GetMapping("/categories")
    private List<CategoryPayload> all() {
        return manager.findAll();
    }

    @DeleteMapping("/categories/{id}")
    private ResponseEntity<?> delete(@PathVariable("id") String id) {
        manager.delete(id);
        return ResponseEntity.ok(HttpStatus.OK + ": category deleted successfully.");
    }

    @GetMapping("/categories/{id}")
    private CategoryPayload oneById(@PathVariable("id") String id) {
        return manager.findById(id);
    }

    @GetMapping("/categories/{name}")
    private CategoryPayload oneByName(@PathVariable("name") String name) {
        return manager.findByName(name);
    }

    @GetMapping("/categories/{parentId}")
    private List<CategoryPayload> allByParent(@RequestParam("parentId") String parentId) {
        return manager.findAllByParent(parentId);
    }

    @PostMapping("/categories")
    private ResponseEntity<?> create(@Validated @RequestBody CategoryAddRequest addRequest) {
        manager.create(addRequest);
        return ResponseEntity.ok(HttpStatus.OK + ": category created successfully.");
    }

}
