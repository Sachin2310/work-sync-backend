package com.task.credmarg.worksync.employee;


import com.task.credmarg.worksync.employee.controller.EmployeeDTO;

import java.util.List;

public interface EmployeeManagementService {
    EmployeeDTO addEmployee(EmployeeDTO employeeDTO);
    List<EmployeeDTO> getAllEmployees();
    EmployeeDTO getEmployee(int employeeId);
    EmployeeDTO deleteEmployee(int employeeId);

    //update details
}
