package com.henrique.tgid_test.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
    private Long Id;
    private String name;
    private double price;
    private int StockQuantity;
}
