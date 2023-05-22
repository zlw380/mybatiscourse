package org.example;

import org.apache.ibatis.session.SqlSession;
import org.example.dao.StudentDao;
//import org.example.dao.impl.StudentDaoImpl;
import org.example.domain.MyStudent;
import org.example.domain.Student;
import org.example.utils.MyBatisUtils;
import org.example.vo.QueryParam;
import org.example.vo.ViewStudent;
import org.junit.Test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestMybatis {
    @Test
    public void testSelectStudents(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        StudentDao dao = sqlSession.getMapper(StudentDao.class);

//        System.out.println("dao="+dao.getClass().getName());

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

    @Test
    public void testSelectById(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student = dao.selectStudentById(1002);
        System.out.println("查询的学生信息为:"+student);
    }

    @Test
    public void testSelectMultiparam(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> students = dao.selectMultiparam("zhangfei",23);
        for (Student stu: students
             ) {
            System.out.println(stu);
        }
        sqlSession.close();
    }

    @Test
    public void testSelectParam(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        QueryParam param = new QueryParam();
        param.setParamName("zhangfei1");
        param.setParamAge(23);
        List<Student> students = dao.selectMultiObject(param);
        for (Student stu: students
             ) {
            System.out.println(stu);
        }
        sqlSession.close();
    }

    @Test
    public void testSelectMultiStudent(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Student student = new Student();
        student.setName("zhangfei");
        student.setAge(23);
        List<Student> students = dao.selectMultiStudent(student);
        for (Student stu: students
             ) {
            System.out.println(stu);
        }
        sqlSession.close();
    }

    @Test
    public void testSelectMultiPosition(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        List<Student> students = dao.selectMultiPosition("zhangfei",23,"12@12.com");
        for (Student stu: students
        ) {
            System.out.println(stu);
        }
        sqlSession.close();
    }

    @Test
    public void testSelectMultiMap(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        StudentDao dao = sqlSession.getMapper(StudentDao.class);

        Map<String,Object> data = new HashMap<>();
        data.put("myname","zhangfei");
        data.put("age","23");

        List<Student> students = dao.selectMultiMap(data);
        for (Student stu: students
        ) {
            System.out.println(stu);
        }
        sqlSession.close();
    }

    @Test
    public void testSelectUseDollar(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> student = dao.selectUseDollar("'lisi'");
        for (Student stu:student
             ) {
            System.out.println(stu);
        }
        sqlSession.close();
    }

    @Test
    public void testSelectOrder(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> student = dao.selectOrder("age");
        for (Student stu:student
        ) {
            System.out.println(stu);
        }
        sqlSession.close();
    }

    @Test
    public void testSelectView(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<ViewStudent> student = dao.selectView();
        for (ViewStudent stu:student
        ) {
            System.out.println(stu);
        }
        sqlSession.close();
    }

    @Test
    public void testSelectViewById(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        ViewStudent student = dao.selectViewById(1001);

        System.out.println(student);

        sqlSession.close();
    }

    @Test
    public void testSelectCount(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        int num = dao.countStudent();
        System.out.println(num);
        sqlSession.close();
    }

    @Test
    public void testSelectMap(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        Map<Object,Object> map = dao.selectMapById(1001);
        System.out.println(map);
        sqlSession.close();
    }

    @Test
    public void selectMultiListMap(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Map<Object,Object>> maps = dao.selectMultiListMap(1001);
        for (Map<Object,Object> m:maps
             ) {
            System.out.println(m);
        }
        sqlSession.close();
    }

    @Test
    public void selectAllListStudent(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> students = dao.selectAllListStudent();
        for (Student stu:students
        ) {
            System.out.println(stu);
        }
        sqlSession.close();
    }

    @Test
    public void selectMyStudent(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<MyStudent> students = dao.selectMyStudent();
        for (MyStudent stu:students
        ) {
            System.out.println(stu);
        }
        sqlSession.close();
    }

    @Test
    public void selectDiffColProperty(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<MyStudent> students = dao.selectDiffColProperty();
        for (MyStudent stu:students
        ) {
            System.out.println("查询的全部学生信息："+stu);
        }
        sqlSession.close();
    }

    @Test
    public void selectLikeOne(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        List<Student> student = dao.selectLikeOne("李");

        for (Student stu:student
             ) {
            System.out.println(stu);
        }
        sqlSession.close();
    }

    @Test
    public void selectLikeOne01(){
        SqlSession sqlSession = MyBatisUtils.getSqlSession();

        StudentDao dao = sqlSession.getMapper(StudentDao.class);
        String name = "航";
        List<Student> student = dao.selectLikeOne(name);

        for (Student stu:student
        ) {
            System.out.println(stu);
        }
        sqlSession.close();
    }
}
