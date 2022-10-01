package com.cms.bean;

public class Course {

	private int courseid;
	private String coursename;
	private int fee;
	private String coursedesc;
	
	public Course() {
		super();
	}

	public Course(int courseid, String coursename, int fee, String coursedesc) {
		super();
		this.courseid = courseid;
		this.coursename = coursename;
		this.fee = fee;
		this.coursedesc = coursedesc;
	}

	public int getCourseid() {
		return courseid;
	}

	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	public int getFee() {
		return fee;
	}

	public void setFee(int fee) {
		this.fee = fee;
	}

	public String getCoursedesc() {
		return coursedesc;
	}

	public void setCoursedesc(String coursedesc) {
		this.coursedesc = coursedesc;
	}
	
	
}
