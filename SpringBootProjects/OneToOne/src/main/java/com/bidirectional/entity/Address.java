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
@Table(name = "oraaddress")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer addressId;
    private String city;
    private String state;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "order_id", referencedColumnName = "orderId")
    private Order order;

}
