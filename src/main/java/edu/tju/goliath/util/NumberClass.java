package edu.tju.goliath.util;

public class NumberClass {
	private int numerator;
	private int denominator;
	
	public NumberClass(int n,int d){
		this.numerator = n;
		this.denominator = d;
	}
	public NumberClass(int n){
		this(n,0);
	}
	public NumberClass(){
		this(1,0);
	}
	
	public int getNumertr(){
		return this.numerator;
	}
	public int getDenomintr(){
		return this.denominator;
	}
	
	
	//对分数进行约分
	private void reductionFrct(NumberClass fraction){
		int i;
		for(i=2;i<fraction.numerator+1||i<fraction.denominator+1;++i){
			if(fraction.numerator%i==0&&fraction.denominator%i==0){
				fraction.numerator/=i;
				fraction.denominator/=i;
			}
		}
		return;
	}
	//是否是分数
	public boolean isFrct(){
		reductionFrct(this);
		if(this.denominator==1){
			return false;
		}
		return true;
	}
	//加法实现
	public NumberClass add(NumberClass operand){
		this.numerator*= operand.denominator;
		operand.numerator*= this.denominator;
		this.numerator+=operand.numerator;
		this.denominator*=operand.denominator;
		reductionFrct(this);
		return this;
	}
	//减法实现
	public NumberClass sub(NumberClass operand){
		this.numerator*= operand.denominator;
		operand.numerator*= this.denominator;
		this.numerator-=operand.numerator;
		this.denominator*=operand.denominator;
		reductionFrct(this);
		return this;
	}
	//乘法实现
	public NumberClass mul(NumberClass operand){
		this.numerator*=operand.numerator;
		this.denominator*=operand.denominator;
		reductionFrct(this);
		return this;
	}
	//除法实现
	public NumberClass div(NumberClass operand){
		this.numerator*=operand.denominator;
		this.denominator*=operand.numerator;
		reductionFrct(this);
		return this;
	}
}

