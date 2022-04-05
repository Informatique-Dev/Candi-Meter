package com.example.demo.controller;

import com.example.demo.dto.TopicLevelDto;
import com.example.demo.mapper.TopicLevelMapper;
import com.example.demo.model.Position;
import com.example.demo.model.TopicLevel;
import com.example.demo.service.TopicLevelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/topiclevel")
public class TopicLevelController {
    @Autowired
    TopicLevelService topicLevelService;
    TopicLevelMapper topicLevelMapper;
    @GetMapping("/topiclevel")
    public List<TopicLevelDto> getAllTopicLevel(){

        return topicLevelMapper.mapToDto(topicLevelService.getAllTopicLevel());
    }
    @GetMapping("/id")
    public TopicLevelDto getTopicLevelById(@RequestParam long id){

        return (topicLevelMapper.mapToDto((topicLevelService.getTopicLevelById(id))));
    }
    @PostMapping("/topiclevel")
    public String addTopicLevel(@RequestBody TopicLevelDto topicLevelDto){
        TopicLevel topicLevel=topicLevelMapper.mapToEntity(topicLevelDto);
        topicLevelService.addTopicLevel(topicLevel);
        return "Saved Successfully";
    }
    @PutMapping("/topiclevel")
    public String updateTopicLevel(@RequestBody TopicLevelDto topicLevelDto){
        TopicLevel topicLevel=topicLevelMapper.mapToEntity(topicLevelDto);
        topicLevelService.updateTopicLevel(topicLevel);
        return "Updated Successfully";
    }
    @DeleteMapping("/delete")
    public String deleteTopicLevel(@RequestParam long id){
        topicLevelService.deleteTopicLevel(id);
        return "deleted Successfully";
    }
}
