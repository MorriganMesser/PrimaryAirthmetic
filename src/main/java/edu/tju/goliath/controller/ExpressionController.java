package edu.tju.goliath.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import edu.tju.goliath.dto.ExpResult;
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
		
		ArrayList<ExpResult> explist = new ArrayList<ExpResult>();
		
		for(int i = 0; i < 10; ++i) {
			expression.createExpression();
			ExpResult expresult =new ExpResult();
			expresult.setExpvalue(expression.getExpression());
			expresult.setExpresult(expression.getResult());
		}
		
		
		session.setAttribute("explist", explist);
		
		return "views/examcontent";
	}

}
