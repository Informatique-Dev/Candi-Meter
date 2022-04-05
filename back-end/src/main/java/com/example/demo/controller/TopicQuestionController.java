package com.example.demo.controller;

import com.example.demo.model.TopicQuestion;
import com.example.demo.model.Topics;
import com.example.demo.service.TopicQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/topicquestion")
public class TopicQuestionController {
    @Autowired
    TopicQuestionService topicQuestionService;
    @GetMapping("/topicquestion")
    public List<TopicQuestion> getAllTopicQuestion(){
        return topicQuestionService.getAllTopicQuestion();
    }
    @GetMapping("/id")
    public Optional<TopicQuestion> getAllTopicQuestionsById(@RequestParam long id){
        return Optional.ofNullable(topicQuestionService.getTopicQuestionById(id));
    }
    @PostMapping("/topicquestion")
    public String addTopicQuestion(@RequestBody TopicQuestion topicQuestion){
        topicQuestionService.addTopicQuestion(topicQuestion);
        return "Added Successfully";
    }
    @PutMapping("/update")
    public String updateTopicQuestion(@RequestBody TopicQuestion topicQuestion){
        topicQuestionService.updateTopicQuestion(topicQuestion);
        return "Updated Successfully";
    }
    @DeleteMapping("/delete")
    public String deleteTopicQuestion(@RequestParam long id){
        topicQuestionService.deleteTopicQuestion(id);
        return "Deleted Successfully";
    }
}
