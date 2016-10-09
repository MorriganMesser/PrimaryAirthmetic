package edu.tju.goliath.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.tju.goliath.dao.TeacherMapper;
import edu.tju.goliath.entity.Teacher;
import edu.tju.goliath.service.TeacherServiceI;

@Service("teacherService")
public class TeacherServiceImpl implements TeacherServiceI {
	
	private TeacherMapper teacherMapper;
	

	public TeacherMapper getTeacherMapper() {
		return teacherMapper;
	}

	@Autowired
	public void setTeacherMapper(TeacherMapper teacherMapper) {
		this.teacherMapper = teacherMapper;
	}

	@Override
	public int deleteTeacherById(Integer teacherid) {
		return teacherMapper.deleteByPrimaryKey(teacherid);
	}

	@Override
	public int addTeacher(Teacher record) {
		return teacherMapper.insert(record);
	}

	@Override
	public int addTeacherSelective(Teacher record) {
		return teacherMapper.insertSelective(record);
	}

	@Override
	public Teacher getTeacherById(Integer teacherid) {
		return teacherMapper.selectByPrimaryKey(teacherid);
	}

	@Override
	public int updateTeacherByIdSelective(Teacher record) {
		return teacherMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateTeacherById(Teacher record) {
		return teacherMapper.updateByPrimaryKey(record);
	}

	@Override
	public Teacher getTeacherByName(String teachername) {
		return teacherMapper.selectByTeacherName(teachername);
	}

	@Override
	public Teacher getTeacherByEmail(String teacheremail) {
		return teacherMapper.selectByTeacherEmail(teacheremail);
	}

}
