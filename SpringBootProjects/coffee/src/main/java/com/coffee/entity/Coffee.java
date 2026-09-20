package com.coffee.entity;

import lombok.*;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter @ToString
//@Entity
public class Coffee {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String category;
    private Double price;
    private Integer stock;
}
