package com.saveetha.employeeappdb.employees;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EmployeeRepository
        extends JpaRepository<Employee, Long> {
    @Query("Select employee from Employee where employee.employeeEmail=?1")
    Optional<Employee> findEmployeeByEmail(String employeeEmail);
}
