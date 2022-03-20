package com.example.demo.service;

import com.example.demo.model.Employee;
import com.example.demo.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;


    public List<Employee> gitAllEmployee() {
        return (List<Employee>) employeeRepository.findAll();
    }
    public Optional<Employee> gitEmployeeById(long id) {
        return employeeRepository.findById(id);
    }
    public void addEmployee(Employee employee) {
        employeeRepository.save(employee);
    }
    public void updateEmployee(Employee employee) {
        employeeRepository.save(employee);
    }
    public void deleteEmployee(long id) {
        employeeRepository.deleteById(id);
    }


}

