package edu.tju.goliath.util;
import java.lang.Math;

public class Fraction {
    private int numerator;
    private int denominator;
    
    /*
     * 求最大公约数
     */
    private int gcd(int x, int y) {
        if(x % y == 0) {
            return y;
        }
        else {
            return this.gcd(y, x % y);
        }
    }
    
    /*
     * 约分
     */
    private void reduce() {
        if(this.denominator == 0) {
            this.numerator = 0;
        }
        else if(this.numerator == 0) {
            this.denominator = 1;
        }
        else {
            int _gcd = this.gcd(Math.abs(numerator), Math.abs(denominator));
            this.numerator /= _gcd;
            this.denominator /= _gcd;
        }
    }

    /*
     * 构造函数，初始化分数时，让分子决定分数的正负
     */
    public Fraction(int nume, int deno) {
    	if(deno < 0) {
    		deno = -deno;
    		nume = - nume;
    	}
        this.numerator = nume;
        this.denominator = deno;
        this.reduce();
    }
    /*
     * 构造函数，初始化整数
     */
    public Fraction(int nume) {
        this(nume, 1);
    }
    /*
     * 拷贝构造函数
     */
    public Fraction(Fraction f) {
    	this(f.numerator, f.denominator);
    }
    /*
     * 默认构造函数，初始化为整数0
     */
    public Fraction() {
        this(0);
    }
    
    public int getNumerator() {
        return this.numerator;
    }
    public int getDenominator() {
        return this.denominator;
    }
    
    /*
     * 分数取负
     */
    public Fraction negative() {
        this.numerator = -this.numerator;
        return this;
    }

    /*
     * 加法
     */
    public Fraction add(Fraction f) {
        this.numerator = this.numerator * f.denominator + this.denominator * f.numerator;
        this.denominator = this.denominator * f.denominator;
        this.reduce();
        return this;
    }
    /*
     * 减法
     */
    public Fraction sub(Fraction f) {
    	Fraction fr = new Fraction(f);
        fr.negative();
        this.add(fr);
        return this;
    }
    /*
     * 乘法
     */
    public Fraction mul(Fraction f) {
    	this.numerator *= f.numerator;
    	this.denominator *= f.denominator;
    	this.reduce();
    	return this;
    }
    /*
     * 除法
     */
    public Fraction div(Fraction f) {
    	this.numerator *= f.denominator;
    	this.denominator *= f.numerator;
    	this.reduce();
    	return this;
    }
    /*
     * 判断相等
     */
    public boolean equal(Fraction f) {
    	return (this.numerator == f.numerator && this.denominator == f.denominator);
    }
    /*
     * 判断是否为0
     */
    public boolean isZero() {
    	return this.denominator != 0 && this.numerator == 0;
    }
    /*
     * 判断是否为无效分数
     */
    public boolean isNan() {
    	return this.denominator == 0;
    }
    /*
     * 判断是否为负数
     */
    public boolean isNegative() {
    	return this.numerator < 0;
    }
    /*
     * 将数字转换为字符串型
     */
    public String toString() {
    	String result = new String();
    	if(this.denominator == 0) {
    		result = "NAN";
    	}
    	else if(this.denominator == 1) {
    		result = String.valueOf(this.numerator);
    	}
    	else {
    		result = String.valueOf(this.numerator) + "/" + String.valueOf(this.denominator);
    	}
    	return result;
    }
}