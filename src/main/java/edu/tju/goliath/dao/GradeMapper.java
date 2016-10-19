package edu.tju.goliath.dao;

import java.util.List;
import java.util.Map;

import edu.tju.goliath.entity.Grade;

public interface GradeMapper {
    int deleteByPrimaryKey(Integer gradeid);

    int insert(Grade record);

    int insertSelective(Grade record);

    Grade selectByPrimaryKey(Integer gradeid);

    int updateByPrimaryKeySelective(Grade record);

    int updateByPrimaryKey(Grade record);
	
	List<Grade> getGradesByStuid(Integer stuid);

	Grade getGradeByName(String gradename);
	
	List<Grade> getGradesByStuidAndRankAndModel(Map param);
	
	List<Grade> getAllGrades();
}