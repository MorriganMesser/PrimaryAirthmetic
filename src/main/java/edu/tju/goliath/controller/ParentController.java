package edu.tju.goliath.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.tju.goliath.entity.Grade;
import edu.tju.goliath.entity.Parent;
import edu.tju.goliath.entity.Student;
import edu.tju.goliath.service.ParentServiceI;

@Controller
public class ParentController {
	
	private ParentServiceI parentservice;

	public ParentServiceI getParentservice() {
		return parentservice;
	}

	@Autowired
	public void setParentservice(ParentServiceI parentservice) {
		this.parentservice = parentservice;
	}
	
	@RequestMapping(value = "/getAllParents", method = RequestMethod.GET)
	public void getAllParents(HttpServletRequest request) {
		HttpSession session = request.getSession();
		Student stu = (Student)session.getAttribute("student");
		System.out.println(stu);
		List<Parent> parentlist = new ArrayList<Parent>();
		List l = parentservice.getAllParent();
		for(Object o : l){
			Object[] sz = (Object[]) o;
			Parent parent = new Parent();
			parent.setParentname(sz[1].toString());
			parentlist.add(parent);
		}
		
	}
	

}
