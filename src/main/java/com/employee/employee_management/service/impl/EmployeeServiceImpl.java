package com.employee.employee_management.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.employee.employee_management.exception.ResourceNotFoundException;
import com.employee.employee_management.model.Employee;
import com.employee.employee_management.repository.EmployeeRepository;
import com.employee.employee_management.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository repo;

    public EmployeeServiceImpl(EmployeeRepository repo) {
        this.repo = repo;
    }

    @Override
    public Employee create(Employee employee) {
        return repo.save(employee);
    }

    @Override
    public Employee update(Long id, Employee employee) {
        Employee existing = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));

        existing.setFirstName(employee.getFirstName());
        existing.setLastName(employee.getLastName());
        existing.setEmail(employee.getEmail());
        existing.setDepartment(employee.getDepartment());
        existing.setSalary(employee.getSalary());

        return repo.save(existing);
    }

    @Override
    public Employee getById(Long id) {
        return repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));
    }

    @Override
    public List<Employee> getAll() {
        return repo.findAll();
    }

    @Override
    public void delete(Long id) {
        Employee existing = repo.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Employee", "id", id));

        repo.delete(existing);
    }
}
