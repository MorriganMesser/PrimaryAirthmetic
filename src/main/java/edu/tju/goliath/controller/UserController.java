package edu.tju.goliath.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.runners.Parameterized.Parameter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
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
	 
	 * 登陆：
	 * 1.输入为用户名或者邮箱
	 * 2.判断输入是否为空
	 
	 * 修改密码：
	 * 1.从前台传入用户类型和用户对象
	 * 2.调用修改密码方法
	 */

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
			@RequestParam("username") String username,
			@RequestParam("email") String email,
			@RequestParam("password") String password,
			@RequestParam("type") String type) {
		HttpSession session = request.getSession();
		System.out.println(type);
		String msg="";
		if ("家长".equals(type)) {
			Parent parent = new Parent();
			parent.setParentemail(email);
			parent.setParentname(username);
			parent.setParentnick(nick);
			parent.setParentpwd(password);
			int result = parentservice.addParentSelective(parent);
			 msg="";
			session.setAttribute("msg", msg);
		} else if ("教师".equals(type)) {
			Teacher teacher = new Teacher();
			teacher.setTeacheremail(email);
			teacher.setTeachername(username);
			teacher.setTeachernick(nick);
			teacher.setTeacherpwd(password);
			int result = teacherservice.addTeacherSelective(teacher);
		} else if("学生".equals(type)){
			Student stu = new Student();
			stu.setStuemail(email);
			stu.setStuname(username);
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

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String login(HttpServletRequest request,
			@RequestParam("nameoremail") String nameoremail,
			@RequestParam("password") String password,
			@RequestParam("type") String type) {
		HttpSession session = request.getSession();
		System.out.println("用户名或邮箱："+nameoremail+"密码："+password+"类型："+type);
		if ("家长".equals(type)) {
			if(!((null==parentservice.getParentByEmail(nameoremail))&&(null==parentservice.getParentByName(nameoremail)))){
				if(!(null==parentservice.getParentByEmail(nameoremail))){
					Parent parent=parentservice.getParentByEmail(nameoremail);
					if(password.equals(parent.getParentpwd())){
						session.setAttribute("parent", parent);
						System.out.println("家长"+parent.getParentname()+"登陆成功");
						return "views/parentinfo";
					}else{
						System.out.println("家长"+parent.getParentname()+"密码错误");
						return "views/errorpwd";
					}
				}else {
					Parent parent=parentservice.getParentByName(nameoremail);
					if(password.equals(parent.getParentpwd())){
						session.setAttribute("parent", parent);
						System.out.println("家长"+parent.getParentname()+"登陆成功");
						return "views/parentinfo";
					}else{
						System.out.println("家长"+parent.getParentname()+"密码错误");
						return "views/errorpwd";
					}
				}
			}else{
				System.out.println("用户名或密码错误");
				return "views/errorpwd";
			}
				
		} else if ("教师".equals(type)) {
				if(!((null==teacherservice.getTeacherByEmail(nameoremail))&&(null==teacherservice.getTeacherByName(nameoremail)))){
					if(!(null==teacherservice.getTeacherByEmail(nameoremail))){
						Teacher teacher=teacherservice.getTeacherByEmail(nameoremail);
						if(password.equals(teacher.getTeacherpwd())){
							session.setAttribute("teacher", teacher);
							System.out.println("教师"+teacher.getTeachername()+"登陆成功");
							return "views/teacherinfo";
						}else{
							System.out.println("教师"+teacher.getTeachername()+"密码错误");
							return "views/errorpwd";
						}
					}else {
						Teacher teacher=teacherservice.getTeacherByName(nameoremail);
						if(password.equals(teacher.getTeacherpwd())){
							session.setAttribute("teacher", teacher);
							System.out.println("教师"+teacher.getTeachername()+"登陆成功");
							return "views/teacherinfo";
						}else{
							System.out.println("教师"+teacher.getTeachername()+"密码错误");
							return "views/errorpwd";
						}
					}
				}else{
					System.out.println("用户名或密码错误");
					return "views/errorpwd";
				}
				//return "views/teacherinfo";
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
						return "views/errorpwd";
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
						return "views/errorpwd";
					}
				}
			}else{
				System.out.println("用户名或密码错误");
				return "views/errorpwd";
			}
			return "index";
		}
		
	}
	
	@RequestMapping(value = "/signup", method = RequestMethod.GET)
	public String signup(HttpServletRequest request){
		HttpSession session = request.getSession();
		session.removeAttribute("student");
		session.removeAttribute("teacher");
		session.removeAttribute("parent");
		return "index";
	}
	
	
	@RequestMapping(value = "/validateName", method = RequestMethod.POST)
	public void validateName(HttpServletRequest request,HttpServletResponse response,
			@RequestParam("loginName") String loginName) throws IOException{
		System.out.println(loginName);
		System.out.println(stuservice.getStuByName(loginName));
		System.out.println(null==stuservice.getStuByName(loginName));
		if(null==stuservice.getStuByName(loginName)){
			System.out.println("用户名可以注册");
			 response.getWriter().write("true");//此值jquery可以接收到  
		}else{
			System.out.println("用户名已经存在");
			 response.getWriter().write("false");//此值jquery可以接收到  
		}
	}
	
	@RequestMapping(value = "/validateEmail", method = RequestMethod.POST)
	public void validateEmail(HttpServletRequest request,HttpServletResponse response,
			@RequestParam("loginEmail") String loginEmail) throws IOException{
		System.out.println(loginEmail);
		System.out.println(stuservice.getStuByEmail(loginEmail));
		if(null==(stuservice.getStuByEmail(loginEmail))){
			System.out.println("邮箱可以注册");
			 response.getWriter().write("true");//此值jquery可以接收到  
		}else{
			System.out.println("邮箱已经被注册");
			 response.getWriter().write("false");//此值jquery可以接收到  
		}
	}
}
