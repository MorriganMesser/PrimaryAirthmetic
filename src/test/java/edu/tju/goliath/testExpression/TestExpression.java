package edu.tju.goliath.testExpression;

import java.util.ArrayList;

import org.apache.log4j.Logger;
import org.junit.Test;

import edu.tju.goliath.dto.ExpResult;
import edu.tju.goliath.testDao.TestMybatis;
import edu.tju.goliath.util.Expression;

public class TestExpression {
	private static final Logger logger = Logger.getLogger(TestMybatis.class);
	
//	@Test
//	public void testExpression(){
//		
//		Expression expression = new Expression(10, 10);
//		expression.setFractionNumber(3);
//		expression.createExpression();
//		System.out.println(expression.getExpression());
//		System.out.println(expression.getResult());
//		
//	}
	
	@Test
	public void testExpression2(){
		
		Expression expression = new Expression(5, 5);
		expression.setFractionNumber(9);
		ArrayList<ExpResult> explist = new ArrayList<ExpResult>();
		
		for(int i = 0; i < 10; ++i) {
//			System.out.println(expression.getFractionScale());
			expression.createExpression("linear");
			ExpResult expresult =new ExpResult();
			expresult.setExpvalue(expression.getExpression());
			expresult.setExpresult(expression.getResult());
			
			explist.add(expresult);
		}
		
		System.out.println(explist.get(2));
	}

}
