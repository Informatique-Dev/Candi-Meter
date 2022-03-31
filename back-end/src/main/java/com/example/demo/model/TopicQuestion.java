package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "topic_question")
public class TopicQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "describtion")
    private String describtion;

    public TopicQuestion() {
    }

    public TopicQuestion(Long id, String describtion, String answer, String hint) {
        this.id = id;
        this.describtion = describtion;
        this.answer = answer;
        this.hint = hint;
    }

    @Column(name = "answer")
    private String answer;

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