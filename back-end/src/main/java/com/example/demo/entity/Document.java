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

    @Lob
    private byte[] content;

}