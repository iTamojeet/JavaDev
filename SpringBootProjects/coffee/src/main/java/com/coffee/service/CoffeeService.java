package com.coffee.service;

import com.coffee.entity.Coffee;

import java.util.List;

public interface CoffeeService {
    List<Coffee> getAllCoffees();
    Coffee getCoffeeById(int id);
    Coffee addCoffee(Coffee coffee);
    Coffee updateCoffee(int id, Coffee coffee);
    void deleteCoffee(int id);
    List<Coffee> searchByName(String name);
    List<Coffee> getByCategory(String category);
    Coffee updateStock(int id, int stock);
    // Add custom method
    List<Coffee> getCoffeeByPriceRange(Double startPrice, Double endPrice);
}
