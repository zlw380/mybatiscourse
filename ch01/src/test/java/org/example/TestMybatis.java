package org.example;

import com.example.domain.Student;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMybatis {

    @Test
    public void testInsert() throws IOException {

        /*定义mybatis主配置文件名称*/
        String config = "mybatis.xml";

        InputStream in = Resources.getResourceAsStream(config);

        SqlSessionFactoryBuilder builder = new SqlSessionFactoryBuilder();

        SqlSessionFactory factory = builder.build(in);

        SqlSession sqlSession = factory.openSession();

        String sqlId = "com.example.dao.StudentDao"+"."+"insertStudent";

        Student student = new Student();

        student.setId(1004);
        student.setAge(20);
        student.setName("lisi1");
        student.setEmail("123@13.com");

        int nums =  sqlSession.insert(sqlId,student);

//      insert update delete后需要手动提交事务
        sqlSession.commit();

        System.out.println("执行insert结果:"+nums);

        sqlSession.close();

    }

}
