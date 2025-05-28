package com.ecommerce.inventory.service;

import com.ecommerce.inventory.domain.Inventory;
import com.ecommerce.inventory.dto.ErrorResponse;
import com.ecommerce.inventory.dto.InventoryResponse;
import com.ecommerce.inventory.dto.ProductResponse;
import com.ecommerce.inventory.repo.InventoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class InventoryService {

    @Autowired
    private final InventoryRepository inventoryRepository;

    public InventoryResponse getProductById(String productId) {
        InventoryResponse inventoryResponse = new InventoryResponse();
        Inventory inventory = null;
        try {
            inventory = inventoryRepository.findByProductId(productId);
            if (inventory == null) {
                inventoryResponse.setErrorResponse(new ErrorResponse("400", "product not found"));
                return inventoryResponse;
            }
        } catch (Exception errMsg) {

        }
        return this.prepareResponse(inventory, inventoryResponse);
    }

    private InventoryResponse prepareResponse(Inventory inventory, InventoryResponse inventoryResponse) {
        ProductResponse productResponse = ProductResponse.builder()
                .availableStock(inventory.getAvailableStock())
                .productId(inventory.getProductId())
                .reservedStock(inventory.getReservedStock())
                .status("AVAILABLE")
                .build();
        inventoryResponse.setProductResponse(productResponse);
        return inventoryResponse;
    }
}
