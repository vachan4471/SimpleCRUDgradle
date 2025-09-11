package com.example.dto.request;

import io.micronaut.core.annotation.Introspected;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter

@Introspected
public class LoginRequestDto {

    @NotBlank(message = "Username is Required")
    private String username;

    @NotBlank(message = "Password is required")
    private String password;
}
