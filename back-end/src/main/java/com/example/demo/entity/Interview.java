package com.example.demo.entity;

import com.example.demo.entity.common.JPAEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;
import java.util.LinkedHashSet;
import java.util.Set;

@Data
@Entity
@EqualsAndHashCode(of = "id", callSuper = false)
@ToString(of = "id", callSuper = false)
@Table(name = "interview")
public class Interview extends JPAEntity {
    @Column(name = "date")
    private Date date;

    @Column(name = "evaluation")
    private String evaluation;

    @Column
    private Boolean status;

    @ManyToMany
    @JoinTable(name = "interview_topicses",
            joinColumns = @JoinColumn(name = "interview_id"),
            inverseJoinColumns = @JoinColumn(name = "topicses_id"))
    private Set<Topics> topicses = new LinkedHashSet<>();

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

    @ManyToMany
    @JoinTable(name = "interview_applications",
            joinColumns = @JoinColumn(name = "interview_id"),
            inverseJoinColumns = @JoinColumn(name = "applications_id"))
    private Set<Application> applications = new LinkedHashSet<>();


}