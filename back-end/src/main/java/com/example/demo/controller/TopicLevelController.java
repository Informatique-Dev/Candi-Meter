package com.example.demo.controller;

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
    @GetMapping("/topiclevel")
    public List<TopicLevel> getAllTopicLevel(){
        return topicLevelService.getAllTopicLevel();
    }
    @GetMapping("/id")
    public Optional<TopicLevel> getTopicLevelById(@RequestParam long id){
        return topicLevelService.getTopicLevelById(id);
    }
    @PostMapping("/topiclevel")
    public String addTopicLevel(@RequestBody TopicLevel topicLevel){
        topicLevelService.addTopicLevel(topicLevel);
        return "Saved Successfully";
    }
    @PutMapping("/topiclevel")
    public String updateTopicLevel(@RequestBody TopicLevel topicLevel){
        topicLevelService.updateTopicLevel(topicLevel);
        return "Updated Successfully";
    }
    @DeleteMapping("/delete")
    public String deleteTopicLevel(@RequestParam long id){
        topicLevelService.deleteTopicLevel(id);
        return "deleted Successfully";
    }
}
