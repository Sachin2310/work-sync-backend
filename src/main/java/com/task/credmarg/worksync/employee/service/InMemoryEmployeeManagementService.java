package com.task.credmarg.worksync.employee.service;

import com.task.credmarg.worksync.employee.EmployeeDetails;
import com.task.credmarg.worksync.employee.EmployeeInformationMapper;
import com.task.credmarg.worksync.employee.controller.EmployeeDTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class InMemoryEmployeeManagementService implements EmployeeManagementService{
    private final EmployeeInformationMapper employeeInformationMapper;
    Map<Integer, EmployeeDetails> employees = new HashMap<>();
    @Override
    public EmployeeDTO addEmployee(EmployeeDTO employeeDTO) {
        EmployeeDetails employeeDetails = employeeInformationMapper.employeeDtoToEmployeeDetails(employeeDTO);
        employees.put(employeeDetails.getId(),employeeDetails);
        return employeeDTO;
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        return employees.values()
            .stream()
            .map(employeeInformationMapper::employeeDetailsToEmployeeDto)
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

}
