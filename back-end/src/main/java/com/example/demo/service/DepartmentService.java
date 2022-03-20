package com.example.demo.service;


import com.example.demo.model.Department;
import com.example.demo.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartmentService {
    @Autowired
    DepartmentRepository departmentRepository;

    public List<Department> getAllDepartment(){
        return (List<Department>) departmentRepository.findAll();
    }
    public Optional<Department> gitDepartmentById(long id){
        return  departmentRepository.findById(id);
    }
    public void addDepartment(Department department){
        departmentRepository.save(department);
    }
    public void updateDepartment(Department department){
        departmentRepository.save(department);
    }
    public void deleteDepartment(long id){
        departmentRepository.deleteById(id);
    }


}

