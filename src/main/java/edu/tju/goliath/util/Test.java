package edu.tju.goliath.util;
public class Test {
	public static void main(String args[]){
		Expression expression = new Expression(10, 100);
		expression.setFractionNumber(5);
		expression.setFractionScale(5);
		expression.setGrade(3);
		for(int i = 0; i < 10; ++i) {
		expression.createExpression("linear");
		System.out.print(expression.getExpression() + " = ");
		System.out.println(expression.getResult());
		}
	}
}
