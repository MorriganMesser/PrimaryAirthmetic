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

import com.google.gson.Gson;

import edu.tju.goliath.entity.Parent;
import edu.tju.goliath.entity.Student;
import edu.tju.goliath.entity.Teacher;
import edu.tju.goliath.service.TeacherServiceI;

@Controller
public class TeacherController {
	private TeacherServiceI teacherservice;
	
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

}
