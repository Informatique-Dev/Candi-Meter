package com.example.demo.service;

import com.example.demo.model.Position;
import com.example.demo.repository.PositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class PositionService {
    @Autowired
    PositionRepository positionRepository;

    public List<Position> getAllPosition() {
        return (List<Position>) positionRepository.findAll();
    }

    public Position getPositionById(long id) {
        return (Position) positionRepository.findAllById(Collections.singleton(id));
    }

    public void addPosition(Position position) {
        positionRepository.save(position);
    }

    public void updatePosition(Position position) {
        positionRepository.save(position);
    }

    public void deletePositionById(long id) {
        positionRepository.deleteById(id);
    }
}