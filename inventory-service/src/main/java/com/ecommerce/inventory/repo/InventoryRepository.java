package com.ecommerce.inventory.repo;

import com.ecommerce.inventory.domain.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InventoryRepository  extends JpaRepository<Long,Inventory> {

    Inventory findByProductId(String productId);
}
