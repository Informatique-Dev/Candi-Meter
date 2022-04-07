package com.example.demo.entity;

import com.example.demo.entity.common.JPAEntity;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Data
@Entity
public class Application extends JPAEntity {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OFFICE_ID")
    private Vacancy vacancy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OFFICE_ID")
    private Candidate candidate;

    /*
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OFFICE_ID")
    private Question question;
    */

    /*
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "OFFICE_ID")
    private Document document;
    */
}
