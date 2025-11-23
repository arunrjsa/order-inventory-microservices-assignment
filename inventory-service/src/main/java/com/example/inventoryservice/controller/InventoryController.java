package com.example.inventoryservice.controller;

import com.example.inventoryservice.model.Batch;
import com.example.inventoryservice.service.InventoryServiceFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/inventory")
public class InventoryController {
    private final InventoryServiceFactory factory;

    public InventoryController(InventoryServiceFactory factory) {
        this.factory = factory;
    }

    @GetMapping("/{productId}")
    public List<Batch> getInventory(@PathVariable String productId) {
        return factory.getService("default").getInventoryByProduct(productId);
    }

    @PostMapping("/update")
    public ResponseEntity<String> updateInventory(@RequestParam String productId,
                                                  @RequestParam int quantity) {
        factory.getService("default").updateInventory(productId, quantity);
        return ResponseEntity.ok("Inventory updated");
    }
}