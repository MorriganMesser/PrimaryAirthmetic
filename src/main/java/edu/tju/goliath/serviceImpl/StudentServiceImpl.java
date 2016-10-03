package edu.tju.goliath.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.tju.goliath.dao.StudentMapper;
import edu.tju.goliath.entity.Student;
import edu.tju.goliath.service.StudentServiceI;

@Service("stuService")
public class StudentServiceImpl implements StudentServiceI {
	
	private StudentMapper stuMapper;
	

	public StudentMapper getStuMapper() {
		return stuMapper;
	}
	@Autowired
	public void setStuMapper(StudentMapper stuMapper) {
		this.stuMapper = stuMapper;
	}

	@Override
	public int deleteStuById(Integer stuid) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addStu(Student record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int addStuSelective(Student record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Student getStuById(Integer stuid) {
		return stuMapper.selectByPrimaryKey(stuid);
	}

	@Override
	public int updateStuByIdSelective(Student record) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int updateStuById(Student record) {
		// TODO Auto-generated method stub
		return 0;
	}

}
