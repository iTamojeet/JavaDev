package com.example.service;

import com.example.entity.Vehicle;

import java.util.List;

public interface VehicleService {
    Vehicle addVehicle(Vehicle vehicle);
    List<Vehicle> getAllVehicle();
    Vehicle getVehicleById(String id);
    Vehicle updateVehicle(String id, Vehicle vehicle);
    String deleteVehicle(String id);
}
