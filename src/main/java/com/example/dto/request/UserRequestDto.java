package com.example.dto.request;

import io.micronaut.core.annotation.Introspected;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor

@Introspected
public class UserRequestDto {
    @NotBlank(message = "First name is required")
    @Size(max = 100)
    private String firstName;

    @Size(max = 100)
    private String lastName;

    @NotBlank(message = "Email is required")
    @Email(message = "Invalid Email")
    private String email;

    @NotBlank(message = "Username is required")
    @Size(max = 100)
    private String username;

    @NotBlank(message = "Password is required")
    @Pattern(regexp = "^(?=.*[A-Z])(?=.*[0-9])(?=.*[!@#$%^&*+/?>.<,])(?=.*[a-z]).{8,20}$",
    message = "In password at least one uppercase, digit and special character is must")
    private String password;

    @NotBlank(message = "Role is required")
    private String role;
}
