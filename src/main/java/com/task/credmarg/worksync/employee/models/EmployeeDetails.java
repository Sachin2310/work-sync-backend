package com.task.credmarg.worksync.employee.models;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class EmployeeDetails{
    private String id;
    private String name;
    private String designation;
    private Number CTC;
    private String email;
}
