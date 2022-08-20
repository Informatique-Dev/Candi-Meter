package com.example.demo.rest.dto;

import com.example.demo.rest.dto.common.RestDto;
import lombok.Data;

@Data
public class UserDto extends RestDto {

    private String username;
    private String password;
}
