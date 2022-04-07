package com.example.demo.service;

import com.example.demo.entity.Company;
import com.example.demo.entity.Vacancy;
import com.example.demo.repository.CompanyRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class CompanyService {
    private CompanyRepository companyRepository;

    public Page<Company> getAll(Integer page, Integer size) {
        return companyRepository.findAll(PageRequest.of(page, size));
    }

    public Company getReferenceById(Integer id) {
        return companyRepository.getById(id);
    }

    public Company save(Company company) {
        return companyRepository.save(company);
    }

    public void update(Company company) {
        companyRepository.save(company);
    }

    public void delete(Company company) {
        companyRepository.delete(company);
    }

    public Optional<Company> getById(Integer id) {
        return companyRepository.findById(id);
    }
}
