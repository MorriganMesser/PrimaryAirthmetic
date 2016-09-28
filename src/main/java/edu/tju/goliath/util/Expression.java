package edu.tju.goliath.util;
import java.util.Random;
import java.util.Calendar;
import java.util.ArrayList;

public class Expression {
	private int fractionRatio; // 分数出现的比率，取值范围[0, 100]
	private int scale; // 问题的规模（表达式中的数字不超过scale）
	private int grade; // 表达式等级，取值范围[0, 2]，0级只有加法，2级包含四则运算
	private int fractionNumber; // 表达式中数字出现的次数，取值范围[2, 10]
	private String expr;
	private String result;
	private Random random;
	
	/*
	 * 产生随机数，用于产生随机操作符
	 */
	private int randomOperator() {
		int op = random.nextInt(grade + 1);
		return op;
	}
	/*
	 * 随机产生整数或分数，分数出现的比率由fractionRatio决定
	 */
	private Fraction randomFraction() {
		int nume = random.nextInt(scale) + 1;
		int deno = 1;
		if(random.nextInt(100) < fractionRatio) {
			deno = random.nextInt(scale - 1) + 2;
		}
		return new Fraction(nume, deno);
	}
	
	/*
	 * 构造函数，初始化构造表达式的规则
	 */
	public Expression(int fr, int s, int g) {
		this.fractionRatio = fr;
		this.scale = s;
		this.grade = g;
		this.fractionNumber = 2;
		this.expr = new String();
		this.result = new String();
		this.random = new Random(Calendar.getInstance().get(Calendar.MILLISECOND));
	}
	/*
	 * 构造函数，默认等级为2，即四则运算
	 */
	public Expression(int fr, int s) {
		this(fr, s, 2);
	}
	/*
	 * 构造函数，默认规模为100，即100以内的运算
	 */
	public Expression(int fr) {
		this(fr,  100);
	}
	/*
	 * 构造函数，默认分数出现比率为50%
	 */
	public Expression() {
		this(50);
	}
	
	/*
	 * 设定分数出现比率
	 */
	public void setFractionRatio(int fr) {
		assert(fr >=0 && fr <= 100);
		this.fractionRatio = fr;
	}
	/*
	 * 设定计算规模
	 */
	public void setScale(int s) {
		assert(s >= 10 && s <= 10000);
		this.scale = s;
	}
	/*
	 * 设定表达式等级
	 */
	public void setGrade(int g) {
		assert(g >= 0 && g <= 2);
		this.grade = g;
	}
	/*
	 * 设定表达式中操作数的个数
	 */
	public void setFractionNumber(int fn) {
		assert(fn > 2 && fn < 10);
		this.fractionNumber = fn;
	}
	/*
	 * 得到分数比率、规模、表达式等级、操作数个数
	 */
	public int getFractionRatio() {
		return this.fractionRatio;
	}
	public int getScale() {
		return this.scale;
	}
	public int getGrade() {
		return this.grade;
	}
	public int getFractionNumber() {
		return this.fractionNumber;
	}
	
	/*
	 * 创建表达式
	 */
	public void createExpression() {
		this.expr = new String();
		this.result = new String();
		ArrayList<Fraction> list = new ArrayList<Fraction>();
		
		Fraction answer = randomFraction();
		expr += answer.toString();
		int curFracNum = 1, curOpNum = 0;
		int lastOp = 2;
		while(curFracNum < fractionNumber || curOpNum < fractionNumber - 1) {
			if(curFracNum <= curOpNum + 1) {
				list.add(randomFraction());
				curFracNum += 1;
			}
			else{
				boolean flag = random.nextBoolean(); // 若为真，则本次生成数字，否则生成操作符，除非数字已经生成完
				if(flag && curFracNum < fractionNumber) {
					list.add(randomFraction()); // 生成数字，不用多说
					curFracNum += 1;
				}
				else {
					int curOp = randomOperator(); // 本次产生的操作符
					
					// 判断是否需要加括号
					if(curOp > lastOp || (curOp == 1 && lastOp == 1)) {
						expr = "(" + expr + ")";
					}
					lastOp = curOp;
					String op = new String();
					
					// 更新表达式和运算结果
					Fraction tmp = list.remove(list.size() - 1);
					if(curOp == 0) {
						op = " + ";
						answer = new Fraction(tmp).add(answer);
					}
					else if(curOp == 1) {
						op = " - ";
						answer = new Fraction(tmp).sub(answer);
					}
					else if(curOp == 2) {
						op = " * ";
						answer = new Fraction(tmp).mul(answer);
					}
					else {
						assert(false);
					}
					expr = tmp.toString() + op + expr;
					curOpNum += 1;
				}
			}
		}
		this.result = answer.toString();  //更新答案
	}
	/*
	 * 得到表达式
	 */
	public String getExpression() {
		return this.expr;
	}
	/*
	 * 得到答案
	 */
	public String getResult() {
		return this.result;
	}
}