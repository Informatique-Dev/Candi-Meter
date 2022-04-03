package com.example.demo.model;

import javax.persistence.*;

@Entity
@Table(name = "topic_question")
public class TopicQuestion {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "description")
    private String description;

    @Column(name = "answer")
    private String answer;

    @ManyToOne
    @JoinColumn(name = "topics_id")
    private Topics topics;

    public TopicQuestion() {
    }

    public TopicQuestion(Long id, String description, String answer, String hint) {
        this.id = id;
        this.description = description;
        this.answer = answer;
        this.hint = hint;
    }

    @Column(name = "hint")
    private String hint;

    public Topics getTopics() {
        return topics;
    }

    public void setTopics(Topics topics) {
        this.topics = topics;
    }

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