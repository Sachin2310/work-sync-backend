package com.task.credmarg.worksync.employee;


import java.util.List;

public interface EmployeeManagementService {
    EmployeeDTO addEmployee(EmployeeDTO employeeDTO);
    List<EmployeeDTO> getAllEmployees();
    EmployeeDTO getEmployee(String employeeId);
    EmployeeDTO deleteEmployee(String employeeId);

    //update details
}
