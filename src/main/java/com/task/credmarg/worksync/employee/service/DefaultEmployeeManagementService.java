package com.task.credmarg.worksync.employee.service;

import com.task.credmarg.worksync.employee.EmployeeDetails;
import com.task.credmarg.worksync.employee.EmployeeRepository;
import com.task.credmarg.worksync.employee.controller.EmployeeDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Primary
@RequiredArgsConstructor
public class DefaultEmployeeManagementService implements EmployeeManagementService {
    private final EmployeeRepository employeeRepository;

    @Override
    public EmployeeDTO addEmployee(EmployeeDTO employeeDTO) {
        EmployeeDetails employeeDetails = mapEmployeeDtoToEmployeeDetails(employeeDTO);
        var savedEmployee = employeeRepository.save(employeeDetails);
        employeeDTO.setId(savedEmployee.getId());
        return employeeDTO;
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        return employeeRepository.findAll().stream()
            .map(this::mapEmployeeDetailsToEmployeeDto)
            .toList();
    }

    @Override
    public EmployeeDTO getEmployee(int employeeId) {
        return employeeRepository.findById(employeeId)
            .map(this::mapEmployeeDetailsToEmployeeDto)
            .orElse(null);
    }

    @Override
    public EmployeeDTO deleteEmployee(int employeeId) {
        return null;
    }

    private EmployeeDetails mapEmployeeDtoToEmployeeDetails(EmployeeDTO employeeDTO){
        return EmployeeDetails.builder()
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
