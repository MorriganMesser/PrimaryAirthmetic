package edu.tju.goliath.service;

import java.util.List;

import org.springframework.stereotype.Service;

import edu.tju.goliath.entity.User;

@Service("userService")
public interface UserService {

	public User getUserById(String id);


}
