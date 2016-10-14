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
import edu.tju.goliath.service.StudentServiceI;
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
	
	private StudentServiceI stuservice;
	

	public StudentServiceI getStuservice() {
		return stuservice;
	}

	@Autowired
	public void setStuservice(StudentServiceI stuservice) {
		this.stuservice = stuservice;
	}

	@RequestMapping(value = "/getExpressions", method = RequestMethod.GET)
	public String getExpressions(HttpServletRequest request,
			@RequestParam("graderank") String graderank,
			@RequestParam("gradename") String gradename,
			@RequestParam("expnum") String expnum){
		
		HttpSession session = request.getSession();
		Student stu = (Student)session.getAttribute("student");
		int graderankINT = Integer.parseInt(graderank);
		int expnumINT = Integer.parseInt(expnum);
		//设置考试难度等级
		Expression expression = new Expression(10, 10);
		switch (graderankINT) {
		case 1:
		{
			System.out.println("考试等级1");
			expression.setFractionNumber(2);
			expression.setGrade(3);
		}
			
			break;
		case 2:
		{
			System.out.println("考试等级2");
			expression.setFractionNumber(4);
			expression.setGrade(1);
		}
			break;
		case 3:
		{
			System.out.println("考试等级3");
			expression.setFractionNumber(4);
			expression.setGrade(3);
		}
			break;
		case 4:
		{
			System.out.println("考试等级4");
			expression.setFractionNumber(6);
			expression.setGrade(0);
		}
			break;
		case 5:
		{
			System.out.println("考试等级5");
			expression.setFractionNumber(6);
			expression.setGrade(3);
		}
			break;
		case 6:
		{
			System.out.println("考试等级6");
			expression.setFractionNumber(9);
			expression.setGrade(1);
		}
			break;
		case 7:
		{
			System.out.println("考试等级7");
			expression.setFractionNumber(9);
			expression.setGrade(3);
		}
			break;

		default:
		{
			System.out.println("考试等级默认");
			expression.setFractionNumber(2);
			expression.setGrade(2);
		}
			break;
		}
		
		ArrayList<ExpResult> explist = new ArrayList<ExpResult>();
		
		for(int i = 0; i < expnumINT; ++i) {
			expression.createExpression();
			ExpResult expresult =new ExpResult();
			expresult.setExpid(i+1);
			expresult.setExpvalue(expression.getExpression());
			expresult.setExpresult(expression.getResult());
			explist.add(expresult);
		}
		Grade grade = new Grade();
		grade.setGrademodel("考试");
		grade.setGradenums(expnumINT);
		grade.setGradename(gradename);
		grade.setGraderank(graderank);
		int grade_data_result=gradeservice.addGradeSelective(grade);
		Grade grade_data = gradeservice.getGradeByName(gradename);
		
		session.setAttribute("grade", grade_data);
		session.setAttribute("explist", explist);
		return "views/examcontent";
	}
	
	@RequestMapping(value = "/judgeExpressions", method = RequestMethod.GET)
	public String judgeExpressions(HttpServletRequest request,	
			@RequestParam("result") String result){
		ArrayList<ExpResult> explistWithAnswer = new ArrayList<ExpResult>();
		HttpSession session = request.getSession();
		Student stu = (Student)session.getAttribute("student");
		Grade grade_data = (Grade)session.getAttribute("grade");
		explistWithAnswer=(ArrayList<ExpResult>) session.getAttribute("explist");
		int grade_right_num=0;
		System.out.println(result);
		String[] resultlist=result.split(",");
		for(int i =0;i<10;i++){
			explistWithAnswer.get(i).setUserresult(resultlist[i]);
			if(explistWithAnswer.get(i).getExpresult().equals(resultlist[i])){
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
		
		return "views/result_examcontent";
	}

}
