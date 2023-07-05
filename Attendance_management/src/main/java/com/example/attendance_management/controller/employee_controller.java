package com.example.attendance_management.controller;

import com.example.attendance_management.entity.employee;
import com.example.attendance_management.service.employee_service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class employee_controller {
    @Autowired
    private employee_service service;

    @PostMapping("/employee")
    public employee addEmployee(@RequestBody employee employee) {
        // Set default attendance status to true when adding a new employee
        employee.setPresent(true);
        return service.saveEmployee(employee);
    }

    @PostMapping("/addEmployees")
    public List<employee> addEmployees(@RequestBody List<employee> employees) {
        // Set default attendance status to true when adding multiple employees
        employees.forEach(employee -> employee.setPresent(true));
        return service.saveEmployees(employees);
    }
    @GetMapping("/employeeById/{id}")
    public employee findProductById(@PathVariable int id) {
        return service.getemployeeById(id);
    }
    @GetMapping("/employee/{name}")
    public employee findProductByName(@PathVariable String name) {
        return service.getemployeeByName(name);
    }
    @PutMapping("/update")
    public employee updateProduct(@RequestBody employee product) {
        return service.updateProduct(product);
    }
    @DeleteMapping("/delete/{id}")
    public String deleteEmployee (@PathVariable int id) {
        return service.deleteemployee(id);
    }
    @PostMapping("/markAttendance/{id}/{present}")
    public employee markAttendance(@PathVariable int id, @PathVariable boolean present) {
        return service.markAttendance(id, present);
    }
    @GetMapping("/employee/{id}/monthlySalary")
    public double calculateMonthlySalary(@PathVariable int id) {
        return service.calculateMonthlySalary(id);
    }
}
