package com.example.demo.security;

import lombok.Data;

import javax.validation.constraints.NotBlank;

@Data
public class RefreshTokenRequestDto {

    @NotBlank(message = "refresh token is mandatory")
    private String refreshToken;
}
