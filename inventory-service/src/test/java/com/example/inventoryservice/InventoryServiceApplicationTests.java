package com.example.inventoryservice;

import com.example.inventoryservice.model.Batch;
import com.example.inventoryservice.repository.InventoryRepository;
import com.example.inventoryservice.service.InventoryService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

@SpringBootTest
class InventoryServiceApplicationTests {

        @Autowired
        private InventoryService service;

        @Autowired
        private InventoryRepository repository;

        @Test
        void testGetInventoryByProduct() {
            Batch batch = new Batch(null, "P1", 10, LocalDate.now().plusDays(5));
            repository.save(batch);

            List<Batch> result = service.getInventoryByProduct("P1");
            assertFalse(result.isEmpty());
            assertEquals("P1", result.get(0).getProductId());
        }

        @Test
        void testUpdateInventory() {
            Batch batch = new Batch(null, "P2", 20, LocalDate.now().plusDays(10));
            repository.save(batch);

            service.updateInventory("P2", 5);
            Batch updated = repository.findByProductIdOrderByExpiryDateAsc("P2").get(0);
            assertEquals(15, updated.getQuantity());
        }
    }