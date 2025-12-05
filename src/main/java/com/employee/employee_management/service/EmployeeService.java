package com.employee.employee_management.service;

import java.util.List;

import com.employee.employee_management.model.Employee;

public interface EmployeeService {

    Employee create(Employee employee);
    Employee update(Long id, Employee employee);
    Employee getById(Long id);
    List<Employee> getAll();
    void delete(Long id);
}
