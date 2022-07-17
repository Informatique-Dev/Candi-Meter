package com.example.demo.rest.dto;

import com.example.demo.entity.Application;
import com.example.demo.entity.Employee;
import com.example.demo.entity.Topics;
import com.example.demo.rest.dto.common.RestDto;

import java.sql.Date;
import java.util.LinkedHashSet;
import java.util.Set;

public class InterviewDto extends RestDto {
    private Date date;
    private String evaluation;
    private Boolean status;
    private Set<Topics> topicses = new LinkedHashSet<>();
    private Employee employee;
    private Set<Application> applications = new LinkedHashSet<>();
}
