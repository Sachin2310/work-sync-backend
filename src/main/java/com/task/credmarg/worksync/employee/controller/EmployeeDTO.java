package com.task.credmarg.worksync.employee.controller;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class EmployeeDTO {
    private int id;

    @NotBlank
    private String name;

    private String designation;
    private Long CTC;
    private String email;
}
