package com.example;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Product {
    private int id;
    private String name;
    private double price;

    @Override
    public String toString() {
        return "Product[ID=%d, Name=%s, Price=%.2f]".formatted(id, name, price);
    }
}
