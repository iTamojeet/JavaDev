package com.example.config;

import com.example.entity.Vehicle;
import com.example.service.VehicleService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner loadData(VehicleService vehicleService) {
        return args -> {
            vehicleService.addVehicle(new Vehicle("1", "Audi", 1000000.));
            vehicleService.addVehicle(new Vehicle("2", "BMW", 10000000.));
            vehicleService.addVehicle(new Vehicle("3", "Lotus", 2000000.));
            vehicleService.addVehicle(new Vehicle("4", "Maruti Suzuki", 500000.));
            vehicleService.addVehicle(new Vehicle("5", "Honda", 900000.));
            vehicleService.addVehicle(new Vehicle("6", "Bangla TMC EV", 1000.));
            vehicleService.addVehicle(new Vehicle("7", "Toyota", 1500000.));
            vehicleService.addVehicle(new Vehicle("8", "Mahindra", 800000.));
            vehicleService.addVehicle(new Vehicle("9", "Jeep", 100000.));
            vehicleService.addVehicle(new Vehicle("10", "Range Rover", 8000000.));
            vehicleService.addVehicle(new Vehicle("11", "Tesla", 6000000.));
        };
    }
}
