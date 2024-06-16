package com.binodcoder.merokaam.dao;
import com.binodcoder.merokaam.entity.StudentEntity;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public class StudentDAOImpl implements StudentDAO{
    //define field for entity manager
    private EntityManager entityManager;

    //inject entity manager using constructor injection
    @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    //implement save method
    @Override
    @Transactional
    public void save(StudentEntity theStudent) {
        entityManager.persist(theStudent);
    }
    @Override
    public StudentEntity findById(Integer id) {
        return entityManager.find(StudentEntity.class, id);
    }
    @Override
    public List<StudentEntity> findAll() {
        //create query
        TypedQuery<StudentEntity> theQuery=entityManager.createQuery("FROM Student", StudentEntity.class);

        //return query results
        return theQuery.getResultList();
    }
    @Override
    public List<StudentEntity> findByFirstName(String theFirstName) {
        //create query
        TypedQuery<StudentEntity> theQuery=entityManager.createQuery("FROM Student WHERE firstName=:theData", StudentEntity.class);

        //set query parameters
        theQuery.setParameter("theData", theFirstName);

        //return query results
        return theQuery.getResultList();
    }
    @Override
    @Transactional
    public void update(StudentEntity theStudent) {
        entityManager.merge(theStudent);

    }
    @Override
    @Transactional
    public void delete(Integer id) {
        //retrieve the student
        StudentEntity theStudent=entityManager.find(StudentEntity.class, id);

        //delete the student
        entityManager.remove(theStudent);

    }
    @Override
    @Transactional
    public int deleteAll() {
        int numRowsDeleted=entityManager.createQuery("DELETE FROM Student").executeUpdate();
        return numRowsDeleted;
    }
}
