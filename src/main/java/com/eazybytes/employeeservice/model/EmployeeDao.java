package com.eazybytes.employeeservice.model;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Component
@Service
public class EmployeeDao {
    static List<Employee> employeeList = new ArrayList<>();

    static {
        employeeList.add(new Employee(1, "Evans", "evans@eazybytes.com"));
        employeeList.add(new Employee(2, "Salang", "salang@eazybytes.com"));
        employeeList.add(new Employee(3, "Biggie", "big@eazybytes.com"));
        employeeList.add(new Employee(4, "Eazy", "smalls@eazybytes.com"));
    }

    /**
     *  Get all employee method
     */
    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    public Employee getEmployeeById(int employeeId) {
        return employeeList.stream()
                .filter(employee -> employee.getEmployeeId()==employeeId)
                .findAny()
                .orElse(null);
    }
}
