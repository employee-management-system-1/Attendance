package com.example.attendance_management.service;

import com.example.attendance_management.entity.employee;
import com.example.attendance_management.repository.employee_repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class employee_service {
    @Autowired
    private employee_repository repository;

    public employee saveEmployee(employee employee) {
        return repository.save(employee);

    }

    public List<employee> saveProducts(List<employee> employees) {
        return repository.saveAll(employees);
    }

    public List<employee> getEmployees() {
        return repository.findAll();
    }

    public employee getemployeeById(int id) {
        return repository.findById(id).orElse(null);
    }

    public employee getemployeeByName(String name) {
        return repository.findByName(name);
    }

    public String deleteemployee(int id) {
        repository.deleteById(id);
        return "employee removed !! " + id;
    }

    public employee updateProduct(employee employee) {
        employee existingEmployee = null;
        if (existingEmployee != null) {
            existingEmployee = repository.findById(employee.getId()).orElse(null);
            existingEmployee.setName(employee.getName());
            existingEmployee.setAge(employee.getAge());
            existingEmployee.setSalary(employee.getSalary());
            existingEmployee.setPresent(employee.isPresent());
            return repository.save(existingEmployee);
        } else {
            return null;
        }
    }
    public employee markAttendance(int id, boolean present) {
        employee employee = repository.findById(id).orElse(null);
        if (employee != null) {
            employee.setPresent(present);
            return repository.save(employee);
        } else {
            return null;
        }
    }
    public double calculateMonthlySalary(int employeeId) {
        employee employee = repository.findById(employeeId).orElse(null);
        if (employee != null) {
            int totalWorkingDays = employee.getWorkingDays();
            int totalPresentDays = getemployeePresentDays(employeeId);
            double monthlySalary = (totalPresentDays / (double) totalWorkingDays) * employee.getSalary();
            return Math.round(monthlySalary * 100.0) / 100.0; // Round to 2 decimal places
        }
        return 0.0;
    }

    private int getemployeePresentDays(int employeeId) {
        return employeeId;
    }

    private int getEmployeePresentDays(int employeeId) {
      
        int totalWorkingDays = repository.findById(employeeId).map(employee::getWorkingDays).orElse(0);
        return (int) (Math.random() * totalWorkingDays) + 1;
    }

    public List<employee> saveEmployees(List<employee> employees) {
        return employees;
    }
}

