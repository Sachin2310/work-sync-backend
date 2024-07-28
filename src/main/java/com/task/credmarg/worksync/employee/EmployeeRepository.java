package com.task.credmarg.worksync.employee;

import com.task.credmarg.worksync.employee.models.EmployeeDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeDetails, Integer> {
}
