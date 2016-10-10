package edu.tju.goliath.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.tju.goliath.dto.ExpResult;
import edu.tju.goliath.entity.Student;
import edu.tju.goliath.service.GradeServiceI;
import edu.tju.goliath.util.Expression;

@Controller
public class ExpressionController {
	
	private GradeServiceI gradeservice;
	
	
	public GradeServiceI getGradeservice() {
		return gradeservice;
	}

	@Autowired
	public void setGradeservice(GradeServiceI gradeservice) {
		this.gradeservice = gradeservice;
	}

	@RequestMapping(value = "/getExpressions", method = RequestMethod.GET)
	public String getExpressions(HttpServletRequest request){
		
		//设置考试难度等级
		
		HttpSession session = request.getSession();
		Student stu = (Student)session.getAttribute("student");
		
		Expression expression = new Expression(10, 10);
		expression.setFractionNumber(2);
		expression.setGrade(2);
		ArrayList<ExpResult> explist = new ArrayList<ExpResult>();
		
		for(int i = 0; i < 10; ++i) {
			expression.createExpression();
			ExpResult expresult =new ExpResult();
			expresult.setExpid(i+1);
			expresult.setExpvalue(expression.getExpression());
			expresult.setExpresult(expression.getResult());
			
			explist.add(expresult);
			
		}
		
		
		session.setAttribute("explist", explist);
		
		return "views/examcontent";
	}
	
	@RequestMapping(value = "/judgeExpressions", method = RequestMethod.GET)
	public String judgeExpressions(HttpServletRequest request,	
			@RequestParam("result") String result){
		ArrayList<ExpResult> explistWithAnswer = new ArrayList<ExpResult>();
		HttpSession session = request.getSession();
		explistWithAnswer=(ArrayList<ExpResult>) session.getAttribute("explist");
		int grade=0;
		System.out.println(result);
		String[] resultlist=result.split(",");
		for(int i =0;i<10;i++){
			explistWithAnswer.get(i).setUserresult(resultlist[i]);
			if(explistWithAnswer.get(i).getExpresult().equals(resultlist[i])){
				explistWithAnswer.get(i).setExpuserresult("正确");
				grade=grade+1;
			}else{
				explistWithAnswer.get(i).setExpuserresult("错误");
			}
		}
		session.setAttribute("grade", grade);
		System.out.println(explistWithAnswer.get(0).getExpvalue());
		System.out.println(explistWithAnswer.get(0).getUserresult());
		System.out.println(explistWithAnswer.get(0).getExpresult());
		
		return "views/result_examcontent";
	}

}
