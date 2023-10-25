package com.example.demo.rest.dto;
import com.example.demo.rest.dto.common.RestDto;
import lombok.Data;

import java.sql.Date;
import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;
@Data
public class FollowUpDto  extends RestDto {
    private Date date;
    private String description;
    private InterviewDto interview;
}
