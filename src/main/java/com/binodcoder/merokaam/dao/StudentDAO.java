package com.binodcoder.merokaam.dao;
import com.binodcoder.merokaam.entity.Student;

import java.util.List;
public interface StudentDAO {
    void save(Student theStudent);

    Student findById(Integer id);

    List<Student> findAll();

    List<Student> findByFirstName(String theFirstName);

    void update(Student theStudent);

    void delete(Integer id);
}
