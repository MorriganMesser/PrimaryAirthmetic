package edu.tju.goliath.dao;

import edu.tju.goliath.entity.Grade;

public interface GradeMapper {
    int deleteByPrimaryKey(Integer gradeid);

    int insert(Grade record);

    int insertSelective(Grade record);

    Grade selectByPrimaryKey(Integer gradeid);

    int updateByPrimaryKeySelective(Grade record);

    int updateByPrimaryKey(Grade record);
}