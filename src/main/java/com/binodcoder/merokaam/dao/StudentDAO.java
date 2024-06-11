package com.binodcoder.merokaam.dao;
import com.binodcoder.merokaam.entity.Student;
public interface StudentDAO {
    void save(Student theStudent);

    Student findById(Integer id);
}
