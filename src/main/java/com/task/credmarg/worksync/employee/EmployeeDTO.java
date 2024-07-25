package com.task.credmarg.worksync.employee;

import org.springframework.util.StringUtils;

import java.util.Objects;
import java.util.UUID;

public record EmployeeDTO (String id, String name, String designation, Number CTC, String email){
    public EmployeeDTO{
        Objects.requireNonNull(name, "Name should not be null");
        if(!StringUtils.hasText(id)){
            id = UUID.randomUUID().toString();
        }
        if(!StringUtils.hasText(name)){
            throw new IllegalArgumentException("Name cannot be blank");
        }
    }
}
