package edu.tju.goliath.util;
import java.lang.Math;

public class Fraction {
    private int numerator;
    private int denominator;

    private int gcd(int x, int y) {
        if(x % y == 0) {
            return y;
        }
        else {
            return this.gcd(y, x % y);
        }
    }
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

    public Fraction(int nume, int deno) {
    	if(deno < 0) {
    		deno = -deno;
    		nume = - nume;
    	}
        this.numerator = nume;
        this.denominator = deno;
        this.reduce();
    }

    public Fraction(int nume) {
        this(nume, 1);
    }
    public Fraction(Fraction f) {
    	this(f.numerator, f.denominator);
    }

    public Fraction() {
        this(0);
    }
    
    public int getNumerator() {
        return this.numerator;
    }
    public int getDenominator() {
        return this.denominator;
    }

    public Fraction negative() {
        this.numerator = -this.numerator;
        return this;
    }

    public Fraction add(Fraction f) {
        this.numerator = this.numerator * f.denominator + this.denominator * f.numerator;
        this.denominator = this.denominator * f.denominator;
        this.reduce();
        return this;
    }
    public Fraction sub(Fraction f) {
    	Fraction fr = new Fraction(f);
        fr.negative();
        this.add(fr);
        return this;
    }
    public Fraction mul(Fraction f) {
    	this.numerator *= f.numerator;
    	this.denominator *= f.denominator;
    	this.reduce();
    	return this;
    }
    public Fraction div(Fraction f) {
    	this.numerator *= f.denominator;
    	this.denominator *= f.numerator;
    	this.reduce();
    	return this;
    }
    public boolean equal(Fraction f) {
    	return (this.numerator == f.numerator && this.denominator == f.denominator);
    }
    public boolean isZero() {
    	return this.denominator != 0 && this.numerator == 0;
    }
    public boolean isNan() {
    	return this.denominator == 0;
    }
    public boolean isNegative() {
    	return this.numerator < 0;
    }
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