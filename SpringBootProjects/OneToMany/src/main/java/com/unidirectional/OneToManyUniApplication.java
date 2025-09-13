package com.unidirectional;

import com.unidirectional.entity.Order;
import com.unidirectional.entity.OrderItem;
import com.unidirectional.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Set;

@SpringBootApplication
public class OneToManyUniApplication implements CommandLineRunner {

    @Autowired
    private OrderRepository orderRepository;

    public static void main(String[] args) {
        SpringApplication.run(OneToManyUniApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Order order = new Order();
        order.setOrderName("Amazon");
        order.setStatus("set");

        OrderItem orderItem1 = new OrderItem();
        orderItem1.setItemName("item1");
        orderItem1.setItemPrice(100.2);
        OrderItem orderItem2 = new OrderItem();
        orderItem2.setItemName("item2");
        orderItem2.setItemPrice(200.2);
        OrderItem orderItem3 = new OrderItem();
        orderItem3.setItemName("item3");
        orderItem3.setItemPrice(300.2);

        order.setOrderItems(Set.of(orderItem1, orderItem2, orderItem3));

        orderRepository.save(order);
        System.out.println("-".repeat(60));

        Order order2 = new Order();
        order2.setOrderName("Flipkat");
        order2.setStatus("set");

        OrderItem orderItem4 = new OrderItem();
        orderItem4.setItemName("item4");
        orderItem4.setItemPrice(6000.00);
        OrderItem orderItem5 = new OrderItem();
        orderItem5.setItemName("item5");
        orderItem5.setItemPrice(7007.09);
        OrderItem orderItem6 = new OrderItem();
        orderItem6.setItemName("item6");
        orderItem6.setItemPrice(10000.69);

        order2.setOrderItems(Set.of(orderItem4, orderItem5, orderItem6));
        orderRepository.save(order2);
        System.out.println("-".repeat(60));

    }
}
