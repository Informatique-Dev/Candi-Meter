package com.example.demo.rest.handler;

import com.example.demo.entity.Document;
import com.example.demo.rest.dto.DocumentDto;
import com.example.demo.rest.entitymapper.DocumentMapper;
import com.example.demo.rest.exception.ResourceNotFoundException;
import com.example.demo.service.DocumentService;
import com.example.demo.support.DocumentType;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class DocumentHandler {

    private DocumentService documentService;
    private DocumentMapper documentMapper;

    public DocumentDto uploadDocument(DocumentDto documentDto, DocumentType documentType) {
        Document document = documentMapper.toEntity(documentDto);
        document.setDocumentType(documentType);
        Document save = documentService.save(document);
        return documentMapper.toDto(save);
    }

    public ResponseEntity<?> getById(Integer id) {
        Document document = documentService.getById(id)
                .orElseThrow(() -> new ResourceNotFoundException(Document.class.getSimpleName(), id));
        DocumentDto documentDto = documentMapper.toDto(document);
        return ResponseEntity.ok(documentDto);
    }

    public ResponseEntity<?> delete(Integer id) {
        Document document = documentService.getById(id).
                orElseThrow(() -> new ResourceNotFoundException(Document.class.getSimpleName(), id));
        documentService.delete(document);
        return ResponseEntity.noContent().build();
    }
}
