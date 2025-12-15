package com.example.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "mytask")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "taskid")
    private Long id;
    @Column(name = "tasktitle", nullable = false)
    private String title;
    @Column(name = "taskdescription", nullable = false)
    private String description;
    @Column(name = "taskcompleted", nullable = false)
    private boolean completed;
}
