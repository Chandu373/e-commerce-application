package com.ecommerce.product_service.controller;

import com.ecommerce.product_service.dto.ProductRequest;
import com.ecommerce.product_service.dto.ProductResponse;
import com.ecommerce.product_service.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/product")
public class ProductController {

    @Autowired
    private  final ProductService productService;

    // permission (admin)
    @PostMapping(value = "/create")
    protected ResponseEntity<?> create(@RequestBody ProductRequest productRequest) {
        ResponseEntity<?> result;
        if (productRequest == null) {
            // handle exception
            result = ResponseEntity.badRequest().build();
        } else {
            ProductResponse productResponse = productService.create(productRequest);
            result = ResponseEntity.ok(productResponse);
        }
        return result;
    }

}
