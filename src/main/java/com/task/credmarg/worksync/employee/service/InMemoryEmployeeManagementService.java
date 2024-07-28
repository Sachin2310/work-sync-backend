package com.task.credmarg.worksync.employee.service;

import com.task.credmarg.worksync.employee.EmployeeDetails;
import com.task.credmarg.worksync.employee.controller.EmployeeDTO;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class InMemoryEmployeeManagementService implements EmployeeManagementService{
    Map<Integer, EmployeeDetails> employees = new HashMap<>();
    @Override
    public EmployeeDTO addEmployee(EmployeeDTO employeeDTO) {
        EmployeeDetails employeeDetails = mapEmployeeDtoToEmployeeDetails(employeeDTO);
        employees.put(employeeDetails.getId(),employeeDetails);
        return employeeDTO;
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        return employees.values()
            .stream()
            .map(this::mapEmployeeDetailsToEmployeeDto)
            .toList();
    }

    @Override
    public EmployeeDTO getEmployee(int employeeId) {
        return null;
    }

    @Override
    public EmployeeDTO deleteEmployee(int employeeId) {
        return null;
    }

    private EmployeeDetails mapEmployeeDtoToEmployeeDetails(EmployeeDTO employeeDTO){
        return EmployeeDetails.builder()
            .id(employeeDTO.getId())
            .name(employeeDTO.getName())
            .designation(employeeDTO.getDesignation())
            .CTC(employeeDTO.getCTC())
            .email(employeeDTO.getEmail())
            .build();
    }
    private EmployeeDTO mapEmployeeDetailsToEmployeeDto(EmployeeDetails employeeDetails){
        return new EmployeeDTO(
            employeeDetails.getId(),
            employeeDetails.getName(),
            employeeDetails.getDesignation(),
            employeeDetails.getCTC(),
            employeeDetails.getEmail());
    }
}
