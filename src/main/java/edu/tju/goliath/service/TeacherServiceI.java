package edu.tju.goliath.service;

import java.util.List;

import edu.tju.goliath.entity.Teacher;

public interface TeacherServiceI {
	int deleteTeacherById(Integer teacherid);

    int addTeacher(Teacher record);

    int addTeacherSelective(Teacher record);

    Teacher getTeacherById(Integer teacherid);
    Teacher getTeacherByName(String teachername);
    Teacher getTeacherByEmail(String teacheremail);

    int updateTeacherByIdSelective(Teacher record);

    int updateTeacherById(Teacher record);

	List<Teacher> getAllTeacher();

}
