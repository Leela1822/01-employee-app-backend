package com.saveetha.employeeappdb.employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Autowired
    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<Employee> getEmployeeData(){
        return employeeRepository.findAll();
    }

    public void addNewEmployee(Employee employee) {
        Optional<Employee> existingEmployee = employeeRepository.findEmployeeByEmail(employee.getEmployeeEmail());

        if (existingEmployee.isPresent())
        {
            throw new IllegalStateException("Email already used");
        }

        employeeRepository.save(employee);
    }

    public void deleteExistingEmployee(Long employeeID) {
        boolean employeeExists = employeeRepository.existsById(employeeID);

        if (!employeeExists)
        {
            throw new IllegalStateException("Employee with ID " + employeeID + " doesn't exists");
        }

        employeeRepository.deleteById(employeeID);
    }
}
