package com.example.demo.rest.handler;

import com.example.demo.entity.Employee;
import com.example.demo.rest.dto.EmployeeDto;
import com.example.demo.rest.dto.common.PaginatedResultDto;
import com.example.demo.rest.entitymapper.EmployeeMapper;
import com.example.demo.rest.entitymapper.common.PaginationMapper;
import com.example.demo.rest.exception.ResourceNotFoundException;
import com.example.demo.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.util.List;

@Component
@AllArgsConstructor
public class EmployeeHandler {
    @Autowired
    private EmployeeService employeeService;
    private EmployeeMapper employeeMapper;
    private PaginationMapper paginationMapper;

    public ResponseEntity<?> getAll (Integer page,Integer size){
        Page<Employee> employeePage = employeeService.getAll(page,size);
        List<EmployeeDto> employeeDtoList = employeeMapper.toDto(employeePage.getContent());
        PaginatedResultDto<EmployeeDto> paginatedResult = new PaginatedResultDto<>();
        paginatedResult.setData(employeeDtoList);
        paginatedResult.setPagination(paginationMapper.toPaginationDto(employeePage));
        return ResponseEntity.ok(paginatedResult);
    }

    public ResponseEntity<?> save(EmployeeDto dto){
        Employee employee = employeeMapper.toEntity(dto);
        employeeService.save(employee);
        EmployeeDto employeeDto = employeeMapper.toDto(employee);
        return ResponseEntity.created(URI.create("/employee/" + employee.getId())).body(employeeDto);
    }

    public ResponseEntity<?> update(Integer id, EmployeeDto dto){
        Employee employee = employeeService.getById(id).
                orElseThrow(() -> new ResourceNotFoundException(Employee.class.getSimpleName(), id));
        employeeMapper.updateEntityFromDto(dto, employee);
        employeeService.update(employee);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<?> getById(Integer id){
        Employee employee = employeeService.getById(id).
                orElseThrow(() -> new ResourceNotFoundException(Employee.class.getSimpleName(), id));
        EmployeeDto employeeDto = employeeMapper.toDto(employee);
        return ResponseEntity.ok(employeeDto);
    }

    public ResponseEntity<?> delete(Integer id){
        Employee employee = employeeService.getById(id).
                orElseThrow(() -> new ResourceNotFoundException(Employee.class.getSimpleName(), id));
        employeeService.delete(employee);
        return ResponseEntity.noContent().build();
    }

}
