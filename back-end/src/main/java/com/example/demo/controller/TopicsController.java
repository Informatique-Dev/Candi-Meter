package com.example.demo.controller;

import com.example.demo.dto.TopicsDto;
import com.example.demo.mapper.TopicsMapper;
import com.example.demo.model.Topics;
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
        return topicsMapper.mapToDto(topicsService.getAllTopics());
    }
    @GetMapping("/id")
    public TopicsDto getAllTopicsById(@RequestParam long id){
        return topicsMapper.mapToDto(topicsService.getAllTopicsById(id));
    }
    @PostMapping("/topics")
    public String addTopics(@RequestBody TopicsDto topicsDto){
        Topics topics=topicsMapper.mapToEntity(topicsDto);
        topicsService.addTopics(topics);
        return "Added Successfully";
    }
    @PutMapping("/update")
    public String updateTopics(@RequestBody TopicsDto topicsDto){
        Topics topics=topicsMapper.mapToEntity(topicsDto);
        topicsService.updateTopics(topics);
        return "Updated Successfully";
    }
    @DeleteMapping("/delete")
    public String deleteTopics(@RequestParam long id){
        topicsService.deleteTopics(id);
        return "Deleted Successfully";
    }
}
