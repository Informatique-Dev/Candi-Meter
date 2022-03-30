package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "TOPIC_LEVEL")
public class TopicLevel {
    public TopicLevel() {
    }

    public TopicLevel(Long id, String description, Position position) {
        this.id = id;
        this.description = description;
        this.position = position;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "DESCRIBTION")
    private String description;

    @ManyToOne
    @JoinColumn(name = "position_id")
    private Position position;

    public Position getPosition() {
        return position;
    }

    public void setPosition(Position position) {
        this.position = position;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}