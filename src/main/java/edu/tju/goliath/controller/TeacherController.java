package edu.tju.goliath.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;

import edu.tju.goliath.entity.Grade;
import edu.tju.goliath.entity.Student;
import edu.tju.goliath.entity.Teacher;
import edu.tju.goliath.service.GradeServiceI;
import edu.tju.goliath.service.StudentServiceI;
import edu.tju.goliath.service.TeacherServiceI;

@Controller
public class TeacherController {
	private TeacherServiceI teacherservice;
	private StudentServiceI studentservice;
	private GradeServiceI gradeservice;
	
	public GradeServiceI getGradeservice() {
		return gradeservice;
	}
	@Autowired
	public void setGradeservice(GradeServiceI gradeservice) {
		this.gradeservice = gradeservice;
	}
	public StudentServiceI getStudentservice() {
		return studentservice;
	}
	@Autowired
	public void setStudentservice(StudentServiceI studentservice) {
		this.studentservice = studentservice;
	}
	public TeacherServiceI getTeacherservice() {
		return teacherservice;
	}
	@Autowired
	public void setTeacherservice(TeacherServiceI teacherservice) {
		this.teacherservice = teacherservice;
	}

	@RequestMapping(value = "/getAllTeachers", method = RequestMethod.POST)
	public void getAllTeachers(HttpServletRequest request,HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		Student stu = (Student)session.getAttribute("student");
		System.out.println(stu);
		List<Teacher> teacherlist = new ArrayList<Teacher>();
		List<Teacher> l =teacherservice.getAllTeacher();
		System.out.println("全部教师："+l);
		for(Teacher o : l){
			Teacher sz = o;
			System.out.println("教师名字："+sz.toString());
			Teacher teacher = new Teacher();
			teacher.setTeacherid(sz.getTeacherid());
			teacher.setTeachername(sz.getTeachername().toString());
			teacherlist.add(teacher);
		}
		Gson gson = new Gson();
		String parentjsonObject = gson.toJson(teacherlist); 
		response.getWriter().write(parentjsonObject);//此值jquery可以接收到  
	}
	
	//getStuByTeacher.do
	@RequestMapping(value = "/getStuByTeacher", method = RequestMethod.GET)
	public String getStuByTeacher(HttpServletRequest request,HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		Teacher teacher = (Teacher)session.getAttribute("teacher");
		List<Student> stulist = studentservice.getStudentByTeacherid(teacher.getTeacherid());
		session.setAttribute("stulist", stulist);
		return "views/teacherstudent";
	}
	
	//getStuGradeByTeacher.do
	
	@RequestMapping(value = "/getStuGradeByTeacher", method = RequestMethod.POST)
	public String getStuGradeByTeacher(HttpServletRequest request,HttpServletResponse response,
			@RequestParam("stuid") String stuid) throws IOException {
		HttpSession session = request.getSession();
		Teacher teacher = (Teacher)session.getAttribute("teacher");
		int stuID = Integer.parseInt(stuid);
		Student student = studentservice.getStuById(stuID);
		List<Grade> gradelist = gradeservice.getGradesByStuid(stuID);
		session.setAttribute("gradelist", gradelist);
		return "views/teacherscore";
	}
	
	@RequestMapping(value = "/getStuAllGrades", method = RequestMethod.GET)
	public String getAllGrades(HttpServletRequest request,HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		Teacher teacher = (Teacher)session.getAttribute("teacher");
		List<Student> stulist = studentservice.getStudentByTeacherid(teacher.getTeacherid());
		List<Grade> allgradelist = new ArrayList<Grade>();
		
		for (int i = 0; i < stulist.size(); i++) {
			Student student = stulist.get(i);
			List<Grade> gradelist = gradeservice.getGradesByStuid(student.getStuid());
			allgradelist.addAll(gradelist);
		}
		
		session.setAttribute("gradelist", allgradelist);
		return "views/teacherscore";
	}
	
	//"getTeacherMsg.do"
	@RequestMapping(value = "/getTeacherMsg", method = RequestMethod.GET)
	public String getTeacherMsg(HttpServletRequest request,HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		Teacher teacher = (Teacher)session.getAttribute("teacher");
		
		session.setAttribute("teacher", teacher);
		return "views/teacherinfo";
		
	}
	
	//getStuGradeGraphByTeacher.do
	@RequestMapping(value = "/getStuGradeGraphByTeacher", method = RequestMethod.POST)
	public String getStuGradeGraphByTeacher(HttpServletRequest request,HttpServletResponse response,
			@RequestParam("stuid") String stuid) throws IOException {
		HttpSession session = request.getSession();
		Teacher teacher = (Teacher)session.getAttribute("teacher");
		int stuID = Integer.parseInt(stuid);
		Student student = studentservice.getStuById(stuID);
		List<Grade> gradelist = gradeservice.getGradesByStuid(stuID);
		session.setAttribute("gradelist", gradelist);
		return "views/teachergraphcontent";
	}
}
