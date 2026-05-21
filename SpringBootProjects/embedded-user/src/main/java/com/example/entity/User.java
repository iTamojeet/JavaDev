package com.example.entity;

import jakarta.persistence.*;
import lombok.*;

@AllArgsConstructor@NoArgsConstructor@Getter@Setter@ToString
@Entity
@Table(name = "jaliuser")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;
    private String name;
    private String email;
    @Embedded
    private Address address;
}
