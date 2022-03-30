package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "TOPICS")
public class Topics {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    private Long id;

    public Topics() {
    }

    public Topics(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    @Column(name = "DESCRIBTION")
    private String description;

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