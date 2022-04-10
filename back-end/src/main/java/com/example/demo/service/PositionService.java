package com.example.demo.service;


import com.example.demo.entity.Position;

import com.example.demo.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PositionService {
    @Autowired
    PositionRepository positionRepository;

    public Page<Position> getAll(Integer page, Integer size) {
        return positionRepository.findAll(PageRequest.of(page, size));
    }

    public Position getReferenceById(Integer id) {
        return positionRepository.getById(id);
    }

    public Position save(Position position) {
        return positionRepository.save(position);
    }

    public void update(Position position) {
        positionRepository.save(position);
    }

    public void delete(Position position) {
        positionRepository.delete(position);
    }

    public Optional<Position> getById(Integer id) {
        return positionRepository.findById(id);
    }
}