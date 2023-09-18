package com.example.demo.rest.entitymapper;

import com.example.demo.entity.Candidate;
import com.example.demo.entity.Document;
import com.example.demo.rest.dto.CandidateDto;
import com.example.demo.rest.dto.DocumentDto;
import org.mapstruct.*;

import java.util.Base64;
import java.util.List;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class DocumentMapper {

//   @Mappings({@Mapping(source = "content", target = "content", ignore = true) })
    public abstract DocumentDto toDto(Document entity);

    public abstract List<DocumentDto> toDto(List<Document> entityList);

    @AfterMapping
    public void toDtoAfterMapping(Document entity, @MappingTarget DocumentDto dto) {
      //  dto.setContent(Base64.getEncoder().withoutPadding().encodeToString(entity.getContent()));
    }

    @InheritInverseConfiguration
    public abstract Document toEntity(DocumentDto dto);

    public abstract List<Document> toEntity(List<DocumentDto> dtoList);


    @AfterMapping
    public void toEntityAfterMapping(DocumentDto dto, @MappingTarget Document entity) {
        //entity.setContent(Base64.getDecoder().decode(dto.getContent()));
    }

    @InheritInverseConfiguration
    public abstract Candidate updateEntityFromDto(CandidateDto dto, @MappingTarget Candidate entity);

}
