package com.example.demo.entity;

import com.example.demo.entity.common.JPAEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
@EqualsAndHashCode(of = "id", callSuper = false)
@ToString(of = "id", callSuper = false)
@Table(name = "topic_question")
public class TopicQuestion extends JPAEntity {
    @Column(name = "description")
    private String description;

    @Column(name = "answer")
    private String answer;

    @Column(name = "hint")
    private String hint;

    @ManyToOne
    @JoinColumn(name = "topics_id")
    private Topics topics;


}