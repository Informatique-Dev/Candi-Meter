package com.example.demo.dto;

import com.example.demo.model.Topics;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

public class TopicQuestionDto {
    private Long id;
    private String description;
    private String answer;
   // private Topics topics;


}
