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
import edu.tju.goliath.entity.Grade;
import edu.tju.goliath.service.GradeServiceI;
import edu.tju.goliath.util.Expression;

@Controller
public class TestController {
	
	private GradeServiceI gradeservice;
	
	
	public GradeServiceI getGradeservice() {
		return gradeservice;
	}

	@Autowired
	public void setGradeservice(GradeServiceI gradeservice) {
		this.gradeservice = gradeservice;
	}

	@RequestMapping(value = "/testExp", method = RequestMethod.GET)
	public String testExp(HttpServletRequest request,
			@RequestParam("testname") String testname,
			@RequestParam("testrank") String testrank,
			@RequestParam("expnum") String expnum,
			@RequestParam("testmethod") String testmethod){
		HttpSession session = request.getSession();
		int testrankINT = Integer.parseInt(testrank);
		int testmethodINT = Integer.parseInt(testmethod);
		int expnumINT = Integer.parseInt(expnum);
		Expression expression = new Expression(10, 10);
		expression.setFractionNumber(testrankINT);
		expression.setGrade(testmethodINT);
		ArrayList<ExpResult> explist = new ArrayList<ExpResult>();
		
		for(int i = 0; i < 10; ++i) {
			expression.createExpression();
			ExpResult expresult =new ExpResult();
			expresult.setExpid(i+1);
			expresult.setExpvalue(expression.getExpression());
			expresult.setExpresult(expression.getResult());
			explist.add(expresult);
		}
		Grade grade = new Grade();
		grade.setGrademodel("练习");
		grade.setGradenums(expnumINT);
		grade.setGradename(testname);
		grade.setGraderank(testrank);
		int grade_data_result=gradeservice.addGradeSelective(grade);
		Grade grade_data = gradeservice.getGradeByName(testname);
		
		session.setAttribute("grade", grade_data);
		session.setAttribute("explist", explist);
		
		session.setAttribute("explist", explist);
		return "views/testcontent";
		
	}
	
	//judgeTestExp.do
	@RequestMapping(value = "/judgeTestExp", method = RequestMethod.GET)
	public String judgeTestExp(HttpServletRequest request,	
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
		
		return "views/result_testcontent";
	}
}
