package com.example.demo.entity;

import com.example.demo.entity.common.JPAEntity;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.Size;

@Data
@Entity
@EqualsAndHashCode(of = "id", callSuper = false)
@ToString(of = "id", callSuper = false)
public class Candidate extends JPAEntity {

    @Column(name = "name")
    private String name;

    @Size(max = 11 , min = 11 ,message = " Should have length 11 numbers ")
    @Column(name = "phone")
    private String phone;

    @Email(message = "Should be in Email format")
    @Column(name = "E_mail")
    private String email;


    @Column
    private Integer documentId;



}
