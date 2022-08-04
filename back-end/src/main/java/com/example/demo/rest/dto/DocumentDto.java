package com.example.demo.rest.dto;

import com.example.demo.rest.dto.common.RestDto;
import com.example.demo.support.DocumentType;
import lombok.Data;

import javax.persistence.Column;

@Data
public class DocumentDto extends RestDto {

    private DocumentType documentType;

    private String documentName;

    private String contentType;

    private Long size;

    private byte[] content;

}
