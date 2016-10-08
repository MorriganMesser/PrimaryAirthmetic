package edu.tju.goliath.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.tju.goliath.entity.Student;
import edu.tju.goliath.util.Expression;

@Controller
public class ExpressionController {
	//未完，待续
	
	@RequestMapping(value = "/getExpressions", method = RequestMethod.GET)
	public String getExpressions(HttpServletRequest request){
		
		HttpSession session = request.getSession();
		Student stu = (Student)session.getAttribute("student");
		
		Expression expression = new Expression(10, 10);
		expression.setFractionNumber(3);
		expression.createExpression();
		
		session.setAttribute("expression", expression.getExpression());
		System.out.println(expression.getExpression());
		System.out.println(expression.getResult());
		
		return "views/examcontent";
	}

}
