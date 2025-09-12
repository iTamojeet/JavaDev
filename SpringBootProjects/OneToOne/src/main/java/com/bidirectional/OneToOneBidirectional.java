package com.bidirectional;

import com.bidirectional.entity.Address;
import com.bidirectional.entity.Order;
import com.bidirectional.repository.AddressRepository;
import com.bidirectional.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class OneToOneBidirectional implements CommandLineRunner {
    @Autowired
    private AddressRepository addressRepository;
    @Autowired
    private OrderRepository orderRepository;

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

        System.out.println("-".repeat(1000));
        Order order2 = orderRepository.findByOrderName("table");
        System.out.println(order2.getAddress().getCity()+" "+order2.getAddress().getState());

        System.out.println("-".repeat(1000));
        Address ad=addressRepository.findById(1).get();
        System.out.println(ad.getOrder().getOrderName()+" "+ad.getOrder().getOrderPrice());
    }
}
