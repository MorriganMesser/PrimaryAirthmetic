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
import edu.tju.goliath.entity.Parent;
import edu.tju.goliath.entity.Student;
import edu.tju.goliath.entity.Teacher;
import edu.tju.goliath.service.GradeServiceI;
import edu.tju.goliath.service.ParentServiceI;
import edu.tju.goliath.service.StudentServiceI;

@Controller
public class ParentController {
	
	private ParentServiceI parentservice;
	private GradeServiceI gradeservice;
	private StudentServiceI studentservice;
	

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

	public ParentServiceI getParentservice() {
		return parentservice;
	}

	@Autowired
	public void setParentservice(ParentServiceI parentservice) {
		this.parentservice = parentservice;
	}
	
	@RequestMapping(value = "/getAllParents", method = RequestMethod.POST)
	public void getAllParents(HttpServletRequest request,HttpServletResponse response) throws IOException {
		HttpSession session = request.getSession();
		Student stu = (Student)session.getAttribute("student");
		System.out.println(stu);
		List<Parent> parentlist = new ArrayList<Parent>();
		List<Parent> l = parentservice.getAllParent();
		System.out.println("全部父母："+l);
		for(Parent o : l){
			Parent sz = o;
			System.out.println("父母名字："+sz.toString());
			Parent parent = new Parent();
			parent.setParentid(sz.getParentid());
			parent.setParentname(sz.getParentname().toString());
			parentlist.add(parent);
		}
		Gson gson = new Gson();
		String parentjsonObject = gson.toJson(parentlist); 
		response.getWriter().write(parentjsonObject);//此值jquery可以接收到  
	}
	
	//getStuByParent.do
		@RequestMapping(value = "/getStuByParent", method = RequestMethod.GET)
		public String getStuByParent(HttpServletRequest request,HttpServletResponse response) throws IOException {
			HttpSession session = request.getSession();
			Parent parent = (Parent)session.getAttribute("parent");
			List<Student> stulist = studentservice.getStudentByParentid(parent.getParentid());
			session.setAttribute("stulist", stulist);
			return "views/parentstudent";
		}
		
		//getStuGradeByParent.do
		
		@RequestMapping(value = "/getStuGradeByParent", method = RequestMethod.POST)
		public String getStuGradeByParent(HttpServletRequest request,HttpServletResponse response,
				@RequestParam("stuid") String stuid) throws IOException {
			HttpSession session = request.getSession();
			Parent parent = (Parent)session.getAttribute("parent");
			int stuID = Integer.parseInt(stuid);
			Student student = studentservice.getStuById(stuID);
			List<Grade> gradelist = gradeservice.getGradesByStuid(stuID);
			session.setAttribute("gradelist", gradelist);
			return "views/parentscore";
		}
		
		@RequestMapping(value = "/getAllStuGrades", method = RequestMethod.GET)
		public String getAllGrades(HttpServletRequest request,HttpServletResponse response) throws IOException {
			HttpSession session = request.getSession();
			Parent parent = (Parent)session.getAttribute("parent");
			List<Grade> allgradelist = gradeservice.getAllGrades();
			
			session.setAttribute("gradelist", allgradelist);
			return "views/parentscore";
		}
		
		//"getParentMsg.do"
		@RequestMapping(value = "/getParentMsg", method = RequestMethod.GET)
		public String getTeacherMsg(HttpServletRequest request,HttpServletResponse response) throws IOException {
			HttpSession session = request.getSession();
			Parent parent = (Parent)session.getAttribute("parent");
			
			session.setAttribute("parent", parent);
			return "views/parentinfo";
			
		}
		
		//getStuGradeGraphByParent.do
		@RequestMapping(value = "/getStuGradeGraphByParent", method = RequestMethod.GET)
		public String getStuGradeGraphByTeacher(HttpServletRequest request,HttpServletResponse response) throws IOException {
			HttpSession session = request.getSession();
			Parent parent = (Parent)session.getAttribute("parent");
			List<Student> stulist = studentservice.getStudentByParentid(parent.getParentid());
			int stuID = stulist.get(0).getStuid();
			Student student = studentservice.getStuById(stuID);
			List<Grade> gradelist = gradeservice.getGradesByStuid(stuID);
			session.setAttribute("gradelist", gradelist);
			return "views/parentgraphcontent";
		}

}
