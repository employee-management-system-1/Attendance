package com.example.attendance_management.repository;

import com.example.attendance_management.entity.employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface employee_repository extends JpaRepository <employee, Integer> {
    employee findByName(String name);
}
