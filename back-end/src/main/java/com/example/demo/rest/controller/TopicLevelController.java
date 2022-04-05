package com.example.demo.rest.controller;

import com.example.demo.model.TopicLevel;
import com.example.demo.rest.dto.TopicLevelDto;
import com.example.demo.rest.mapper.TopicLevelMapper;
import com.example.demo.service.TopicLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topiclevel")
public class TopicLevelController {
    @Autowired
    TopicLevelService topicLevelService;
    TopicLevelMapper topicLevelMapper;
    @GetMapping("/topiclevel")
    public List<TopicLevelDto> getAllTopicLevel(){

        return topicLevelMapper.toDto(topicLevelService.getAllTopicLevel());
    }
    @GetMapping("/id")
    public TopicLevelDto getTopicLevelById(@RequestParam long id){

        return topicLevelMapper.toDto(topicLevelService.getTopicLevelById(id));
    }
    @PostMapping("/topiclevel")
    public String addTopicLevel(@RequestBody TopicLevelDto topicLevelDto){
        TopicLevel topicLevel=topicLevelMapper.toEntity(topicLevelDto);
        topicLevelService.addTopicLevel(topicLevel);
        return "Saved Successfully";
    }
    @PutMapping("/topiclevel")
    public String updateTopicLevel(@RequestBody TopicLevelDto topicLevelDto){
        TopicLevel topicLevel=topicLevelMapper.toEntity(topicLevelDto);
        topicLevelService.updateTopicLevel(topicLevel);
        return "Updated Successfully";
    }
    @DeleteMapping("/delete")
    public String deleteTopicLevel(@RequestParam long id){
        topicLevelService.deleteTopicLevel(id);
        return "deleted Successfully";
    }
}
