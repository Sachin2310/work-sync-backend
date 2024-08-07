package com.task.credmarg.worksync.employee;

import com.task.credmarg.worksync.employee.controller.EmployeeDTO;
import org.springframework.stereotype.Service;

@Service
public class EmployeeInformationMapper {
    public EmployeeDetails employeeDtoToEmployeeDetails(EmployeeDTO employeeDTO) {
        return EmployeeDetails.builder()
                .name(employeeDTO.getName())
                .designation(employeeDTO.getDesignation())
                .CTC(employeeDTO.getCTC())
                .email(employeeDTO.getEmail())
                .build();
    }

    public EmployeeDTO employeeDetailsToEmployeeDto(EmployeeDetails employeeDetails) {
        return new EmployeeDTO(
                employeeDetails.getId(),
                employeeDetails.getName(),
                employeeDetails.getDesignation(),
                employeeDetails.getCTC(),
                employeeDetails.getEmail());
    }
}
