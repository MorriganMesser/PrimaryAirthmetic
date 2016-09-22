package edu.tju.goliath.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.code.kaptcha.Constants;

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
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpServletRequest request,
			@RequestParam("username") String username,
			@RequestParam("userpwd") String userpwd,
			@RequestParam("imgcode") String imgcode,ModelMap model) {
		System.out.println("start request");
		HttpSession session = request.getSession();
		String code = (String) session
				.getAttribute(Constants.KAPTCHA_SESSION_KEY);
		System.out.println(code);
		String msg="";
		if(!imgcode.equals(code)){
			 msg="验证码错误！";
			 System.out.println(msg);
			session.setAttribute("msg", msg);
//			model.addAttribute("msg", msg);
			return "views/login";
		}else{
			if(userService.selectByUsername(username)==null){
				 msg="此用户不存在！";
				 System.out.println(msg);
				session.setAttribute("msg", msg);
				return "views/login";
			}else{
				if(!userpwd.equals(userService.selectByUsername(username).getUserpwd())){
					msg="密码错误！";
					System.out.println(msg);
					session.setAttribute("msg", msg);
					return "views/login";
				}else{
					User user=userService.selectByUsername(username);
					System.out.println(user.getUsername());
					session.setAttribute("user", user);
					return "views/login_success";
				}
			}
		}


	}
}
