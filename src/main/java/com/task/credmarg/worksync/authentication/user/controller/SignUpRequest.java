package com.task.credmarg.worksync.authentication.user.controller;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;

public record SignUpRequest(
        @NotBlank(message = "UserName cannot be blank") String name,
        @NotBlank(message = "Email cannot be blank") @Email(message = "Email format not correct") String email,
        @NotBlank(message = "Password cannot be blank") String password) {}
