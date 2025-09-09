package com.unidirectional.repository;

import com.unidirectional.entity.Address;
import com.unidirectional.entity.Order;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

@DataJpaTest
public class OrderRepositoryTest {
    @Autowired
    private OrderRepository orderRepository;

    @Test
    void saveOrder() {
        Order order = new Order();
        order.setOrderName("table");
        order.setOrderPrice(1000.00);

        Address address = new Address();
        address.setCity("Kolkata");
        address.setState("West Bengal");

        order.setAddress(address);

        orderRepository.save(order);
    }

}
