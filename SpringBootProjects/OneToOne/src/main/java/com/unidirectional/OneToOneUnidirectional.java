package com.unidirectional;

import com.unidirectional.entity.Address;
import com.unidirectional.entity.Order;
import com.unidirectional.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OneToOneUnidirectional implements CommandLineRunner {

    @Autowired
    private OrderRepository orderRepository;

    public static void main(String[] args)  {
        SpringApplication.run(OneToOneUnidirectional.class, args);
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

        orderRepository.save(order);
        System.out.println("-".repeat(60));
        Order order1 = orderRepository.findByOrderName("table");
        System.out.println(order1.getAddress().getCity()+" "+order1.getAddress().getState());
    }
}
