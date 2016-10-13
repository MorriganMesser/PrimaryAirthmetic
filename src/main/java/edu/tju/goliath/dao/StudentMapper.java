package edu.tju.goliath.dao;

import edu.tju.goliath.entity.Student;

public interface StudentMapper {
	 int deleteByPrimaryKey(Integer stuid);

	    int insert(Student record);

	    int insertSelective(Student record);

	    Student selectByPrimaryKey(Integer stuid);
	    
	    Student selectByStuName(String stuname);
	    
	    Student selectByStuEmail(String stuemail);

	    int updateByPrimaryKeySelective(Student record);

	    int updateByPrimaryKey(Student record);
}