package com.example.demo.dto;

import com.example.demo.model.TopicLevel;

import javax.persistence.Column;

public class TopicLevelDto {
    private Long topicLevelId;
    private String topicLevelDescribtion;
    private PositionDto position;
    private Long positionId;


    public Long getTopicLevelId() {
        return topicLevelId;
    }

    public void setTopicLevelId(Long topicLevelId) {
        this.topicLevelId = topicLevelId;
    }

    public String getTopicLevelDescribtion() {
        return topicLevelDescribtion;
    }

    public void setTopicLevelDescribtion(String topicLevelDescribtion) {
        this.topicLevelDescribtion = topicLevelDescribtion;
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
}
