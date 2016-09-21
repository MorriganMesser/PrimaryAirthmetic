package edu.tju.goliath.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.tju.goliath.entity.User;

public interface UserServiceI {
	public User getUserById(Integer userid);

	public int deleteById(Integer userid);

	public int insert(User user);

	public int insertSelective(User user);

	public int updateByPrimaryKeySelective(User user);
	
	public User selectByUsername(String username);
}
