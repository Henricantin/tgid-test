package com.henrique.tgid_test.controller;

import com.henrique.tgid_test.model.*;
import com.henrique.tgid_test.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/api")
public class StoreController {

    @Autowired
    private StoreService storeService;

    @GetMapping("/products")
    public List<Product> listProducts() {
        return storeService.listProducts();
    }

    @GetMapping("/users")
    public List<User> listUsers() {
        return storeService.listUsers();
    }

    @GetMapping("/sales")
    public List<Sale> listSales() {
        return storeService.listSales();
    }

    @PostMapping("/purchase")
    public Sale makePurchase(
            @RequestParam Long userId,
            @RequestBody Map<Long, Integer> purchaseItems
    ) {
        return storeService.makePurchase(userId, purchaseItems);
    }
}
