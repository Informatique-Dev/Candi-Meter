package com.example.demo.rest.handler;

import com.example.demo.entity.Company;
import com.example.demo.rest.dto.CompanyDto;
import com.example.demo.rest.dto.common.PaginatedResultDto;
import com.example.demo.rest.entitymapper.CompanyMapper;
import com.example.demo.rest.entitymapper.common.PaginationMapper;
import com.example.demo.rest.exception.ResourceNotFoundException;
import com.example.demo.service.CompanyService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.net.URI;
import java.util.List;

@Component
@AllArgsConstructor
public class CompanyHandler {
    @Autowired
    private CompanyService companyService;
    private CompanyMapper companyMapper;
    private PaginationMapper paginationMapper;

    public ResponseEntity<?> getAll(Integer page, Integer size) {
        Page<Company> companyPage = companyService.getAll(page, size);
        List<CompanyDto> companyDtoList = companyMapper.toDto(companyPage.getContent());
        PaginatedResultDto<CompanyDto> paginatedResult = new PaginatedResultDto<>();
        paginatedResult.setData(companyDtoList);
        paginatedResult.setPagination(paginationMapper.toPaginationDto(companyPage));
        return ResponseEntity.ok(paginatedResult);
    }

    public ResponseEntity<?> save(CompanyDto dto) {
        Company company = companyMapper.toEntity(dto);
        companyService.save(company);
        CompanyDto companyDto = companyMapper.toDto(company);
        return ResponseEntity.created(URI.create("/company/" + company.getId())).body(companyDto);
    }

    public ResponseEntity<?> update(Integer id, CompanyDto dto){
        Company company = companyService.getById(id).
                orElseThrow(() -> new ResourceNotFoundException(Company.class.getSimpleName(), id));
        companyMapper.updateEntityFromDto(dto, company);
        companyService.update(company);
        return ResponseEntity.ok().build();
    }

    public ResponseEntity<?> getById(Integer id){
        Company company = companyService.getById(id).
                orElseThrow(() -> new ResourceNotFoundException(Company.class.getSimpleName(), id));
        CompanyDto companyDto = companyMapper.toDto(company);
        return ResponseEntity.ok(companyDto);
    }

    public ResponseEntity<?> delete(Integer id){
        Company company = companyService.getById(id).
                orElseThrow(() -> new ResourceNotFoundException(Company.class.getSimpleName(), id));
        companyService.delete(company);
        return ResponseEntity.noContent().build();
    }
}
