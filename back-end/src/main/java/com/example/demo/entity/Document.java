package com.example.demo.entity;

import com.example.demo.entity.common.JPAEntity;
import com.example.demo.support.DocumentType;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.persistence.*;

@Data
@Entity
@EqualsAndHashCode(of = "id", callSuper = false)
@ToString(of = "id", callSuper = false)
public class Document extends JPAEntity {

    @Column
    @Enumerated(EnumType.STRING)
    private DocumentType documentType;

    @Column
    private String documentName;

    @Column
    private String contentType;

    @Column
    private Long size;

    @Column
    private byte[] content;


}