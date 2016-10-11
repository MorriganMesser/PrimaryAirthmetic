package edu.tju.goliath.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import edu.tju.goliath.dto.ExpResult;
import edu.tju.goliath.util.Expression;

@Controller
public class TestController {
	
	@RequestMapping(value = "/testExp", method = RequestMethod.GET)
	public String testExp(HttpServletRequest request,
			@RequestParam("rank") String rank,@RequestParam("rankmethod") String rankmethod){
		HttpSession session = request.getSession();
		int rankINT = Integer.parseInt(rank);
		int rankmethodINT = Integer.parseInt(rankmethod);
		Expression expression = new Expression(10, 10);
		expression.setFractionNumber(rankINT);
		expression.setGrade(rankmethodINT);
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
