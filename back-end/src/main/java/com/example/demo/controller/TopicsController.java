package com.example.demo.controller;

import com.example.demo.model.Topics;
import com.example.demo.service.TopicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TopicsController {
    @Autowired
    TopicsService topicsService;
    @GetMapping("/topics")
    public List<Topics> getAllTopics(){
        return topicsService.getAllTopics();
    }
    @GetMapping("/id")
    public Topics getAllTopicsById(@RequestParam long id){
        return topicsService.getAllTopicsById(id);
    }
    @PostMapping("/topics")
    public String addTopics(@RequestBody Topics topics){
        topicsService.addTopics(topics);
        return "Added Successfully";
    }
    @PutMapping("/update")
    public String updateTopics(@RequestBody Topics topics){
        topicsService.updateTopics(topics);
        return "Updated Successfully";
    }
    @DeleteMapping("/delete")
    public String deleteTopics(@RequestParam long id){
        topicsService.deleteTopics(id);
        return "Deleted Successfully";
    }
}
