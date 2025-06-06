package com.henrique.tgid_test.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.List;

@Data
@AllArgsConstructor
public class Sale {
    private Long Id;
    private User usuario;
    private List<SaleItem> itens;

    public double getTotal() {
        return itens.stream().mapToDouble(SaleItem::getSubtotal).sum();
    }
}
