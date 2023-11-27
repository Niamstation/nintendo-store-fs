package com.yanisdib.nintendostore.product;

import com.yanisdib.nintendostore.category.Category;
import com.yanisdib.nintendostore.constants.ProductAvailability;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

public record ProductPayload(
        String id,
        String reference,
        String name,
        String description,
        Set<Category> categories,
        LocalDateTime releaseDate,
        double unitPrice,
        BigDecimal stock,
        ProductAvailability productAvailability
) {
}
