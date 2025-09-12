package com.bidirectional.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Entity
@Table(name = "oraorder")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer orderId;
    private String orderName;
    private Double orderPrice;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "order")
    private Address address;
}
