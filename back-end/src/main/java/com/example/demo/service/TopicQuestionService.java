package com.example.demo.service;

import com.example.demo.model.TopicQustion;
import com.example.demo.repository.TopicQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopicQuestionService {
    @Autowired
    TopicQuestionRepository topicQuestionRepository;
    public List<TopicQustion> getAllTopicQuestion(){
        return (List<TopicQustion>) topicQuestionRepository.findAll();
    }
    public Optional<TopicQustion> getTopicQuestionById(long id){
        return topicQuestionRepository.findById(id);
    }
    public void addTopicQuestion(TopicQustion topicQustion){
        topicQuestionRepository.save(topicQustion);
    }
    public void updateTopicQuestion(TopicQustion topicQustion){
        topicQuestionRepository.save(topicQustion);
    }
    public void deleteTopicQuestion(long id){
        topicQuestionRepository.deleteById(id);
    }
}
