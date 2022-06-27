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
@Table(name = "topic_rate")
public class TopicRate extends JPAEntity {
    @Column(name = "rate")
    private String rate;

    @ManyToOne
    @JoinColumn(name = "topics_id")
    private Topics topics;


}