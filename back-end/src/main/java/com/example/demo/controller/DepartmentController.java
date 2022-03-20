package com.example.demo.controller;


import com.example.demo.model.Department;
import com.example.demo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController("/department")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;
    @GetMapping("/all")
    public List<Department> gitAllDepartment(){
        return departmentService.getAllDepartment();
    }
    @GetMapping("/id")
    public Optional<Department> gitDepartmentById(@RequestParam long id){
        return departmentService.gitDepartmentById(id);
    }
    @PostMapping("/add")
    public String addDepartment(@RequestBody Department department){
        departmentService.addDepartment(department);
        return "Added Successfully";
    }
    @PutMapping("/update")
    public String updateDepartment(@RequestBody Department department){
        departmentService.updateDepartment(department);
        return "Updated Successfully";
    }
    @DeleteMapping("/delete")
    public String deleteDepartment(@RequestParam long id){
        departmentService.deleteDepartment(id);
        return "Deleted Successfully";
    }
}

