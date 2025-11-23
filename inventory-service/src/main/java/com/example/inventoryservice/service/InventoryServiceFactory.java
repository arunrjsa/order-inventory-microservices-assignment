package com.example.inventoryservice.service;

import com.example.inventoryservice.repository.InventoryRepository;
import org.springframework.stereotype.Component;

@Component
public class InventoryServiceFactory {
    private final InventoryRepository repository;

    public InventoryServiceFactory(InventoryRepository repository) {
        this.repository = repository;
    }

    public InventoryService getService(String type) {
        // Future extension: different strategies
        return new InventoryService(repository);
    }
}
