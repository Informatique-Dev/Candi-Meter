package com.example.demo.entity;

import com.example.demo.entity.common.JPAEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@Entity
@EqualsAndHashCode(of = "id", callSuper = false)
@ToString(of = "id", callSuper = false)
public class Accept extends JPAEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "VACANCY_ID")
    private Vacancy vacancy;

    /*
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "INTERVIEW_ID")
    private Interview interview;
    */

}
