package edu.tju.goliath.util;
import java.util.Random;

public class ExpressionClass {
	private String expression;
	public ExpressionClass(){
		this.expression = "";
	}
	public void showExp(){
		System.out.println(this.expression);
	}
	public void createExp(int mag){  //表示生成表达式操作数的数量级
		int oprNum; //操作数的个数
		oprNum = new Random().nextInt()%5+1;
		int opr; //操作数，大小与数量级有关
		int operator; //运算符标识
		int brackets; //左括号个数
		
		for(int i=0;i<oprNum;++i){
			brackets = 0; 
			//十分之一的几率有括号
			operator = new Random().nextInt()%10;
			if(operator==0){
				this.expression+="(";
				brackets +=1;
			}
			
			opr = new Random().nextInt()%mag+1;
			this.expression+=opr;
			
			//如果是最后一个操作数，检查有没有左括号，有就添加右括号，没有就直接结束
			if(i == oprNum-1){
				for(int j=0;j<brackets;++j){
					this.expression+=")";
				}
				break;
			}
			
			//加入运算符，0-4代表+-*/)
			operator=new Random().nextInt()%6;
			switch(operator){
			case 0:
				this.expression+="+";
				break;
			case 1:
				this.expression+="-";
				break;
			case 2:
				this.expression+="*";
				break;
			case 3:
				this.expression+="/";
				break;
			case 4:
				if(brackets>0)
					this.expression+=")";
				else
					this.expression+="+";
				break;
			}
		}
		
	}
}

