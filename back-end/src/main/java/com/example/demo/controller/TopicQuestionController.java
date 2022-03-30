package com.example.demo.controller;

import com.example.demo.model.TopicQustion;
import com.example.demo.model.Topics;
import com.example.demo.service.TopicQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TopicQuestionController {
    @Autowired
    TopicQuestionService topicQuestionService;
    @GetMapping("/topicquestion")
    public List<TopicQustion> getAllTopicQuestion(){
        return topicQuestionService.getAllTopicQuestion();
    }
    @GetMapping("/id")
    public Optional<TopicQustion> getAllTopicQuestionsById(@RequestParam long id){
        return topicQuestionService.getTopicQuestionById(id);
    }
    @PostMapping("/topicquestion")
    public String addTopicQuestion(@RequestBody TopicQustion topicQustion){
        topicQuestionService.addTopicQuestion(topicQustion);
        return "Added Successfully";
    }
    @PutMapping("/update")
    public String updateTopicQuestion(@RequestBody TopicQustion topicQustion){
        topicQuestionService.updateTopicQuestion(topicQustion);
        return "Updated Successfully";
    }
    @DeleteMapping("/delete")
    public String deleteTopicQuestion(@RequestParam long id){
        topicQuestionService.deleteTopicQuestion(id);
        return "Deleted Successfully";
    }
}
