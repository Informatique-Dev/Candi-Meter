package com.example.demo.rest.dto;


import lombok.Data;

import javax.persistence.Column;
@Data
public class PositionDto {
    private Long id;
    private String name;
    private String describtion;


}
