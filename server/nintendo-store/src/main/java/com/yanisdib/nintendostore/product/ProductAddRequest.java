package com.yanisdib.nintendostore.product;

import com.yanisdib.nintendostore.category.Category;
import com.yanisdib.nintendostore.constants.ProductAvailability;
import org.springframework.lang.NonNull;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Set;

public record ProductAddRequest(
        @NonNull String reference,
        @NonNull String name,
        String description,
        @NonNull Set<Category> categories,
        LocalDateTime releaseDate,
        @NonNull double unitPrice,
        BigDecimal stock,
        @NonNull ProductAvailability productAvailability
) {
}
