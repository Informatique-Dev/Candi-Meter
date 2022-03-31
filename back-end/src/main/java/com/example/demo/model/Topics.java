package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "topics")
public class Topics {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "topic_name")
    private String name;

    @Column(name = "describtion")
    private String describtion;

    @ManyToOne
    @JoinColumn(name = "topic_question_id")
    private TopicQuestion topicQuestion;

    public TopicQuestion getTopicQuestion() {
        return topicQuestion;
    }

    public void setTopicQuestion(TopicQuestion topicQuestion) {
        this.topicQuestion = topicQuestion;
    }

    public String getDescribtion() {
        return describtion;
    }

    public void setDescribtion(String describtion) {
        this.describtion = describtion;
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