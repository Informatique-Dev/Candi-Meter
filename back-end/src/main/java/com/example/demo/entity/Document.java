package com.example.demo.entity;

import com.example.demo.entity.common.JPAEntity;
import com.example.demo.support.DocumentType;
import lombok.Data;

import javax.persistence.*;

@Data
@Entity
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