package com.example.controller;

import com.example.entity.Vehicle;
import com.example.service.VehicleService;
import com.example.service.impl.OpenAIService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("vehicles")
public class VehicleController {

    @Autowired
    private VehicleService vehicleService;
    @Autowired
    private OpenAIService openAIService;

    @PostMapping
    public Vehicle createVehicle(@RequestBody Vehicle vehicle) {
        return vehicleService.addVehicle(vehicle);
    }

    @GetMapping("{id}")
    public Vehicle getVehicleById(@PathVariable String id) {
        return vehicleService.getVehicleById(id);
    }

    @GetMapping
    public List<Vehicle> getAllVehicles() {
        return vehicleService.getAllVehicle();
    }

    @PutMapping("{id}")
    public Vehicle updateVehicle(@PathVariable String id, @RequestBody Vehicle vehicle) {
        return vehicleService.updateVehicle(id, vehicle);
    }

    @DeleteMapping("{id}")
    public String deleteVehicle(@PathVariable String id) {
        return vehicleService.deleteVehicle(id);
    }

    // AI Controller
    @GetMapping("/ai/{id}")
    public String getVehicleSuggestedByAI(@PathVariable String id) {
        Vehicle vehicle = vehicleService.getVehicleById(id);
        return openAIService.askAI("GIVE DESCRIPTION OF THE VEHICLE: " + vehicle.getName());
    }
}
