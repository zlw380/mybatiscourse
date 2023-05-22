package org.example;

import com.github.pagehelper.PageHelper;
import org.apache.ibatis.session.SqlSession;
import org.example.dao.StudentDao;
import org.example.domain.Student;
import org.example.utils.MyBatisUtils;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestMybatis {

    @Test
    public void selectStudentIf(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student = new Student();
        student.setName("zhangfei");
        student.setAge(12);
        List<Student> students = dao.selectStudentIf(student);
        for (Student stu:students
             ) {
            System.out.println(stu);
        }
        sqlSession.close();
    }

    @Test
    public void selectStudentWhere(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student = new Student();
        student.setName("zhangfei");
        student.setAge(12);
        List<Student> students = dao.selectStudentWhere(student);
        for (Student stu:students
        ) {
            System.out.println(stu);
        }
        sqlSession.close();
    }

    @Test
    public void selectStudentWhere01(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student = new Student();

//        student.setAge(12);
        List<Student> students = dao.selectStudentWhere(student);
        for (Student stu:students
        ) {
            System.out.println(stu);
        }
        sqlSession.close();
    }

    @Test
    public void testfor(){
        List<Integer> list = new ArrayList<>();
        list.add(1001);
//        list.add(1002);
//        list.add(1003);
        System.out.println(list);
        System.out.println(list.size());

        String sql = "select * from student where id in";

        StringBuilder builder = new StringBuilder();
        int init = 0;
        int len = list.size();

        builder.append("(");
        System.out.println(builder.length());
        for (Integer i:list){
            builder.append(i).append(",");
        }
        builder.append(")");
        System.out.println(builder.toString());
        System.out.println(builder.length());
        builder.deleteCharAt(builder.length()-2);
        sql = sql + builder.toString();
        System.out.println("sql=="+sql);

    }

    @Test
    public void selectStudentForEach(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        List<Integer> myid = new ArrayList<>();
        myid.add(1001);
        myid.add(1002);
        myid.add(1006);

        List<Student> students = dao.selectForEachOne(myid);

        for (Student stu:students
             ) {
            System.out.println(stu);
        }
        sqlSession.close();
    }

    @Test
    public void testSelectForEachTwo(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        List<Student> stulist = new ArrayList<>();
        Student s1 = new Student();
        s1.setId(1001);
        Student s2 = new Student();
        s2.setId(1006);
        stulist.add(s1);
        stulist.add(s2);

        List<Student> students = dao.selectForEachTwo(stulist);

        for (Student stu:students
             ) {
            System.out.println(stu);
        }
    }

    @Test
    public void selectStudentAll(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        PageHelper.startPage(2,3);

        List<Student> students = dao.selectAll();

        for (Student stu:students
        ) {
            System.out.println(stu);
        }
        sqlSession.close();
    }
}
