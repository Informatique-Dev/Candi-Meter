package com.example.demo.service;

import com.example.demo.model.TopicLevel;
import com.example.demo.repository.TopicLevelRepository;
import com.example.demo.rest.dto.TopicLevelDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicLevelService {
    @Autowired
    TopicLevelRepository topicLevelRepository;
    public List<TopicLevel> getAllTopicLevel(){
        return (List<TopicLevel>) topicLevelRepository.findAll();
    }
    public TopicLevel getTopicLevelById(long id){
        return topicLevelRepository.findById(id).orElseThrow(null);
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