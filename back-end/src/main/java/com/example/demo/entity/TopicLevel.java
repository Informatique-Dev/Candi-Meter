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
@Table(name = "topic_level")
public class TopicLevel extends JPAEntity {


    @Column(name = "describtion")
    private String describtion;

    @ManyToOne
    @JoinColumn(name = "position_id")
    private Position position;


}