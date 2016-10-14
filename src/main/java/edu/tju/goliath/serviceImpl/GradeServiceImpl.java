package edu.tju.goliath.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.tju.goliath.dao.GradeMapper;
import edu.tju.goliath.entity.Grade;
import edu.tju.goliath.service.GradeServiceI;

@Service("gradeService")
public class GradeServiceImpl implements GradeServiceI {
	
	private GradeMapper gradeMapper;
	

	public GradeMapper getGradeMapper() {
		return gradeMapper;
	}

	@Autowired
	public void setGradeMapper(GradeMapper gradeMapper) {
		this.gradeMapper = gradeMapper;
	}

	@Override
	public int deleteGradeById(Integer gradeid) {
		return gradeMapper.deleteByPrimaryKey(gradeid);
	}

	@Override
	public int addGrade(Grade record) {
		return gradeMapper.insert(record);
	}

	@Override
	public int addGradeSelective(Grade record) {
		return gradeMapper.insertSelective(record);
	}

	@Override
	public Grade getGradeById(Integer gradeid) {
		return gradeMapper.selectByPrimaryKey(gradeid);
	}

	@Override
	public int updateGradeByIdSelective(Grade record) {
		return gradeMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateGradeById(Grade record) {
		return gradeMapper.updateByPrimaryKey(record);
	}

	@Override
	public List<Grade> getGradesByStuid(Integer stuid) {
		return gradeMapper.getGradesByStuid(stuid);
	}

	@Override
	public Grade getGradeByName(String gradename) {
		return gradeMapper.getGradeByName(gradename);
	}

}
