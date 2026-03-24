package com.example.service.impl;

import com.example.entity.Vehicle;
import com.example.exception.VehicleException;
import com.example.service.VehicleService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;
import java.util.stream.Collectors;

@Service
public class VehicleServiceImpl implements VehicleService {

    private Map<String, Vehicle> vehicleMap = new ConcurrentHashMap<>();

    @Override
    public Vehicle addVehicle(Vehicle vehicle) {
        vehicleMap.put(vehicle.getId(), vehicle);
        return vehicle;
    }

//    @Override
//    public List<Vehicle> getAllVehicle() {
//        return new ArrayList<>(vehicleMap.values());
//    }

    @Override
    public List<Vehicle> getAllVehicle() {
        return vehicleMap.values()
                .stream()
                .collect(Collectors.toUnmodifiableList());
    }

    @Override
    public Vehicle getVehicleById(String id) {
        return Optional.ofNullable(vehicleMap.get(id))
                .orElseThrow(()->new VehicleException("Dhur tor bal er vehicle pelam na!!!!"));
    }

    @Override
    public Vehicle updateVehicle(String id, Vehicle vehicle) {
        return Optional.ofNullable(vehicleMap.get(id))
                .map(e->{
                    e.setName(vehicle.getName());
                    e.setPrice(vehicle.getPrice());
                    return e;
                }).orElseThrow(()->new VehicleException("Dhur tor bal er vehicle pelam na!!!!"));
    }

    @Override
    public String deleteVehicle(String id) {
        return Optional.ofNullable(vehicleMap.remove(id))
                .map(e->"DELETED SUCCESSFULLY!!!")
                .orElseThrow(()->new VehicleException("Dhur tor bal er vehicle pelam na!!!!"));
    }
}
