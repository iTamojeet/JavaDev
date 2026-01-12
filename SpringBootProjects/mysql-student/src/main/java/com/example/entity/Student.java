package com.example.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "dockertab")
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
@Builder
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String email;
}
