package com.example.demo.rest.entitymapper;

import com.example.demo.entity.Candidate;
import com.example.demo.rest.dto.CandidateDto;
import com.example.demo.rest.entitymapper.common.JPAEntityMapper;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring")
public interface CandidateMapper extends JPAEntityMapper<Candidate, CandidateDto> {}
