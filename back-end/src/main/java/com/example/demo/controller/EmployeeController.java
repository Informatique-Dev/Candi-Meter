package com.example.demo.controller;


import com.example.demo.model.Employee;
import com.example.demo.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController("/employee")

public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @GetMapping("/all")
    public List<Employee> gitAllEmployee(){
        return employeeService.gitAllEmployee();
    }
    @GetMapping("/id")
    public Optional<Employee> gitEmployeeById(@RequestParam long id){
        return employeeService.gitEmployeeById(id);
    }
    @PostMapping("/add")
    public String addEmployee(@RequestBody Employee employee){
        employeeService.addEmployee(employee);
        return "Added Successfully";
    }
    @PutMapping("/update")
    public String updateEmployee(@RequestBody Employee employee){
        employeeService.updateEmployee(employee);
        return "Updated Successfully";
    }
    @DeleteMapping("/delete")
    public String deleteEmployee(@RequestParam long id){
        employeeService.deleteEmployee(id);
        return "Deleted Successfully";
    }

}

