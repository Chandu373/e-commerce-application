package com.ecommerce.product_service.dto;

import lombok.Builder;
import lombok.Data;

import java.math.BigDecimal;

@Builder
@Data
public class ProductRequest {
    private String name;
    private BigDecimal price;
    private String description;
    private String skuCode;
}
