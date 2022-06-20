package com.example.demo.service;

import com.example.demo.entity.TopicRate;
import com.example.demo.repository.TopicRateRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class TopicRateService {
    private TopicRateRepository topicRateRepository;

    public Page<TopicRate> getAll(Integer page, Integer size) {
        return topicRateRepository.findAll(PageRequest.of(page, size));
    }

    public TopicRate getReferenceById(Integer id) {
        return topicRateRepository.getById(id);
    }

    public TopicRate save(TopicRate topicRate) {
        return topicRateRepository.save(topicRate);
    }

    public void update(TopicRate topicRate) {
        topicRateRepository.save(topicRate);
    }

    public void delete(TopicRate topicRate) {
        topicRateRepository.delete(topicRate);
    }

    public Optional<TopicRate> getById(Integer id) {
        return topicRateRepository.findById(id);
    }
}