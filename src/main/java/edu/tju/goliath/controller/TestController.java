package edu.tju.goliath.controller;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.tju.goliath.dto.ExpResult;
import edu.tju.goliath.entity.Grade;
import edu.tju.goliath.entity.Student;
import edu.tju.goliath.service.GradeServiceI;
import edu.tju.goliath.util.Expression;
import edu.tju.goliath.util.Split;

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
			//@RequestParam("testname") String testname,
			@RequestParam("testrank") String testrank,
			@RequestParam("expnum") String expnum,
			@RequestParam("testmethod") String testmethod){
		HttpSession session = request.getSession();
		int testrankINT = Integer.parseInt(testrank);
		int testmethodINT = Integer.parseInt(testmethod);
		int expnumINT = Integer.parseInt(expnum);
		Expression expression = new Expression(20, 10);
		expression.setFractionNumber(testrankINT + 1);
		expression.setGrade(testmethodINT);
		ArrayList<ExpResult> explist = new ArrayList<ExpResult>();

		Grade grade = new Grade();
		grade.setGrademodel("练习");
		switch (testrankINT) {
		case 1:
		{
			expression.setFractionRatio(0);
			expression.setScale(10);
			expression.setFractionScale(0);
			grade.setGraderank("一级-青铜");
		}
			
			break;
		case 2:
		{
			expression.setFractionRatio(10);
			expression.setScale(10);
			expression.setFractionScale(5);
			grade.setGraderank("二级-白银");
		}
			break;
		case 3:
		{
			expression.setFractionRatio(20);
			expression.setScale(10);
			expression.setFractionScale(5);
			grade.setGraderank("三级-黄金");
		}
			break;
		case 4:
		{
			expression.setFractionRatio(30);
			expression.setScale(40);
			expression.setFractionScale(10);
			grade.setGraderank("四级-白金");
		}
			break;
		case 5:
		{
			expression.setFractionRatio(40);
			expression.setScale(50);
			expression.setFractionScale(10);
			grade.setGraderank("五级-钻石");
		}
			break;
		case 6:
		{
			expression.setFractionRatio(40);
			expression.setScale(60);
			expression.setFractionScale(10);
			grade.setGraderank("六级-最强王者");
		}
			break;
		case 7:
		{
			expression.setFractionRatio(50);
			expression.setScale(90);
			expression.setFractionScale(10);
			grade.setGraderank("七级-超凡大师");
		}
			break;

		default:
		{
			expression.setFractionRatio(0);
			expression.setScale(10);
			expression.setFractionScale(0);
			grade.setGraderank("一级-青铜");
		}
			break;
		}
		
		
		for(int i = 0; i < expnumINT; ++i) {
			expression.createExpression();
			ExpResult expresult =new ExpResult();
			expresult.setExpid(i+1);
			expresult.setExpvalue(expression.getExpression());
			expresult.setExpresult(expression.getResult());
			explist.add(expresult);
		}
		
		Date stuididid = new Date();
		SimpleDateFormat sdfsdf =   new SimpleDateFormat( "MMddHHmmss" );
		String stuidididid = sdfsdf.format(stuididid);
		int numid = Integer.parseInt(stuidididid);
		grade.setGradeid(numid);
		grade.setGradenums(expnumINT);
		//grade.setGradename(testname);
		int grade_data_result=gradeservice.addGradeSelective(grade);
		//Grade grade_data = gradeservice.getGradeByName(testname);
		Grade grade_data = gradeservice.getGradeById(numid);
		
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
		Student stu = (Student)session.getAttribute("student");
		Grade grade_data = (Grade)session.getAttribute("grade");
		explistWithAnswer=(ArrayList<ExpResult>) session.getAttribute("explist");
		int grade_right_num=0;
		System.out.println(result);
//		String[] resultlist=result.split(",");
		ArrayList<String> resultlist = Split.split(result);
		for(int i =0;i<resultlist.size();i++){
			explistWithAnswer.get(i).setUserresult(resultlist.get(i));
			if(explistWithAnswer.get(i).getExpresult().equals(resultlist.get(i))){
				explistWithAnswer.get(i).setExpuserresult("正确");
				grade_right_num=grade_right_num+1;
			}else{
				explistWithAnswer.get(i).setExpuserresult("错误");
			}
		}
		int expnums = grade_data.getGradenums();
		double weight = 100 / expnums;
		grade_data.setGraderightnum(grade_right_num);
		grade_data.setGradeerrornum(expnums-grade_right_num);
		grade_data.setGrade(String.valueOf(grade_right_num*weight));
		grade_data.setGraderate(String.valueOf(grade_right_num / expnums));
		grade_data.setGradestuid(stu.getStuid());
		grade_data.setGradedate(new Date());
		gradeservice.updateGradeByIdSelective(grade_data);
		
		System.out.println(explistWithAnswer.get(0).getExpvalue());
		System.out.println(explistWithAnswer.get(0).getUserresult());
		System.out.println(explistWithAnswer.get(0).getExpresult());
		
		return "views/result_testcontent";
	}
}
