package com.example.demo.service;

import com.example.demo.model.Topics;
import com.example.demo.repository.TopicsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;

@Service
public class TopicsService {
    @Autowired
    TopicsRepository topicsRepository;
    public List<Topics> getAllTopics(){
        return (List<Topics>) topicsRepository.findAll();
    }
    public Topics getAllTopicsById(long id){
        return (Topics) topicsRepository.findAllById(Collections.singleton(id));
    }
    public void addTopics(Topics topics){
        topicsRepository.save(topics);
    }
    public void updateTopics(Topics topics){
        topicsRepository.save(topics);

    }
    public void deleteTopics(long id){
        topicsRepository.deleteById(id);
    }
}
