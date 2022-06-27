package com.example.demo.model;


import javax.persistence.*;

@Entity
@Table(name = "topic_level")
public class TopicLevel {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "describtion")
    private String describtion;

    public TopicLevel() {
    }

    public TopicLevel(Long id, String describtion, Position position) {
        this.id = id;
        this.describtion = describtion;
        this.position = position;
    }

    @ManyToOne
    @JoinColumn(name = "position_id")
    private Position position;

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getDescribtion() {
        return describtion;
    }

    public void setDescribtion(String describtion) {
        this.describtion = describtion;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}