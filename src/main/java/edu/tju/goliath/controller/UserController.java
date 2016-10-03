package edu.tju.goliath.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.google.code.kaptcha.Constants;

import edu.tju.goliath.entity.Parent;
import edu.tju.goliath.entity.Student;
import edu.tju.goliath.entity.Teacher;
import edu.tju.goliath.entity.User;
import edu.tju.goliath.service.ParentServiceI;
import edu.tju.goliath.service.StudentServiceI;
import edu.tju.goliath.service.TeacherServiceI;

@Controller
public class UserController {

	// private UserServiceI userService;
	//
	// public UserServiceI getUserService() {
	// return userService;
	// }
	//
	// @Autowired
	// public void setUserService(UserServiceI userService) {
	// this.userService = userService;
	// }
	//
	// @RequestMapping("/{id}/showUser")
	// public String showUser(@PathVariable Integer id, HttpServletRequest
	// request) {
	// User u = userService.getUserById(id);
	// request.setAttribute("user", u);
	// System.out.println("u");
	// return "showUser";
	// }
	private StudentServiceI stuservice;
	private TeacherServiceI teacherservice;
	private ParentServiceI parentservice;

	public StudentServiceI getStuservice() {
		return stuservice;
	}

	@Autowired
	public void setStuservice(StudentServiceI stuservice) {
		this.stuservice = stuservice;
	}

	public TeacherServiceI getTeacherservice() {
		return teacherservice;
	}

	@Autowired
	public void setTeacherservice(TeacherServiceI teacherservice) {
		this.teacherservice = teacherservice;
	}

	public ParentServiceI getParentservice() {
		return parentservice;
	}

	@Autowired
	public void setParentservice(ParentServiceI parentservice) {
		this.parentservice = parentservice;
	}

	@RequestMapping(value = "/register", method = RequestMethod.POST)
	public ModelAndView registerUser(HttpServletRequest request,
			@RequestParam("nick") String nick,
			@RequestParam("name") String name,
			@RequestParam("email") String email,
			@RequestParam("password") String password,
			@RequestParam("type") String type) {
		HttpSession session = request.getSession();
		System.out.println(type);
		String msg="";
		if ("家长".equals(type)) {
			Parent parent = new Parent();
			parent.setParentemail(email);
			parent.setParentname(name);
			parent.setParentnick(nick);
			parent.setParentpwd(password);
			int result = parentservice.addParentSelective(parent);
			 msg="";
			session.setAttribute("msg", msg);
		} else if ("教师".equals(type)) {
			Teacher teacher = new Teacher();
			teacher.setTeacheremail(email);
			teacher.setTeachername(name);
			teacher.setTeachernick(nick);
			teacher.setTeacherpwd(password);
			int result = teacherservice.addTeacherSelective(teacher);
		} else if("学生".equals(type)){
			Student stu = new Student();
			stu.setStuemail(email);
			stu.setStuname(name);
			stu.setStunick(nick);
			stu.setStupwd(password);
			System.out.println(stu);
			int result = stuservice.addStuSelective(stu);
		}else{
			System.out.println("type failed");
		}
		return new ModelAndView("index");
	}

//	@RequestMapping(value = "/login", method = RequestMethod.POST)
//	public String login(HttpServletRequest request,
//			@RequestParam("username") String username,
//			@RequestParam("userpwd") String userpwd,
//			@RequestParam("imgcode") String imgcode, ModelMap model) {
//		System.out.println("start request");
//		HttpSession session = request.getSession();
//		String code = (String) session
//				.getAttribute(Constants.KAPTCHA_SESSION_KEY);
//		System.out.println(code);
//		String msg = "";
//		if (!imgcode.equals(code)) {
//			msg = "验证码错误！";
//			System.out.println(msg);
//			session.setAttribute("msg", msg);
//			// model.addAttribute("msg", msg);
//			return "views/login";
//		} else {
//			if (userService.selectByUsername(username) == null) {
//				msg = "此用户不存在！";
//				System.out.println(msg);
//				session.setAttribute("msg", msg);
//				return "views/login";
//			} else {
//				if (!userpwd.equals(userService.selectByUsername(username)
//						.getUserpwd())) {
//					msg = "密码错误！";
//					System.out.println(msg);
//					session.setAttribute("msg", msg);
//					return "views/login";
//				} else {
//					User user = userService.selectByUsername(username);
//					System.out.println(user.getUsername());
//					session.setAttribute("user", user);
//					return "views/login_success";
//				}
//			}
//		}
//
//	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpServletRequest request,
			@RequestParam("name") String name,
			@RequestParam("email") String email,
			@RequestParam("password") String password,
			@RequestParam("type") String type) {
		HttpSession session = request.getSession();
		
		if ("家长".equals(type)) {
		
		} else if ("教师".equals(type)) {
		
		} else {
		
		}
		return "login_success";
	}
}
