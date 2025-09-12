package com.bidirectional.repository;


import com.bidirectional.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Long> {

    public Order findByOrderName(String orderName);
}
