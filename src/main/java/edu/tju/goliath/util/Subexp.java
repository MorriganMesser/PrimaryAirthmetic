package edu.tju.goliath.util;

public class Subexp {
	/*
	 * public class Subexp:
	 * 用于辅助生成表达式。
	 */
	
	/*
	 * expr 表示该子表达式的内容。
	 */
	private String expr;
	
	/*
	 * result 表示该子表达式的运算结果。
	 */
	private Fraction result;
	
	/*
	 * lastOp 表示该子表达式计算过程中最后一次运算的操作符，
	 * 分别使用0,1,2,3,4表示加、减、乘、除、无。
	 */
	private int lastOp;
	
	public Subexp(String expr, Fraction result, int lastOp) {
		this.expr = expr;
		this.result = result;
		this.lastOp = lastOp;
	}
	public Subexp() {
		this(new String(), new Fraction(), 4);
	}
	
	public String getExpr() {
		return this.expr;
	}
	public Fraction getResult() {
		return this.result;
	}
	public int getLastOp() {
		return this.lastOp;
	}
}
