package com.example.demo.rest.entitymapper;

import com.example.demo.entity.Vacancy;
import com.example.demo.rest.dto.VacancyDto;
import com.example.demo.rest.entitymapper.common.JPAEntityMapper;
import com.example.demo.service.PositionService;
import com.example.demo.service.UserService;
import com.example.demo.utils.HibernateUtils;
import org.mapstruct.*;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;


@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS, unmappedTargetPolicy = ReportingPolicy.IGNORE)
public abstract class VacancyMapper {


    @Autowired
    private PositionMapper positionMapper;
    @Autowired
    private PositionService positionService;
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;



    @Mappings({
            @Mapping(source = "position", target = "position", ignore = true),
            @Mapping(source = "postBy", target = "postBy", ignore = true),


    })

    public abstract VacancyDto toDto(Vacancy vacancy);

    public abstract List<VacancyDto> toDto(List<Vacancy> vacancies);

    @AfterMapping
    public void toDtoAfterMapping(Vacancy entity, @MappingTarget VacancyDto dto) {
        if (HibernateUtils.isConvertible(entity.getPosition())) {
            dto.setPosition(positionMapper.toDto(entity.getPosition()));
        }
        if (HibernateUtils.isConvertible(entity.getPostBy())) {
            dto.setPostBy(userMapper.toDto(entity.getPostBy()));
        }


    }
    @InheritInverseConfiguration
    public abstract Vacancy toEntity(VacancyDto billDetailsDto);

    public abstract List<Vacancy> toEntity(List<VacancyDto> list);
    @AfterMapping
    public void toEntityAfterMapping(VacancyDto dto, @MappingTarget Vacancy entity) {
        if (dto.getPosition() != null) {
            entity.setPosition(positionService.getById(dto.getPosition().getId()).get());
        }

        if (dto.getPostBy() != null) {
            entity.setPostBy(userService.getById(dto.getPostBy().getId()).get());
        }


    }
    @InheritInverseConfiguration
    public abstract Vacancy updateEntityFromDto(VacancyDto billDetailsDto, @MappingTarget Vacancy billDetails);




}


