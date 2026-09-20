package com.coffee.service.impl;

import com.coffee.entity.Coffee;
import com.coffee.exception.CoffeeNotFoundException;
import com.coffee.service.CoffeeService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class CoffeeServiceImpl implements CoffeeService {

    private final List<Coffee> coffeeList = new ArrayList<>();

    public CoffeeServiceImpl(){
        coffeeList.add(new Coffee(1,"Cappuccino","Hot Coffee",150.0, 25));
        coffeeList.add(new Coffee(2,"Latte","Hot Coffee",180.0, 20));
        coffeeList.add(new Coffee(3,"Espresso","Hot Coffee",120.0, 30));
        coffeeList.add(new Coffee(4,"Cold Coffee","Cold Coffee",160.0, 15));
        coffeeList.add(new Coffee(5,"New Coffee","No Name Special Coffee",560.0, 10));
        IO.println("List is ready!!!");
    }

    @Override
    public List<Coffee> getAllCoffees() {
        return coffeeList;
    }

    @Override
    public Coffee getCoffeeById(int id) {
        for(Coffee coffee:coffeeList){
            if (coffee.getId()==id) return coffee;
        }
        throw new CoffeeNotFoundException("Paini bhai!!!");
    }

    @Override
    public Coffee addCoffee(Coffee coffee) {
        coffeeList.add(coffee);
        return coffee;
    }

    @Override
    public Coffee updateCoffee(int id, Coffee coffee) {
        Coffee c=getCoffeeById(id);
        c.setName(coffee.getName());
        c.setCategory(coffee.getCategory());
        c.setPrice(coffee.getPrice());
        c.setStock(coffee.getStock());
        return c;
    }

    @Override
    public void deleteCoffee(int id) {
//        Coffee c = getCoffeeById(id);
        coffeeList.remove(getCoffeeById(id));
    }

    @Override
    public List<Coffee> searchByName(String name) {
        List<Coffee> result = new ArrayList<>();
        for (Coffee coffee : coffeeList) {
            if (coffee.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(coffee);
            }
        }
        return result;
    }

    @Override
    public List<Coffee> getByCategory(String category) {
        List<Coffee> result = new ArrayList<>();
        for (Coffee coffee : coffeeList) {
            if (coffee.getCategory().equalsIgnoreCase(category)) {
                result.add(coffee);
            }
        }
        return result;
    }

    @Override
    public Coffee updateStock(int id, int stock) {
        Coffee coffee = getCoffeeById(id);
        coffee.setStock(stock);
        return coffee;
    }

    @Override
    public List<Coffee> getCoffeeByPriceRange(Double startPrice, Double endPrice) {
        List<Coffee> range = new ArrayList<>();
        for(Coffee c : coffeeList){
            if(c.getPrice()>=startPrice && c.getPrice()<=endPrice) range.add(c);
        }
        return range;
    }
}
