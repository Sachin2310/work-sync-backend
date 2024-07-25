package com.task.credmarg.worksync.employee;

import com.task.credmarg.worksync.employee.models.EmployeeDetails;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class DefaultEmployeeManagementService implements EmployeeManagementService{
    Map<String, EmployeeDetails> employees = new HashMap<>();
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
    public EmployeeDTO getEmployee(String employeeId) {
        return null;
    }

    @Override
    public EmployeeDTO deleteEmployee(String employeeId) {
        return null;
    }

    private EmployeeDetails mapEmployeeDtoToEmployeeDetails(EmployeeDTO employeeDTO){
        return EmployeeDetails.builder()
            .id(employeeDTO.id())
            .name(employeeDTO.name())
            .designation(employeeDTO.designation())
            .CTC(employeeDTO.CTC())
            .email(employeeDTO.email())
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
