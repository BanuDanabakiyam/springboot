package com.springboot.curddemo.dao;

import com.springboot.curddemo.entity.Student;
import jakarta.persistence.EntityManager;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

// DAO IMPLEMENTATION
@Repository

public class StudentDAOImpl implements StudentDAO {
//    define field for entity manager


//    inject entity manager using constructor injection
    private EntityManager entityManager;
   @Autowired
    public StudentDAOImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

//    implement save method
    @Override
    @Transactional
    public void save(Student theStudent) {
      entityManager.persist(theStudent);
    }

    @Override
    public Student findById(Integer id) {
        return entityManager.find(Student.class, id);
//        entityclass,primarykey
    }

    @Override
    public List<Student> findAll() {
//       create query
        TypedQuery<Student> theQuery = entityManager.createQuery("FROM Student order by lastName desc",Student.class);
//        return query results
        return theQuery.getResultList();
    }

    @Override
    public List<Student> findByLastName(String theLastName) {
//       create query
        TypedQuery<Student> theQuery = entityManager.createQuery(
                "FROM Student WHERE lastName=:theData",Student.class);

//        set query
        theQuery.setParameter("theData", theLastName);
        return theQuery.getResultList();
    }

    @Override
    @Transactional
    public void update(Student theStudent) {
       entityManager.merge(theStudent);

    }

    @Override
    @Transactional
    public void delete(Integer id) {
       Student theStudent = entityManager.find(Student.class, id);
       entityManager.remove(theStudent);

    }

    @Override
    @Transactional
    public int deleteAll() {
       int numRowsDeleted = entityManager.createQuery("DELETE FROM Student").executeUpdate();

        return numRowsDeleted;
    }


}
