package edu.tju.goliath.dao;

import java.util.List;

import edu.tju.goliath.entity.Teacher;

public interface TeacherMapper {
    int deleteByPrimaryKey(Integer teacherid);

    int insert(Teacher record);

    int insertSelective(Teacher record);

    Teacher selectByPrimaryKey(Integer teacherid);
    
    Teacher selectByTeacherName(String teachername);
    
    Teacher selectByTeacherEmail(String teacheremail);

    int updateByPrimaryKeySelective(Teacher record);

    int updateByPrimaryKey(Teacher record);
    
    List<Teacher> getAllTeacher();
}