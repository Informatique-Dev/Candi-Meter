package com.example.demo.controller;

import com.example.demo.dto.PositionDto;
import com.example.demo.mapper.PositionMapper;
import com.example.demo.model.Position;
import com.example.demo.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PositionController {
    @Autowired
    PositionService positionService;
    PositionMapper positionMapper;
    @GetMapping("/position")
    public List<PositionDto> getAllPosition(){

        return positionMapper.mapToDto(positionService.getAllPosition());
    }
    @GetMapping("/id")
    public PositionDto getPositionById(@RequestParam long id){

        return positionMapper.mapToDto(positionService.getPositionById(id));
    }
    @PostMapping("/position")
    public String addPosition(@RequestBody PositionDto positionDto){
        Position position=positionMapper.mapToEntity(positionDto);
        positionService.addPosition(position);
        return "Saved successfully";
    }
    @PutMapping("/update")
    public String updatePosition(@RequestBody PositionDto positionDto){
        Position position=positionMapper.mapToEntity(positionDto);
        positionService.updatePosition(position);
        return "Updated successfully";
    }
    @DeleteMapping("/delete")
    public String deletePositionById(@RequestParam long id){
        positionService.deletePositionById(id);
        return "Deleted Successfully ";
    }
}
