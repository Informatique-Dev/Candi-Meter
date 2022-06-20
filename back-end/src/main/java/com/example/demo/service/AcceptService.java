package com.example.demo.service;

import com.example.demo.entity.Accept;
import com.example.demo.entity.Company;
import com.example.demo.repository.AcceptRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class AcceptService {
    private AcceptRepository acceptRepository;

    public Page<Accept> getAll(Integer page, Integer size) {
        return acceptRepository.findAll(PageRequest.of(page, size));
    }

    public Accept getReferenceById(Integer id) {
        return acceptRepository.getById(id);
    }

    public Accept save(Accept accept) {
        return acceptRepository.save(accept);
    }

    public void update(Accept accept) {
        acceptRepository.save(accept);
    }

    public void delete(Accept accept) {
        acceptRepository.delete(accept);
    }

    public Optional<Accept> getById(Integer id) {
        return acceptRepository.findById(id);
    }
}

