package com.ecommerce.inventory.controller;

import com.ecommerce.inventory.dto.ErrorResponse;
import com.ecommerce.inventory.dto.InventoryResponse;
import com.ecommerce.inventory.dto.ProductResponse;
import com.ecommerce.inventory.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/inventory")
public class InventoryController {

    @Autowired
    private final InventoryService inventoryService;

    @GetMapping(value = "{productId}")
    public ResponseEntity<?> getProductStock(@PathVariable String productId) {
        InventoryResponse inventoryResponse = null;
        if (productId.isBlank()) {
            inventoryResponse.setErrorResponse(new ErrorResponse("404","product is empty"));
            return ResponseEntity.badRequest().body(inventoryResponse);
        }
        inventoryResponse = inventoryService.getProductById(productId);
        return ResponseEntity.ok(inventoryResponse);
    }

}