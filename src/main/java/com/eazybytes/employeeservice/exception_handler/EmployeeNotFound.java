package com.eazybytes.employeeservice.exception_handler;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class EmployeeNotFound extends RuntimeException {
    public EmployeeNotFound(String employee_not_found) {
        super(employee_not_found);
    }
}
