package com.example.demo3.dao;

import com.example.demo3.entity.Student;

import java.util.List;

public interface StudentDao {
    void add(Student student);
    void modify(Student student);
    void remove(String sid);
    Student getBySid(String sid);
    List<Student> getAll(String sql);

}
