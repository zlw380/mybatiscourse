package org.example.dao;


import org.example.domain.Student;

import java.util.List;

public interface StudentDao {

    List<Student> selectStudentIf(Student student);

    List<Student> selectStudentWhere(Student student);

    List<Student> selectForEachOne(List<Integer> idlist);

    List<Student> selectForEachTwo(List<Student> stulist);

    List<Student> selectAll();

}
