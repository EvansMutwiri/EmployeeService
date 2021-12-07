package com.eazybytes.employeeservice.service;

import com.eazybytes.employeeservice.model.Employee;
import com.eazybytes.employeeservice.model.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeDao service;

    @GetMapping("/employees")
    public List<Employee> getAll(){
        return service.getAllEmployees();
    }

    @GetMapping(path ="/employees/{employeeId}")
    public Employee getEmployeeById(@PathVariable int employeeId){
        Employee employee = service.getEmployeeById(employeeId);
        return employee;
    }
}
