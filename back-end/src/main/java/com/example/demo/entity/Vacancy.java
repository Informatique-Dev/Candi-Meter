package com.example.demo.entity;

import com.example.demo.entity.common.JPAEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@EqualsAndHashCode(of = "id", callSuper = false)
@ToString(of = "id", callSuper = false)
public class Vacancy extends JPAEntity {

    @Column(name = "vacancies")
    private Integer vacancies;

    @Column(name = "post_by", updatable = false)
    @CreatedBy
    private String postBy;

    @Column(name = "post_date", updatable = false)
    @CreatedDate
    private LocalDateTime postDate;

    @Column(name = "expire_date", updatable = false)
    private LocalDateTime expireDate;

    /*
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "POSITION_ID")
    private Position position;
    */

}