package edu.tju.goliath.service;

import edu.tju.goliath.entity.Student;

public interface StudentServiceI {
	
	int deleteStuById(Integer stuid);

    int addStu(Student record);

    int addStuSelective(Student record);

    Student getStuById(Integer stuid);

    int updateStuByIdSelective(Student record);

    int updateStuById(Student record);
    
    Student getStuByName(String stuname);
    
    Student getStuByEmail(String stuemail);

}
