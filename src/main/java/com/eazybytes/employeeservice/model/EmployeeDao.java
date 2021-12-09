package com.eazybytes.employeeservice.model;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Iterator;
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
        employeeList.add(new Employee(5, "Michael", "george@bluth.com"));
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

    public Employee addEmployee(Employee emp) {
        emp.setEmployeeId(employeeList.size()+1);
        employeeList.add(emp);
        return emp;
    }

    public Employee deleteEmployee(Integer employeeId) {
        Iterator<Employee> iterator = employeeList.iterator();
        while (iterator.hasNext()){
            Employee employee = iterator.next();
            if(employeeId == employee.getEmployeeId()){
                iterator.remove();
                return employee;
            }
        }
        return null;
    }
}
