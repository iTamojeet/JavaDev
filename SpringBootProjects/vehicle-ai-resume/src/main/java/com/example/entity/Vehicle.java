package com.example.entity;

public class Vehicle {
    private String id;
    private String name;
    private Double price;

    public Vehicle() {
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Vehicle(String id, String name, Double price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }
}
