package com.task.credmarg.worksync.authentication.user.controller;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UserDTO {
    private int id;

    @NotBlank(message = "UserName cannot be blank")
    private String userName;

    @NotBlank
    @Email(message = "Email cannot be blank")
    private String email;

    @NotBlank(message = "Password cannot be blank")
    private String password;
}
