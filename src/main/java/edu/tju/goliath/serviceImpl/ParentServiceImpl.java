package edu.tju.goliath.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.tju.goliath.dao.ParentMapper;
import edu.tju.goliath.entity.Parent;
import edu.tju.goliath.service.ParentServiceI;

@Service("parentService")
public class ParentServiceImpl implements ParentServiceI {
	
	private ParentMapper parentMapper;

	public ParentMapper getParentMapper() {
		return parentMapper;
	}

	@Autowired
	public void setParentMapper(ParentMapper parentMapper) {
		this.parentMapper = parentMapper;
	}

	@Override
	public int deleteParentById(Integer parentid) {
		return parentMapper.deleteByPrimaryKey(parentid);
	}

	@Override
	public int addParent(Parent record) {
		return parentMapper.insert(record);
	}

	@Override
	public int addParentSelective(Parent record) {
		return parentMapper.insertSelective(record);
	}

	@Override
	public Parent getParentById(Integer parentid) {
		return parentMapper.selectByPrimaryKey(parentid);
	}

	@Override
	public int updateParentByIdSelective(Parent record) {
		return parentMapper.updateByPrimaryKeySelective(record);
	}

	@Override
	public int updateParentById(Parent record) {
		return parentMapper.updateByPrimaryKey(record);
	}

	@Override
	public Parent getParentByName(String parentname) {
		return parentMapper.selectByParentName(parentname);
	}

	@Override
	public Parent getParentByEmail(String parentemail) {
		return parentMapper.selectByParentEmail(parentemail);
	}

	@Override
	public List<Parent> getAllParent() {
		return parentMapper.getAllParent();
	}

}
