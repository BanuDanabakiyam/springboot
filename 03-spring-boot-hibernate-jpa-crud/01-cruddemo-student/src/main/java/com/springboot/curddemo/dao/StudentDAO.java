package com.springboot.curddemo.dao;

import com.springboot.curddemo.entity.Student;

import java.util.List;

// data access model define

public interface StudentDAO {

    public void save(Student theStudent);

    public  Student findById(Integer id);

    public List<Student> findAll();

    List<Student> findByLastName(String theLastName);

    void update(Student theStudent);
    void delete(Integer id);
    int deleteAll();

}
