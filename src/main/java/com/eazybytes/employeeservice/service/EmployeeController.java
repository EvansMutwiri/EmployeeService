package com.eazybytes.employeeservice.service;

import com.eazybytes.employeeservice.exception_handler.EmployeeNotFound;
import com.eazybytes.employeeservice.model.Employee;
import com.eazybytes.employeeservice.model.EmployeeDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
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
        if(null == employee)
            throw new EmployeeNotFound("Employee Not Found");
        return employee;
    }

    @PostMapping("/employees/new")
    public ResponseEntity<Object> addEmployee(@Valid @RequestBody Employee emp){

        Employee newEmployee = service.addEmployee(emp);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("{employeeId}")
                .buildAndExpand(newEmployee)
                .toUri();
        return ResponseEntity.created(uri).build();
    }

    @DeleteMapping(path = "/employees/delete/{employeeId}")
    public void deleteEmployee(@PathVariable int employeeId){
        Employee employee = service.deleteEmployee(employeeId);

        if(null == employee)
            throw new EmployeeNotFound("Employee Not Found");
    }

}
