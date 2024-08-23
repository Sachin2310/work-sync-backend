package com.task.credmarg.worksync.employee.service;

import com.task.credmarg.worksync.employee.EmployeeInformationMapper;
import com.task.credmarg.worksync.employee.EmployeeRepository;
import com.task.credmarg.worksync.employee.controller.EmployeeDTO;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

@Service
@Primary
@RequiredArgsConstructor
public class DefaultEmployeeManagementService implements EmployeeManagementService {
    private final EmployeeInformationMapper employeeInformationMapper;
    private final EmployeeRepository employeeRepository;

    @Override
    public EmployeeDTO addEmployee(EmployeeDTO employeeDTO) {
        var employeeDetails = employeeInformationMapper.employeeDtoToEmployeeDetails(employeeDTO);
        employeeDetails.setUserEmail(
                SecurityContextHolder.getContext().getAuthentication().getName());
        var savedEmployee = employeeRepository.save(employeeDetails);
        employeeDTO.setId(savedEmployee.getId());
        return employeeDTO;
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        var userEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        return employeeRepository.findByUserEmail(userEmail).stream()
                .map(employeeInformationMapper::employeeDetailsToEmployeeDto)
                .toList();
    }

    @Override
    public EmployeeDTO getEmployee(int employeeId) {
        var userEmail = SecurityContextHolder.getContext().getAuthentication().getName();
        return employeeRepository
                .findByIdAndUserEmail(employeeId, userEmail)
                .map(employeeInformationMapper::employeeDetailsToEmployeeDto)
                .orElse(null);
    }

    @Override
    public EmployeeDTO deleteEmployee(int employeeId) {
        return null;
    }
}
