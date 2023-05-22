package org.example;

import org.example.dao.StudentDao;
import org.example.dao.impl.StudentDaoImpl;
import org.example.domain.Student;
import org.junit.Test;

import java.util.List;

public class TestMybatis {
    @Test
    public void testSelectStudents(){
        //创建StudentDao的实现类对象后执行其方法时创建SqlSession对象
        StudentDao dao = new StudentDaoImpl();
        List<Student> students = dao.selectStudents();
        for(Student stu:students){
            System.out.println(stu);
        }
    }
    @Test
    public void testInsertStudent(){
        StudentDao dao = new StudentDaoImpl();
        Student student = new Student();
        student.setId(1007);
        student.setName("zhangfei1");
        student.setEmail("zhang1@hotmail.com");
        student.setAge(23);
        int num = dao.insertStudent(student);
        System.out.println("添加的记录条数为"+num);
    }
}
