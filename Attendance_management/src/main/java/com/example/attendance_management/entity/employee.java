package com.example.attendance_management.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name="employee_data")
public class employee {
    @Id
    @GeneratedValue
    private int id;
    private String name;
    private int age;
    private double salary;
    private boolean present;
    private int workingDays;


}
