package com.example.demo.rest.controller;


import com.example.demo.model.Topics;
import com.example.demo.rest.dto.TopicsDto;
import com.example.demo.rest.mapper.TopicsMapper;
import com.example.demo.service.TopicsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topics")
public class TopicsController {
    @Autowired
    TopicsService topicsService;
    TopicsMapper topicsMapper;
    @GetMapping("/topics")
    public List<TopicsDto> getAllTopics(){
        return topicsMapper.toDto(topicsService.getAllTopics());
    }
    @GetMapping("/id")
    public TopicsDto getAllTopicsById(@RequestParam long id){
        return topicsMapper.toDto(topicsService.getAllTopicsById(id));
    }
    @PostMapping("/topics")
    public String addTopics(@RequestBody TopicsDto topicsDto){
        Topics topics=topicsMapper.toEntity(topicsDto);
        topicsService.addTopics(topics);
        return "Added Successfully";
    }
    @PutMapping("/update")
    public String updateTopics(@RequestBody TopicsDto topicsDto){
        Topics topics=topicsMapper.toEntity(topicsDto);
        topicsService.updateTopics(topics);
        return "Updated Successfully";
    }
    @DeleteMapping("/delete")
    public String deleteTopics(@RequestParam long id){
        topicsService.deleteTopics(id);
        return "Deleted Successfully";
    }
}
