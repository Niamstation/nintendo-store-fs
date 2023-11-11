package com.yanisdib.nintendostore.category;

import org.springframework.stereotype.Service;

import java.util.function.Function;

@Service
public class CategoryPayloadMapper implements Function<Category, CategoryPayload> {

    @Override
    public CategoryPayload apply(Category category) {
        return new CategoryPayload(
                category.getId(),
                category.getName(),
                category.getDescription(),
                category.getSubcategories()
        );
    }

}
