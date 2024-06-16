package com.binodcoder.merokaam.dao;
import com.binodcoder.merokaam.entity.StudentEntity;

import java.util.List;
public interface StudentDAO {
    void save(StudentEntity theStudent);

    StudentEntity findById(Integer id);

    List<StudentEntity> findAll();

    List<StudentEntity> findByFirstName(String theFirstName);

    void update(StudentEntity theStudent);

    void delete(Integer id);

    int deleteAll();
}
