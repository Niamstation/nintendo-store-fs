package com.yanisdib.nintendostore.category;

import com.mongodb.lang.NonNull;

import java.util.Set;

public record CategoryAddRequest(
        @NonNull String name,
        @NonNull String description,
        Set<Category> subcategories
) {
}
