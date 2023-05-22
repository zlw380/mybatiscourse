package org.example;

import org.apache.ibatis.session.SqlSession;
import org.example.dao.StudentDao;
//import org.example.dao.impl.StudentDaoImpl;
import org.example.domain.Student;
import org.example.utils.MyBatisUtils;
import org.junit.Test;

import java.util.List;

public class TestMybatis {
    @Test
    public void testSelectStudents(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        System.out.println(sqlSession.getClass());
        //创建StudentDao接口的实现类对象，以调用接口中的方法
        //只不过该对象是通过动态代理创建的
        //调用SqlSession的getMapper()方法，参数为指定Dao接口的class值
        //先创建SqlSession对象后创建StudentDao对象
        //在这时就已经确定了该代理对象要调用的是StudentDao接口里的方法
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        System.out.println(dao);
//        代理对象
//        System.out.println("dao="+dao.getClass().getName());

        //相当于使用实现类创建接口对象的：List<Student> students = new StudentDaoImpl().selectStudents();
        //实际上都是通过调用SqlSession会话对象的selectList方法查询数据库
        //但动态代理不需要指定调用SqlSession对象的selectList方法
        //只需要指定接口的方法名，代理类内部会自动匹配SqlSession对象要调用的方法
        List<Student> students = dao.selectStudents();
        for(Student stu:students){
            System.out.println(stu);
        }
    }
    @Test
    public void testInsertStudent(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student = new Student();
        student.setId(1008);
        student.setName("zhangfei122");
        student.setEmail("zhang1@hotmail.com");
        student.setAge(23);
        int num = dao.insertStudent(student);
        sqlSession.commit();
        System.out.println("添加的记录条数为"+num);
    }
}
