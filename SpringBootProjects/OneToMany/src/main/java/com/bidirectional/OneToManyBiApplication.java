package com.bidirectional;

import com.bidirectional.entity.Order;
import com.bidirectional.entity.OrderItem;
import com.bidirectional.repository.OrderRepository;
import com.bidirectional.repository.OrderItemRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor
@SpringBootApplication
public class OneToManyBiApplication implements CommandLineRunner {

    private OrderRepository orderRepository;
    private OrderItemRepository orderItemRepository;

    public static void main(String[] args) {
        SpringApplication.run(OneToManyBiApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Order order1 = new Order();
        order1.setOrderName("Amazon");
        order1.setStatus("Processing");

        OrderItem item1 = new OrderItem();
        item1.setItemName("Laptop");
        item1.setItemPrice(50000.0);
        item1.setOrder(order1); // set the parent reference

        OrderItem item2 = new OrderItem();
        item2.setItemName("Headphones");
        item2.setItemPrice(2000.0);
        item2.setOrder(order1);

        OrderItem item3 = new OrderItem();
        item3.setItemName("Mouse");
        item3.setItemPrice(800.0);
        item3.setOrder(order1);

        Set<OrderItem> items1 = new HashSet<>();
        items1.add(item1);
        items1.add(item2);
        items1.add(item3);

        order1.setOrderItems(items1);

        orderRepository.save(order1);

        System.out.println("Saved Order 1: " + order1);

        // Create second order
        Order order2 = new Order();
        order2.setOrderName("Flipkart");
        order2.setStatus("Shipped");

        OrderItem item4 = new OrderItem();
        item4.setItemName("Mobile");
        item4.setItemPrice(15000.0);
        item4.setOrder(order2);

        OrderItem item5 = new OrderItem();
        item5.setItemName("Charger");
        item5.setItemPrice(1500.0);
        item5.setOrder(order2);

        OrderItem item6 = new OrderItem();
        item6.setItemName("Earbuds");
        item6.setItemPrice(3000.0);
        item6.setOrder(order2);

        Set<OrderItem> items2 = new HashSet<>();
        items2.add(item4);
        items2.add(item5);
        items2.add(item6);

        order2.setOrderItems(items2);

        orderRepository.save(order2);

        System.out.println("Saved Order 2: " + order2);

        System.out.println(orderItemRepository.findById(4).get());

    }
}
