package com.example.demo.service;

import com.example.demo.model.TopicLevel;
import com.example.demo.repository.TopicLevelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopicLevelService {
    @Autowired
    TopicLevelRepository topicLevelRepository;
    public List<TopicLevel> getAllTopicLevel(){
        return (List<TopicLevel>) topicLevelRepository.findAll();
    }
    public Optional<TopicLevel> getTopicLevelById(long id){
        return topicLevelRepository.findById(id);
    }
    public void addTopicLevel(TopicLevel topicLevel){
        topicLevelRepository.save(topicLevel);

    }
    public void updateTopicLevel(TopicLevel topicLevel){
        topicLevelRepository.save(topicLevel);

    }
    public void deleteTopicLevel(long id){
        topicLevelRepository.deleteById(id);
    }

}