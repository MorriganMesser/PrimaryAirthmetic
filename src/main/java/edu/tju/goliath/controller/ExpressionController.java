package edu.tju.goliath.controller;

import java.io.IOException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.google.gson.Gson;

import edu.tju.goliath.dto.ExpResult;
import edu.tju.goliath.entity.Grade;
import edu.tju.goliath.entity.Parent;
import edu.tju.goliath.entity.Student;
import edu.tju.goliath.service.GradeServiceI;
import edu.tju.goliath.service.StudentServiceI;
import edu.tju.goliath.util.Expression;
import edu.tju.goliath.util.Split;

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
		Date str = new Date();
		SimpleDateFormat sdf =   new SimpleDateFormat( "yyyy-MM-dd HH:mm:ss " );
		String end = sdf.format(str);
		//gradename=gradename+"++"+end;
		HttpSession session = request.getSession();
		Student stu = (Student)session.getAttribute("student");
		int graderankINT = Integer.parseInt(graderank);
		int expnumINT = Integer.parseInt(expnum);
		//设置考试难度等级
		Expression expression = new Expression(10, 10);
		Grade grade = new Grade();
		System.out.println("test------------------------------------------------------");
		switch (graderankINT) {
		case 1:
		{
			System.out.println("考试等级1");
			expression.setFractionNumber(2);
			expression.setGrade(3);
			grade.setGraderank("一级-青铜");
		}
			
			break;
		case 2:
		{
			System.out.println("考试等级2");
			expression.setFractionNumber(4);
			expression.setGrade(1);
			grade.setGraderank("二级-白银");
		}
			break;
		case 3:
		{
			System.out.println("考试等级3");
			expression.setFractionNumber(4);
			expression.setGrade(3);
			grade.setGraderank("三级-黄金");
		}
			break;
		case 4:
		{
			System.out.println("考试等级4");
			expression.setFractionNumber(6);
			expression.setGrade(0);
			grade.setGraderank("四级-白金");
		}
			break;
		case 5:
		{
			System.out.println("考试等级5");
			expression.setFractionNumber(6);
			expression.setGrade(3);
			grade.setGraderank("五级-钻石");
		}
			break;
		case 6:
		{
			System.out.println("考试等级6");
			expression.setFractionNumber(9);
			expression.setGrade(1);
			grade.setGraderank("六级-最强王者");
		}
			break;
		case 7:
		{
			System.out.println("考试等级7");
			expression.setFractionNumber(9);
			expression.setGrade(3);
			grade.setGraderank("七级-超凡大师");
		}
			break;

		default:
		{
			System.out.println("考试等级默认");
			expression.setFractionNumber(2);
			expression.setGrade(2);
			grade.setGraderank("一级-青铜");
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
		Date stuididid = new Date();
		SimpleDateFormat sdfsdf =   new SimpleDateFormat( "MMddHHmmss" );
		String stuidididid = sdfsdf.format(stuididid);
		int numid = Integer.parseInt(stuidididid);
		grade.setGradeid(numid);
		grade.setGrademodel("考试");
		grade.setGradenums(expnumINT);
		grade.setGradestuid(stu.getStuid());
		//grade.setGradename(gradename);
		int grade_data_result=gradeservice.addGradeSelective(grade);
		System.out.println("存储考试结果"+grade_data_result);
		//Grade grade_data = gradeservice.getGradeByName(gradename);
		Grade grade_data = gradeservice.getGradeById(numid);
		
		//session.setAttribute("grade", grade);
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
		System.out.println("test判决grade"+grade_data.toString());
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
		System.out.println("更新记录的ID为"+grade_data.getGradeid());
		grade_data.setGradeid(grade_data.getGradeid());
		grade_data.setGrade(String.valueOf(grade_right_num*weight));
		System.out.println("正确个数"+grade_right_num );
		System.out.println("总数"+expnums);
		double reghtrate=((double)grade_right_num / (double)expnums);
		String graderate = Double.toString(reghtrate);
		System.out.println("答题正确率"+reghtrate);
		System.out.println("答题正确率"+graderate);
		grade_data.setGraderate(graderate);
		grade_data.setGradestuid(stu.getStuid());
		grade_data.setGradedate(new Date());
		int judgegrade_result = gradeservice.updateGradeByIdSelective(grade_data);
		System.out.println("判卷存储结果"+judgegrade_result);
		System.out.println(explistWithAnswer.get(0).getExpvalue());
		System.out.println(explistWithAnswer.get(0).getUserresult());
		System.out.println(explistWithAnswer.get(0).getExpresult());
		
		return "views/result_examcontent";
	}
	
	@RequestMapping(value = "/valiGradeNames", method = RequestMethod.POST)
	public void valiGradeNames(HttpServletRequest request,HttpServletResponse response,
			@RequestParam("gradename") String gradename) throws IOException{
		System.out.println(gradename);
		
		if(null==gradeservice.getGradeByName(gradename)){
			System.out.println("考试名称可以使用");
			 response.getWriter().write("true");//此值jquery可以接收到  
		}else{
			System.out.println("考试名称已经存在");
			 response.getWriter().write("false");//此值jquery可以接收到  
		}
	}
	
	@RequestMapping(value = "/getGradeSelect", method = RequestMethod.POST)
	public String getGradeSelect(HttpServletRequest request,HttpServletResponse response,
			@RequestParam("starttime") String starttime,
			@RequestParam("endtime") String endtime,
			@RequestParam("graderank") String graderank,
			@RequestParam("grademodel") String grademodel) throws IOException{
		HttpSession session = request.getSession();
		Student stu = (Student)session.getAttribute("student");
		if((starttime=="")){
			starttime = "2000-01-01 12:00:00";
		}
		if((endtime=="")){
			Calendar now = Calendar.getInstance(); 
			now.setTime(new Date());
			now.add(Calendar.DATE, 1);  //加1天
			SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
			endtime = sdf.format(now.getTime());
		}
		Timestamp starttimeTIME = new Timestamp(System.currentTimeMillis());  
		Timestamp endtimeTIME = new Timestamp(System.currentTimeMillis());  
        String tsStr = starttime;   
        String tsStr2 = endtime; 
        try {   
        	starttimeTIME = Timestamp.valueOf(tsStr);
        	endtimeTIME = Timestamp.valueOf(tsStr2);
            System.out.println("时间"+starttime+"-------"+endtime);   
        } catch (Exception e) {   
            e.printStackTrace();   
        }  
		Map param = new HashMap();
		//param.put("gradestuid", 1);
		param.put("gradestuid", stu.getStuid());
		param.put("graderank", graderank);
		param.put("grademodel", grademodel);
		param.put("starttime", starttimeTIME);
		param.put("endtime", endtimeTIME);
		List<Grade> gradelist = gradeservice.getGradesByStuidAndRankAndModel(param);
		System.out.println(gradelist);
		session.setAttribute("gradelist", gradelist);
		return "views/historyscore";
		
	}
	
	@RequestMapping(value = "/getStuGrade2", method = RequestMethod.GET)
	public String getGrade2(HttpServletRequest request,HttpServletResponse response) throws IOException{
		HttpSession session = request.getSession();
		Student stu = (Student)session.getAttribute("student");
		List<Grade> gradelist = gradeservice.getGradesByStuid(stu.getStuid());
		System.out.println(gradelist);
		session.setAttribute("gradelist", gradelist);
		return "views/graphcontent";
		
	}
	
	@RequestMapping(value = "/getAllGrades", method = RequestMethod.POST)
	public String getGradeSelect(HttpServletRequest request,HttpServletResponse response) throws IOException{
		HttpSession session = request.getSession();
		Student stu = (Student)session.getAttribute("student");
		List<Grade> gradelist = gradeservice.getGradesByStuid(stu.getStuid());
		session.setAttribute("gradelist", gradelist);
		return "views/historyscore";
		
	}

}
