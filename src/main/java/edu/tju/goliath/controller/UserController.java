package edu.tju.goliath.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
	
	/*
	 * 注册：
	 * 1.判断邮箱格式是否正确
	 * 2.判断邮箱是否已经被注册
	 * 3.判断用户名是否格式正确
	 * 4.判断用户名是否已经存在
	 * 5.判断密码格式是否正确
	 * 
	 * 登陆：
	 * 1.输入为用户名或者邮箱
	 * 2.判断输入是否为空
	 * 
	 * 修改密码：
	 * 1.从前台传入用户类型和用户对象
	 * 2.调用修改密码方法
	 */

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
			session.setAttribute("student", stu);
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
			@RequestParam("nameoremail") String nameoremail,
			@RequestParam("password") String password,
			@RequestParam("type") String type) {
		HttpSession session = request.getSession();
		System.out.println("用户名或邮箱："+nameoremail+"密码："+password+"类型："+type);
//		System.out.println(parentservice.getParentByEmail(nameoremail));
//		System.out.println(parentservice.getParentByName(nameoremail));
//		System.out.println(null==parentservice.getParentByEmail(nameoremail));
//		System.out.println(!((null==parentservice.getParentByEmail(nameoremail))&&(null==parentservice.getParentByName(nameoremail))));
		if ("家长".equals(type)) {
			if(!((null==parentservice.getParentByEmail(nameoremail))&&(null==parentservice.getParentByName(nameoremail)))){
				if(!(null==parentservice.getParentByEmail(nameoremail))){
					Parent parent=parentservice.getParentByEmail(nameoremail);
					if(password.equals(parent.getParentpwd())){
						System.out.println("家长"+parent.getParentname()+"登陆成功");
					}else{
						System.out.println("家长"+parent.getParentname()+"密码错误");
					}
				}else {
					Parent parent=parentservice.getParentByName(nameoremail);
					if(password.equals(parent.getParentpwd())){
						System.out.println("家长"+parent.getParentname()+"登陆成功");
					}else{
						System.out.println("家长"+parent.getParentname()+"密码错误");
					}
				}
			}else{
				System.out.println("用户名或密码错误");
			}
			
		} else if ("教师".equals(type)) {
				if(!((null==teacherservice.getTeacherByEmail(nameoremail))&&(null==teacherservice.getTeacherByName(nameoremail)))){
					if(!(null==teacherservice.getTeacherByEmail(nameoremail))){
						Teacher teacher=teacherservice.getTeacherByEmail(nameoremail);
						if(password.equals(teacher.getTeacherpwd())){
							System.out.println("教师"+teacher.getTeachername()+"登陆成功");
						}else{
							System.out.println("教师"+teacher.getTeachername()+"密码错误");
						}
					}else {
						Teacher teacher=teacherservice.getTeacherByName(nameoremail);
						if(password.equals(teacher.getTeacherpwd())){
							System.out.println("教师"+teacher.getTeachername()+"登陆成功");
						}else{
							System.out.println("教师"+teacher.getTeachername()+"密码错误");
						}
					}
				}else{
					System.out.println("用户名或密码错误");
				}
				
		} else {
			if(!((null==stuservice.getStuByEmail(nameoremail))&&(null==stuservice.getStuByName(nameoremail)))){
				if(!(null==stuservice.getStuByEmail(nameoremail))){
					Student stu=stuservice.getStuByEmail(nameoremail);
					System.out.println("密码1："+password+"密码2："+stu.getStupwd());
					if(password.equals(stu.getStupwd())){
//						request.setAttribute("student", stu);
						session.setAttribute("student", stu);
						
						System.out.println("session="+session.getAttribute("student"));
						System.out.println("学生"+stu.getStuname()+"登陆成功");
					}else{
						System.out.println("学生"+stu.getStuname()+"密码错误");
					}
				}else {
					Student stu=stuservice.getStuByName(nameoremail);
					System.out.println(stu);
					System.out.println("密码1："+password);
					System.out.println("密码2："+stu.getStupwd());
					if(password.equals(stu.getStupwd())){
//						request.setAttribute("student", stu);
						session.setAttribute("student", stu);
						System.out.println("session="+session.getAttribute("student"));
						System.out.println("学生"+stu.getStuname()+"登陆成功");
						
					}else{
						System.out.println("学生"+stu.getStuname()+"密码错误");
					}
				}
			}else{
				System.out.println("用户名或密码错误");
			}
		}
		return "index";
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signup(HttpServletRequest request){
		HttpSession session = request.getSession();
		session.removeAttribute("student");
		return "index";
	}
	
	@RequestMapping(value = "/validateName", method = RequestMethod.POST)
	public String validateName(HttpServletRequest request,HttpServletResponse response,
			@RequestParam("loginName") String loginName) throws IOException{
		String q = "q";
		if(q.equals(loginName)){
			 response.getWriter().write("true");//此值jquery可以接收到  
		}
		
		System.out.println(loginName);
		return "";
	}

}
