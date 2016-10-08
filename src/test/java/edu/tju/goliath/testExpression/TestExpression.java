package edu.tju.goliath.testExpression;

import org.apache.log4j.Logger;
import org.junit.Test;

import edu.tju.goliath.testDao.TestMybatis;
import edu.tju.goliath.util.Expression;

public class TestExpression {
	private static final Logger logger = Logger.getLogger(TestMybatis.class);
	
	@Test
	public void testExpression(){
		
		Expression expression = new Expression(10, 10);
		expression.setFractionNumber(3);
		expression.createExpression();
		System.out.println(expression.getExpression());
		System.out.println(expression.getResult());
		
	}

}
