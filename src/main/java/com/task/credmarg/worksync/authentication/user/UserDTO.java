package com.task.credmarg.worksync.authentication.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record UserDTO(
        @NotBlank(message = "Name cannot be blank") String userName,
        @NotBlank @Email(message = "Email cannot be blank") String email,
        @NotBlank(message = "Password cannot be blank") String password) {}
