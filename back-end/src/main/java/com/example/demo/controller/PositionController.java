package com.example.demo.controller;

import com.example.demo.model.Position;
import com.example.demo.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class PositionController {
    @Autowired
    PositionService positionService;
    @GetMapping("/position")
    public List<Position> getAllPosition(){
        return positionService.getAllPosition();
    }
    @GetMapping("/id")
    public Position getPositionById(@RequestParam long id){
        return positionService.getPositionById(id);
    }
    @PostMapping("/position")
    public String addPosition(@RequestBody Position position){
        positionService.addPosition(position);
        return "Saved successfully";
    }
    @PutMapping("/update")
    public String updatePosition(@RequestBody Position position){
        positionService.updatePosition(position);
        return "Updated successfully";
    }
    @DeleteMapping("/delete")
    public String deletePositionById(@RequestParam long id){
        positionService.deletePositionById(id);
        return "Deleted Successfully ";
    }
}
