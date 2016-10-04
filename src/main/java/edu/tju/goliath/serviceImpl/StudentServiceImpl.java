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
		return stuMapper.deleteByPrimaryKey(stuid);
	}

	@Override
	public int addStu(Student record) {
		return stuMapper.insert(record);
	}

	@Override
	public int addStuSelective(Student record) {
		return stuMapper.insertSelective(record);
	}

	@Override
	public Student getStuById(Integer stuid) {
		return stuMapper.selectByPrimaryKey(stuid);
	}

	@Override
	public int updateStuByIdSelective(Student record) {
		return stuMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateStuById(Student record) {
		return stuMapper.updateByPrimaryKey(record);
	}
	@Override
	public Student getStuByName(String stuname) {
		return stuMapper.selectByStuName(stuname);
	}
	@Override
	public Student getStuByEmail(String stuemail) {
		return stuMapper.selectByStuEmail(stuemail);
	}

}
