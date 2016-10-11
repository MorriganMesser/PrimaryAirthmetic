package edu.tju.goliath.dto;

import edu.tju.goliath.util.Expression;

public class ExpResult {
	
	private Integer expid;
	private String expvalue;
	private String expresult;
	private String userresult;
	private String expuserresult;
	
	public String getExpuserresult() {
		return expuserresult;
	}
	public void setExpuserresult(String expuserresult) {
		this.expuserresult = expuserresult;
	}
	public Integer getExpid() {
		return expid;
	}
	public void setExpid(Integer expid) {
		this.expid = expid;
	}
	public String getUserresult() {
		return userresult;
	}
	public void setUserresult(String userresult) {
		this.userresult = userresult;
	}
	public String getExpvalue() {
		return expvalue;
	}
	public void setExpvalue(String expvalue) {
		this.expvalue = expvalue;
	}
	public String getExpresult() {
		return expresult;
	}
	public void setExpresult(String expresult) {
		this.expresult = expresult;
	}
	@Override
	public String toString() {
		return "ExpResult [expid=" + expid + ", expvalue=" + expvalue
				+ ", expresult=" + expresult + ", userresult=" + userresult
				+ ", expuserresult=" + expuserresult + "]";
	}
	
	
	

}
