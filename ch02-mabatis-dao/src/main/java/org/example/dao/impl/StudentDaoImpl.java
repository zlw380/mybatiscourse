package org.example.dao.impl;

import org.apache.ibatis.session.SqlSession;
import org.example.dao.StudentDao;
import org.example.domain.Student;
import org.example.utils.MyBatisUtils;

import java.util.List;

public class StudentDaoImpl implements StudentDao {

    @Override
    public List<Student> selectStudents() {
//      get SqlSession object
        //在实现类里创建SqlSession对象时还没有说明要调用的是哪个接口内的方法
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        //在sqlId里说明了要调用StudentDao接口中的selectStudents方法
        String sqlId="org.example.dao.StudentDao.selectStudents";
        List<Student> students = sqlSession.selectList(sqlId);
        /*for(Student stu:students){
            System.out.println(stu);
        }*/
        sqlSession.close();
        return students;
    }

    @Override
    public int insertStudent(Student student) {
        SqlSession sqlSession = MyBatisUtils.getSqlSession();
        String sqlId = "org.example.dao.StudentDao.insertStudent";
        int insertstudent = sqlSession.insert(sqlId,student);
        sqlSession.commit();
        sqlSession.close();
        return insertstudent;
    }


}
