package edu.tju.goliath.service;

import java.util.List;
import java.util.Map;

import edu.tju.goliath.entity.Grade;

public interface GradeServiceI {
    int deleteGradeById(Integer gradeid);

    int addGrade(Grade record);

    int addGradeSelective(Grade record);

    Grade getGradeById(Integer gradeid);

    int updateGradeByIdSelective(Grade record);

    int updateGradeById(Grade record);
    
    List<Grade> getGradesByStuid(Integer stuid);

	Grade getGradeByName(String gradename);
	
	List<Grade> getGradesByStuidAndRankAndModel(Map param);
	
	List<Grade> getAllGrades();

}
