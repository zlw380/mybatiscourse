package com.example;

import com.example.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class test {

    public static void main(String[] args) throws IOException {
        /*定义mybatis主配置文件名称*/
        String config = "mybatis.xml";

        InputStream in = Resources.getResourceAsStream(config);

        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

        SqlSessionFactory factory = builder.build(in);

        SqlSession sqlSession = factory.openSession();

        String sqlId = "com.example.dao.StudentDao"+"."+"selectStudents";

        List<Student> studentList =  sqlSession.selectList(sqlId);

        studentList.forEach( stu -> System.out.println(stu));

        sqlSession.close();

    }
}
