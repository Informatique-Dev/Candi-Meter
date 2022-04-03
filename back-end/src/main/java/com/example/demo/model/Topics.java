package com.example.demo.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "topics")
public class Topics {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "topic_name")
    private String name;

    @Column(name = "description")
    private String description;

    @ManyToOne
    @JoinColumn(name = "topic_level_id")
    private TopicLevel topicLevel;

    @ManyToOne
    @JoinColumn(name = "position_id")
    private Position position;

    @OneToMany(mappedBy = "topics", orphanRemoval = true)
    private List<TopicQuestion> topicQuestions = new ArrayList<>();

    public List<TopicQuestion> getTopicQuestions() {
        return topicQuestions;
    }

    public void setTopicQuestions(List<TopicQuestion> topicQuestions) {
        this.topicQuestions = topicQuestions;
    }

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public TopicLevel getTopicLevel() {
        return topicLevel;
    }

    public void setTopicLevel(TopicLevel topicLevel) {
        this.topicLevel = topicLevel;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}