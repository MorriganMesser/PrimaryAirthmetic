package edu.tju.goliath.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import edu.tju.goliath.entity.Grade;
import edu.tju.goliath.entity.Student;
import edu.tju.goliath.service.GradeServiceI;

@Controller
public class StuController {
	
	/*
	 * 查询考试记录：
	 * 	一个学生对应多个考试成绩，查询时list<Grade> getGradeByStuId()
	 */
	private GradeServiceI gradeservice;

	public GradeServiceI getGradeservice() {
		return gradeservice;
	}

	@Autowired
	public void setGradeservice(GradeServiceI gradeservice) {
		this.gradeservice = gradeservice;
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
		System.out.println(stu);
		session.setAttribute("student", stu);
		return "views/info";
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
	

}
