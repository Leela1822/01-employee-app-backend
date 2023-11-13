package com.saveetha.employeeappdb.employees;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/employee")
public class EmployeeController {
    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping("/")
    public List<Employee> getEmployee(){
        return employeeService.getEmployeeData();
    }

    @PostMapping("/")
    public void postEmployee(@RequestBody Employee employee){
        employeeService.addNewEmployee(employee);
    }

    @DeleteMapping(path={"/{id}"})
    public void deleteEmployee(@PathVariable("id") Long employeeID)
    {
        employeeService.deleteExistingEmployee(employeeID);
        System.out.println(employeeID);
    }
}
