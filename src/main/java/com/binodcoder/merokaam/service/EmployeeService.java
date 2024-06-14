package com.binodcoder.merokaam.service;
import com.binodcoder.merokaam.entity.Employee;

import java.util.List;

public interface EmployeeService {
    List<Employee> findAll();
    Employee findById(int theId);
    Employee save(Employee theEmployee);
    void deleteById(int theId);
}
