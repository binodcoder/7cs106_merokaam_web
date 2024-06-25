package com.binodcoder.merokaam.dao;

import com.binodcoder.merokaam.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    //that's it .. no need to write any code LOL!

    //add a method to sort by last nme
    public List<Employee> findAllByOrderByLastNameAsc();
}
