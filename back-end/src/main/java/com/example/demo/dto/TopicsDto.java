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

    private TopicLevelDto topicLevel;
    private Long topicLevelId;
    private PositionDto position;
    private Long positionId;
    private List<TopicQuestionDto> topicQuestions;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public TopicLevelDto getTopicLevel() {
        return topicLevel;
    }

    public void setTopicLevel(TopicLevelDto topicLevel) {
        this.topicLevel = topicLevel;
    }

    public Long getTopicLevelId() {
        return topicLevelId;
    }

    public void setTopicLevelId(Long topicLevelId) {
        this.topicLevelId = topicLevelId;
    }

    public PositionDto getPosition() {
        return position;
    }

    public void setPosition(PositionDto position) {
        this.position = position;
    }

    public Long getPositionId() {
        return positionId;
    }

    public void setPositionId(Long positionId) {
        this.positionId = positionId;
    }

    public List<TopicQuestionDto> getTopicQuestions() {
        return topicQuestions;
    }

    public void setTopicQuestions(List<TopicQuestionDto> topicQuestions) {
        this.topicQuestions = topicQuestions;
    }
}
