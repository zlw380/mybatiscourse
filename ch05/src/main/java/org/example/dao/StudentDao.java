package org.example.dao;

import org.apache.ibatis.annotations.Param;
import org.example.domain.MyStudent;
import org.example.domain.Student;
import org.example.vo.QueryParam;
import org.example.vo.ViewStudent;

import java.util.List;
import java.util.Map;

public interface StudentDao {

    List<Student> selectStudents();

    int insertStudent(Student student);

    public Student selectStudentById(Integer id);

    List<Student> selectMultiparam(@Param("myname") String name,
                                   @Param("myage") Integer age);

    List<Student> selectMultiObject(QueryParam param);

    List<Student> selectMultiStudent(Student student);

    List<Student> selectMultiPosition(String name,Integer age,String email);

    List<Student> selectMultiMap(Map<String,Object> map);

    List<Student> selectUseDollar(@Param("myname") String name);

    List<Student> selectOrder(@Param("colName") String colName);

    List<ViewStudent> selectView();

    ViewStudent selectViewById(@Param("id") Integer id);

    int countStudent();

    Map<Object,Object> selectMapById(Integer id);

    List<Map<Object,Object>> selectMultiListMap(Integer id);

    List<Student> selectAllListStudent();

    List<MyStudent> selectMyStudent();

    List<MyStudent> selectDiffColProperty();

    List<Student> selectLikeOne(String name);
}
