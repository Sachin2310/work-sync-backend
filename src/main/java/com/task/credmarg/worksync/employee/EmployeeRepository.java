package com.task.credmarg.worksync.employee;

import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeDetails, Integer> {
    List<EmployeeDetails> findByUserEmail(String userEmail);

    Optional<EmployeeDetails> findByIdAndUserEmail(int id, String userEmail);
}
