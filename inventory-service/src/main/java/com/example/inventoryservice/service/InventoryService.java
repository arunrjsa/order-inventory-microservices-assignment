package com.example.inventoryservice.service;

import com.example.inventoryservice.model.Batch;
import com.example.inventoryservice.repository.InventoryRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InventoryService {
    private final InventoryRepository repository;

    public InventoryService(InventoryRepository repository) {
        this.repository = repository;
    }

    public List<Batch> getInventoryByProduct(String productId) {
        return repository.findByProductIdOrderByExpiryDateAsc(productId);
    }

    public void updateInventory(String productId, int quantity) {
        List<Batch> batches = repository.findByProductIdOrderByExpiryDateAsc(productId);
        for (Batch batch : batches) {
            if (quantity <= 0) break;
            int used = Math.min(batch.getQuantity(), quantity);
            batch.setQuantity(batch.getQuantity() - used);
            quantity -= used;
            repository.save(batch);
        }
    }
}