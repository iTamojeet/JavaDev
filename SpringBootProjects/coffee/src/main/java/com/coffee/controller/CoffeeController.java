package com.coffee.controller;

import com.coffee.entity.Coffee;
import com.coffee.service.CoffeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/coffees")
@AllArgsConstructor
public class CoffeeController {

    private final CoffeeService coffeeService;

    @GetMapping
    public ResponseEntity<List<Coffee>> getAllCoffees(){
        return ResponseEntity.ok(coffeeService.getAllCoffees());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Coffee> getCoffeeById(@PathVariable Integer id){
        return ResponseEntity.ok(coffeeService.getCoffeeById(id));
    }

    @PostMapping
    public ResponseEntity<Coffee> addCoffee(@RequestBody Coffee coffee) {
        Coffee savedCoffee = coffeeService.addCoffee(coffee);
        return new ResponseEntity<>(savedCoffee, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Coffee> updateCoffee(@PathVariable int id, @RequestBody Coffee coffee) {
        return ResponseEntity.ok(coffeeService.updateCoffee(id, coffee));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteCoffee(@PathVariable int id) {
        coffeeService.deleteCoffee(id);
        return ResponseEntity.ok("Coffee deleted successfully ₹₹₹");
    }

    @GetMapping("/search")
    public ResponseEntity<List<Coffee>> searchCoffee(@RequestParam String name) {
        return ResponseEntity.ok(coffeeService.searchByName(name));
    }

    @GetMapping("/category/{category}")
    public ResponseEntity<List<Coffee>> getByCategory(@PathVariable String category) {
        return ResponseEntity.ok(coffeeService.getByCategory(category));
    }

    @PatchMapping("/{id}/stock")
    public ResponseEntity<Coffee> updateStock(@PathVariable int id, @RequestParam int stock) {
        return ResponseEntity.ok(coffeeService.updateStock(id, stock));
    }

    @GetMapping("/range")
    public ResponseEntity<List<Coffee>> rangeOfCoffeeByPrice(@RequestParam Double startPrice, @RequestParam Double endPrice){
        return ResponseEntity.ok(coffeeService.getCoffeeByPriceRange(startPrice, endPrice));
    }
}
