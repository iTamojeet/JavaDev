package com.bidirectional;

import com.bidirectional.entity.Address;
import com.bidirectional.entity.Order;
import com.bidirectional.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OneToOneBidirectional implements CommandLineRunner {
    @Autowired
    private AddressRepository addressRepository;

    public static void main(String[] args)  {
        SpringApplication.run(OneToOneBidirectional.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Order order = new Order();
        order.setOrderName("table");
        order.setOrderPrice(1000.00);

        Address address = new Address();
        address.setCity("Kolkata");
        address.setState("West Bengal");

        order.setAddress(address);
        address.setOrder(order);

        addressRepository.save(address); // saves both
    }
}
