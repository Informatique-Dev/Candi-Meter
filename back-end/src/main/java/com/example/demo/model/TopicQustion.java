package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "TOPIC_QUESTION")
public class TopicQustion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "ID", nullable = false)
    private Long id;

    @Column(name = "DESCRIBTION")
    private String description;

    @Column(name = "answer")
    private String answer;

    public TopicQustion() {
    }

    public TopicQustion(Long id, String description, String answer, String hint) {
        this.id = id;
        this.description = description;
        this.answer = answer;
        this.hint = hint;
    }

    @Column(name = "hint")
    private String hint;

    public String getHint() {
        return hint;
    }

    public void setHint(String hint) {
        this.hint = hint;
    }

    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
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