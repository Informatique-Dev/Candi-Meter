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
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.net.URI;
import java.util.Optional;

@Component
@AllArgsConstructor
public class DocumentHandler {

    private DocumentService documentService;
    private DocumentMapper documentMapper;

   /* public DocumentDto uploadDocument(DocumentDto documentDto, DocumentType documentType) {
        Document document = documentMapper.toEntity(documentDto);
        document.setDocumentType(documentType);
        Document save = documentService.save(document);
        return documentMapper.toDto(save);
    }*/

   public ResponseEntity uploadDocument(MultipartFile file)  {
       Document document = new Document();
       document.setDocumentName(file.getOriginalFilename());
       document.setDocumentType(DocumentType.CANDIDATE_CV);
       document.setContentType(file.getContentType());
       document.setSize(file.getSize());

       try {
           document.setContent(file.getBytes());
      } catch (IOException e) {
           throw new RuntimeException(e);
       }

       documentService.save(document);
       return ResponseEntity.created(URI.create("/document/" + document.getId()))
               .body(documentMapper.toDto(document));

   }
    public ResponseEntity<?> downloadDocument(Integer id, HttpServletResponse response){
        Document document = documentService.getById(id).
                orElseThrow(() -> new ResourceNotFoundException(Document.class.getSimpleName(), id));
        response.setContentType("application/octet-stream");

        String headerKey = "Content-Disposition";
        String headerValue = "attachment; filename=" + document.getDocumentName();

        response.setHeader(headerKey,headerValue);

        ServletOutputStream outputStream = null;
        try {
            outputStream = response.getOutputStream();
            outputStream.write(document.getContent());
            outputStream.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return ResponseEntity.ok(documentMapper.toDto(document));
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
