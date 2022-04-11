package com.example.demo.service;

import com.example.demo.entity.Position;
import com.example.demo.entity.Topics;
import com.example.demo.repository.PositionRepository;
import com.example.demo.repository.TopicsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;


@Service
public class TopicsService {
    @Autowired
    TopicsRepository topicsRepository;

    public Page<Topics> getAll(Integer page, Integer size) {
        return topicsRepository.findAll(PageRequest.of(page, size));
    }

    public Topics getReferenceById(Integer id) {
        return topicsRepository.getById(id);
    }

    public Topics save(Topics topics) {
        return topicsRepository.save(topics);
    }

    public void update(Topics topics) {
        topicsRepository.save(topics);
    }

    public void delete(Topics topics) {
        topicsRepository.delete(topics);
    }

    public Optional<Topics> getById(Integer id) {
        return topicsRepository.findById(id);
    }
}