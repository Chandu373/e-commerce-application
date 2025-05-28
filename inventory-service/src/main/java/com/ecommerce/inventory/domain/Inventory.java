package com.ecommerce.inventory.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table(name = "inventory")
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Long productId;
    @Column(nullable = false)
    private double quantity;
    @Column(nullable = false)
    private int availableStock;
    @Column(nullable = false)
    private int reservedStock;
    @Version
    private int version;

}
