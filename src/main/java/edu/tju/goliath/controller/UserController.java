package edu.tju.goliath.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import edu.tju.goliath.entity.User;
import edu.tju.goliath.service.UserServiceI;

@Controller
@RequestMapping("/userController")
public class UserController {

	private UserServiceI userService;

	public UserServiceI getUserService() {
		return userService;
	}

	@Autowired
	public void setUserService(UserServiceI userService) {
		this.userService = userService;
	}

	@RequestMapping("/{id}/showUser")
	public String showUser(@PathVariable Integer id, HttpServletRequest request) {
		User u = userService.getUserById(id);
		request.setAttribute("user", u);
		System.out.println("u");
		return "showUser";
	}

	@RequestMapping("registerUser")
	public String registerUser(@PathVariable User user, HttpServletRequest request){
		int result=userService.insertSelective(user);
		return "register_success";
	}
	
	@RequestMapping("loginUser")
	public String loginUser(@PathVariable User user, HttpServletRequest request){
		User user_data=userService.selectByUsername(user.getUsername());
		if(user.getUsername()==user_data.getUsername()){
			return "login_success";
		}else{
			return "login_error";
		}
		
		
	}
}
