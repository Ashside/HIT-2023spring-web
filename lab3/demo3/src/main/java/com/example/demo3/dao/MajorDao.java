package com.example.demo3.dao;

import com.example.demo3.entity.Major;

import java.util.List;

public interface MajorDao {
    void add(Major major);
    void modify(Major major);
    void remove(String mid);
    Major getByMid(String mid);
    List<Major> getAll(String sql);
}
