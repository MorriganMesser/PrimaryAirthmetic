package edu.tju.goliath.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.tju.goliath.entity.Grade;
import edu.tju.goliath.entity.Parent;
import edu.tju.goliath.entity.Student;
import edu.tju.goliath.entity.Teacher;
import edu.tju.goliath.service.GradeServiceI;
import edu.tju.goliath.service.ParentServiceI;
import edu.tju.goliath.service.StudentServiceI;
import edu.tju.goliath.service.TeacherServiceI;

@Controller
public class StuController {
	
	/*
	 * 查询考试记录：
	 * 	一个学生对应多个考试成绩，查询时list<Grade> getGradeByStuId()
	 */
	private GradeServiceI gradeservice;
	private ParentServiceI parentservice;
	private TeacherServiceI teacherservice;
	
	

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

	public GradeServiceI getGradeservice() {
		return gradeservice;
	}

	@Autowired
	public void setGradeservice(GradeServiceI gradeservice) {
		this.gradeservice = gradeservice;
	}
	
	private StudentServiceI stuservice;
	
	public StudentServiceI getStuservice() {
		return stuservice;
	}

	@Autowired
	public void setStuservice(StudentServiceI stuservice) {
		this.stuservice = stuservice;
	}

	@RequestMapping(value = "/getStuGrade", method = RequestMethod.GET)
	public String getStuGrade(HttpServletRequest request) {
		HttpSession session = request.getSession();
		
		Student stu = (Student)session.getAttribute("student");
		System.out.println(stu);
		List<Grade> gradelist = gradeservice.getGradesByStuid(stu.getStuid());
		session.setAttribute("gradelist", gradelist);
		return "views/historyscore";
	}
	//getStuMsg.do
	@RequestMapping(value = "/getStuMsg", method = RequestMethod.GET)
	public String getStuMsg(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Student stu = (Student)session.getAttribute("student");
		if(null==stu){
			return "views/error";
		}else{
			System.out.println("显示个人信息:"+stu.getStuname());
			Parent parent = parentservice.getParentById(stu.getStuparentid());
			Teacher teacher = teacherservice.getTeacherById(stu.getStuteacherid());
			session.setAttribute("student", stu);
			session.setAttribute("teacher", teacher);
			session.setAttribute("parent", parent);
			return "views/stuinfo";
		}
	}
	
	@RequestMapping(value = "/addParent", method = RequestMethod.GET)
	public String addParent(HttpServletRequest request,
			@RequestParam("parentid") String parentid) {
		HttpSession session = request.getSession();
		Student stu = (Student)session.getAttribute("student");
		int stuparentid = Integer.parseInt(parentid);
		stu.setStuparentid(stuparentid);
		System.out.println(stu);
		session.setAttribute("student", stu);
		return "views/info";
	}
	
	@RequestMapping(value = "/addTeacher", method = RequestMethod.GET)
	public String addTeacher(HttpServletRequest request,
			@RequestParam("teacherid") String teacherid) {
		HttpSession session = request.getSession();
		Student stu = (Student)session.getAttribute("student");
		int stuteacherid = Integer.parseInt(teacherid);
		stu.setStuteacherid(stuteacherid);
		System.out.println(stu);
		session.setAttribute("student", stu);
		return "views/info";
	}
	
	@RequestMapping(value = "/changeStuPwd", method = RequestMethod.GET)
	public String changeStuPwd(HttpServletRequest request,
			@RequestParam("password") String password) {
		HttpSession session = request.getSession();
		Student stu = (Student)session.getAttribute("student");
		stu.setStupwd(password);
		stuservice.updateStuByIdSelective(stu);
		session.setAttribute("student", stu);
		return "views/stuinfo";
	}
	
	//addParentAndTeacher.do
	@RequestMapping(value = "/addParentAndTeacher", method = RequestMethod.POST)
	public String addParentAndTeacher(HttpServletRequest request,
			@RequestParam("stuteacherid") String stuteacherid,
			@RequestParam("stuparentid") String stuparentid) {
		HttpSession session = request.getSession();
		Student stu = (Student)session.getAttribute("student");
		if(("".equals(stuteacherid)||null==stuteacherid)&&("".equals(stuparentid)||null==stuparentid)){
			session.setAttribute("student", stu);
			return "views/stuinfo";
		}else if("".equals(stuteacherid)||null==stuteacherid&&(!"".equals(stuparentid)||null!=stuparentid)){
			stu.setStuparentid(Integer.parseInt(stuparentid));
			stuservice.updateStuByIdSelective(stu);
			session.setAttribute("student", stu);
			return "views/stuinfo";
		}else{
			stu.setStuteacherid(Integer.parseInt(stuteacherid));
			stu.setStuparentid(Integer.parseInt(stuparentid));
			stuservice.updateStuByIdSelective(stu);
			session.setAttribute("student", stu);
			return "views/stuinfo";
		}
	}

	@RequestMapping(value = "/exampage", method = RequestMethod.GET)
	public String exam(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Student stu = (Student)session.getAttribute("student");
		System.out.println(stu);
		if(null==stu){
			return "views/error";
		}
		else{
			session.setAttribute("student", stu);
			return "views/exam";
		}
	}
	
	@RequestMapping(value = "/testpage", method = RequestMethod.GET)
	public String test(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Student stu = (Student)session.getAttribute("student");
		System.out.println(stu);
		if(null==stu){
			return "views/error";
		}
		else{
			session.setAttribute("student", stu);
			return "views/test";
		}
	}
}
