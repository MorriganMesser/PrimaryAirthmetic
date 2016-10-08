package edu.tju.goliath.util;

public class Subexp {
	/*
	 * public class Subexp:
	 * 用于辅助生成表达式。
	 */
	private String expr;
	private Fraction result;
	
	public Subexp(String expr, Fraction result) {
		this.expr = expr;
		this.result = result;
	}
	public Subexp() {
		this(new String(), new Fraction());
	}
	
	public String getExpr() {
		return this.expr;
	}
	public Fraction getResult() {
		return this.result;
	}
}
