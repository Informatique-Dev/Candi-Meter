package com.example.demo.rest.entitymapper;
import com.example.demo.entity.FollowUp;

import com.example.demo.entity.Interview;
import com.example.demo.rest.dto.FollowUpDto;
import com.example.demo.rest.dto.InterviewDto;
import com.example.demo.rest.entitymapper.common.JPAEntityMapper;
import com.example.demo.service.InterviewService;
import com.example.demo.utils.HibernateUtils;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, unmappedTargetPolicy = ReportingPolicy.IGNORE)

public abstract class  FollowUpMapper  {
    @Autowired
    private InterviewMapper interviewMapper;
    @Autowired
    private InterviewService interviewService;


    @Mappings({
            @Mapping(source = "interview", target = "interview", ignore = true)
    })

    public abstract FollowUpDto toDto(FollowUp followUp);

    public abstract List<FollowUpDto> toDto(List<FollowUp> followUps);


    @AfterMapping
    public void toDtoAfterMapping(FollowUp entity, @MappingTarget FollowUpDto dto) {
        if (HibernateUtils.isConvertible(entity.getInterview())) {
            dto.setInterview(interviewMapper.toDto(entity.getInterview()));
        }


    }
    @InheritInverseConfiguration
    public abstract FollowUp toEntity(FollowUpDto followUpDto);

    public abstract List<FollowUp> toEntity(List<FollowUpDto> list);
    @AfterMapping
    public void toEntityAfterMapping(FollowUpDto dto, @MappingTarget FollowUp entity) {
        if (dto.getInterview() != null) {
            entity.setInterview(interviewService.getById(dto.getInterview().getId()).get());
        }


    }
    @InheritInverseConfiguration
    public abstract FollowUp updateEntityFromDto(FollowUpDto dto, @MappingTarget FollowUp entity);





}