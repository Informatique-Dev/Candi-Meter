package com.example.demo.entity;

import com.example.demo.entity.common.JPAEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;

@Data
@Entity
@EqualsAndHashCode(of = "id", callSuper = false)
@ToString(of = "id", callSuper = false)
public class Company extends JPAEntity {

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;
}
