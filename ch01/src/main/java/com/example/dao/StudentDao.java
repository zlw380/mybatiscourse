package com.example.dao;


import com.example.domain.Student;

import java.util.List;

public interface StudentDao {

//查询表所有数据
    public List<Student> selectStudents();

    public int insertStudent(Student student);

}
