package edu.tju.goliath.util;
public class Test {
	public static void main(String args[]){
		Expression expression = new Expression(10, 10);
		expression.setFractionNumber(3);
		for(int i = 0; i < 10; ++i) {
		expression.createExpression();
		System.out.println(expression.getExpression());
		System.out.println(expression.getResult());
		}
	}
}
