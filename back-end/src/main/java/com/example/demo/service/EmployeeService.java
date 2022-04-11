package com.example.demo.service;

import com.example.demo.entity.Employee;
import com.example.demo.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class EmployeeService {
    private EmployeeRepository employeeRepository;

    public Page<Employee> getAll(Integer page, Integer size){
        return employeeRepository.findAll(PageRequest.of(page, size));
    }

    public Employee getReferenceById(Integer id){
        return employeeRepository.getById(id);
    }

    public Employee save(Employee employee){
        return employeeRepository.save(employee);
    }

    public void update(Employee employee){
        employeeRepository.save(employee);
    }

    public void delete(Employee employee){
        employeeRepository.delete(employee);
    }

    public Optional<Employee> getById(Integer id){
        return employeeRepository.findById(id);
    }


}
