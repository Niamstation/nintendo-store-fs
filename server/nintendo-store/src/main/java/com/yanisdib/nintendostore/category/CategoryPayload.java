package com.yanisdib.nintendostore.category;

import java.util.Set;

public record CategoryPayload(
        String id,
        String name,
        String description,
        Set<Category> subcategories
) {

}
