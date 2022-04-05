package com.example.demo.controller;

import com.example.demo.dto.TopicQuestionDto;
import com.example.demo.mapper.TopicQuestionMapper;
import com.example.demo.model.TopicQuestion;
import com.example.demo.service.TopicQuestionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicquestion")
public class TopicQuestionController {
    @Autowired
    TopicQuestionService topicQuestionService;
    TopicQuestionMapper topicQuestionMapper;
    @GetMapping("/topicquestion")
    public List<TopicQuestionDto> getAllTopicQuestion(){
        return topicQuestionMapper.mapToDto(topicQuestionService.getAllTopicQuestion());
    }
    @GetMapping("/id")
    public TopicQuestionDto getAllTopicQuestionsById(@RequestParam long id){
        return (topicQuestionMapper.mapToDto(topicQuestionService.getTopicQuestionById(id)));
    }
    @PostMapping("/topicquestion")
    public String addTopicQuestion(@RequestBody TopicQuestionDto topicQuestionDto){
        TopicQuestion topicQuestion=topicQuestionMapper.mapToEntity(topicQuestionDto);
        topicQuestionService.addTopicQuestion(topicQuestion);
        return "Added Successfully";
    }
    @PutMapping("/update")
    public String updateTopicQuestion(@RequestBody TopicQuestionDto topicQuestionDto){
        TopicQuestion topicQuestion=topicQuestionMapper.mapToEntity(topicQuestionDto);
        topicQuestionService.updateTopicQuestion(topicQuestion);
        return "Updated Successfully";
    }
    @DeleteMapping("/delete")
    public String deleteTopicQuestion(@RequestParam long id){
        topicQuestionService.deleteTopicQuestion(id);
        return "Deleted Successfully";
    }
}
