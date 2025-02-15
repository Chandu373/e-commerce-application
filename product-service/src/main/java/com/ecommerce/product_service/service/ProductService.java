package com.ecommerce.product_service.service;

import com.ecommerce.product_service.dto.ProductRequest;
import com.ecommerce.product_service.dto.ProductResponse;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    public ProductResponse create(ProductRequest productRequest) {
        ProductResponse productResponse = null;
        try {
            boolean isValidRequest = this.validateProductRequest(productRequest);
            if (!isValidRequest) {
                /* create product-error-response */
            }
            productResponse = this.prepareProductResponse(productRequest);
        } catch (Exception errMsg) {

        }
        return productResponse;
    }

    private ProductResponse prepareProductResponse(ProductRequest productRequest) {
        return ProductResponse.builder().name(productRequest.getName())
                .price(productRequest.getPrice())
                .description(productRequest.getDescription())
                .skuCode(productRequest.getSkuCode()).build();
    }

    private boolean validateProductRequest(ProductRequest productRequest) {
        if (productRequest.getName().isBlank()) {
            return false;
        }
        if (productRequest.getPrice() == null) {
            return false;
        }
        if (productRequest.getSkuCode().isBlank()) {
            return false;
        }
        return true;
    }
}
