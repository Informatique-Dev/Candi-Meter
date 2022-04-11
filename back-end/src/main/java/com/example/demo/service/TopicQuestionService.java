package com.example.demo.service;

import com.example.demo.entity.TopicQuestion;
import com.example.demo.entity.Topics;
import com.example.demo.repository.TopicQuestionRepository;
import com.example.demo.repository.TopicsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopicQuestionService {
    @Autowired
    TopicQuestionRepository topicQuestionRepository;

    public Page<TopicQuestion> getAll(Integer page, Integer size) {
        return topicQuestionRepository.findAll(PageRequest.of(page, size));
    }

    public TopicQuestion getReferenceById(Integer id) {
        return topicQuestionRepository.getById(id);
    }

    public TopicQuestion save(TopicQuestion topicQuestion) {
        return topicQuestionRepository.save(topicQuestion);
    }

    public void update(TopicQuestion topicQuestion) {
        topicQuestionRepository.save(topicQuestion);
    }

    public void delete(TopicQuestion topicQuestion) {
        topicQuestionRepository.delete(topicQuestion);
    }

    public Optional<TopicQuestion> getById(Integer id) {
        return topicQuestionRepository.findById(id);
    }
}