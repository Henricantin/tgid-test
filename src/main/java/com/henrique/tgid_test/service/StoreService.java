package com.henrique.tgid_test.service;

import com.henrique.tgid_test.model.*;

import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StoreService {

    private List<User> users = new ArrayList<>();
    private List<Product> products = new ArrayList<>();
    private List<Sale> sales = new ArrayList<>();

    public StoreService() {
        users.add(new User(1L, "João Silva", "123.456.789-00", "joao@email.com"));
        users.add(new User(2L, "Maria Souza", "987.654.321-00", "maria@email.com"));

        products.add(new Product(1L, "Notebook", 3000.00, 10));
        products.add(new Product(2L, "Teclado", 150.00, 20));
        products.add(new Product(3L, "Mouse", 80.00, 30));
    }

    public List<Product> listProducts() {
        return products;
    }

    public List<User> listUsers() {
        return users;
    }

    public Sale makePurchase(Long userId, Map<Long, Integer> purchaseItems) {
        User user = users.stream()
                .filter(u -> u.getId().equals(userId))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

        List<SaleItem> items = new ArrayList<>();

        for (Map.Entry<Long, Integer> entry : purchaseItems.entrySet()) {
            Product product = products.stream()
                    .filter(p -> p.getId().equals(entry.getKey()))
                    .findFirst()
                    .orElseThrow(() -> new RuntimeException("Produto não encontrado"));

            int quantity = entry.getValue();

            if (product.getStockQuantity() < quantity) {
                throw new RuntimeException("Estoque insuficiente para o produto: " + product.getName());
            }

            product.setStockQuantity(product.getStockQuantity() - quantity);
            items.add(new SaleItem(product, quantity));
        }

        Sale sale = new Sale((long) (sales.size() + 1), user, items);
        sales.add(sale);
        return sale;
    }

    public List<Sale> listSales() {
        return sales;
    }
}
