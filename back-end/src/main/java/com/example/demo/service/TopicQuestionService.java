package com.example.demo.service;

import com.example.demo.model.TopicQuestion;
import com.example.demo.repository.TopicQuestionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TopicQuestionService {
    @Autowired
    TopicQuestionRepository topicQuestionRepository;
    public List<TopicQuestion> getAllTopicQuestion(){
        return (List<TopicQuestion>) topicQuestionRepository.findAll();
    }
    public Optional<TopicQuestion> getTopicQuestionById(long id){
        return topicQuestionRepository.findById(id);
    }
    public void addTopicQuestion(TopicQuestion topicQuestion){
        topicQuestionRepository.save(topicQuestion);
    }
    public void updateTopicQuestion(TopicQuestion topicQuestion){
        topicQuestionRepository.save(topicQuestion);
    }
    public void deleteTopicQuestion(long id){
        topicQuestionRepository.deleteById(id);
    }
}