package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "POSITION")
public class Position {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    private Long id;

    public Position() {
    }

    public Position(Long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    @Column(name = "NAME")
    private String name;

    @Column(name = "DESCRIBTION")
    private String description;

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