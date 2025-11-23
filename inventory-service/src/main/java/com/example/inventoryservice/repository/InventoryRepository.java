package com.example.inventoryservice.repository;

import com.example.inventoryservice.model.Batch;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InventoryRepository extends JpaRepository<Batch, Long> {
    List<Batch> findByProductIdOrderByExpiryDateAsc(String productId);
}
