package com.example.demo.dto;

import com.example.demo.model.Position;
import com.example.demo.model.TopicLevel;
import com.example.demo.model.TopicQuestion;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

public class TopicsDto {
    private Long id;
    private String name;
    private String description;

   // private TopicLevel topicLevel;
    //private Long topicLevelId;

    private Position position;
    private Long positionId;
    private List<TopicQuestionDto> topicQuestionsDto;
}
