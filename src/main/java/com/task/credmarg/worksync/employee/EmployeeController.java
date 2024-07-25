package com.task.credmarg.worksync.employee;

import com.task.credmarg.worksync.employee.models.EmployeeDetails;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/employee")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeManagementService employeeManagementService;
    //add controller advice

    @PostMapping
    ResponseEntity<EmployeeDTO> createEmployee(@RequestBody EmployeeDTO employeeDTO){
        return ResponseEntity.ok(employeeManagementService.addEmployee(employeeDTO));
    }
    @GetMapping
    ResponseEntity<List<EmployeeDTO>> getAllEmployees(){
        return ResponseEntity.ok(employeeManagementService.getAllEmployees());
    }
}
