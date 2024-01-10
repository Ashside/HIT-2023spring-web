package cn.edu.hit.dao;

import cn.edu.hit.entity.Student;

import java.util.List;

public interface StudentDao {
    void add(Student student);
    void modify(Student student);
    void remove(String sid);
    String getBySid(String sid);
    List<Student> getAll(String sql);

}
