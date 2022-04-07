package com.example.demo.service;


import com.example.demo.entity.TopicLevel;
import com.example.demo.repository.TopicLevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;


import java.util.Optional;

@Service
public class TopicLevelService {
    @Autowired
    TopicLevelRepository topicLevelRepository;
    public Page<TopicLevel> getAll(Integer page, Integer size) {
        return topicLevelRepository.findAll(PageRequest.of(page, size));
    }

    public TopicLevel getReferenceById(Integer id) {
        return topicLevelRepository.getById(id);
    }

    public TopicLevel save(TopicLevel topicLevel) {
        return topicLevelRepository.save(topicLevel);
    }

    public void update(TopicLevel topicLevel) {
        topicLevelRepository.save(topicLevel);
    }

    public void delete(TopicLevel topicLevel) {
        topicLevelRepository.delete(topicLevel);
    }

    public Optional<TopicLevel> getById(Integer id) {
        return topicLevelRepository.findById(id);
    }
}