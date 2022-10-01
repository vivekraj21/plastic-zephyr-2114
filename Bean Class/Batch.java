package com.cms.bean;

public class Batch {

	private int batchid;
	private int courseid;
	private int facultyid;
	private int numstud;
	private long startdate;
	private int duration;
	
	

	public Batch(int batchid, int courseid, int facultyid, int numstud, long startdate, int duration) {
		super();
		this.batchid = batchid;
		this.courseid = courseid;
		this.facultyid = facultyid;
		this.numstud = numstud;
		this.startdate = startdate;
		this.duration = duration;
	}

	public int getBatchid() {
		return batchid;
	}

	public void setBatchid(int batchid) {
		this.batchid = batchid;
	}

	public int getCourseid() {
		return courseid;
	}

	public void setCourseid(int courseid) {
		this.courseid = courseid;
	}

	public int getFacultyid() {
		return facultyid;
	}

	public void setFacultyid(int facultyid) {
		this.facultyid = facultyid;
	}

	public int getNumstud() {
		return numstud;
	}

	public void setNumstud(int numstud) {
		this.numstud = numstud;
	}

	public long getStartdate() {
		return startdate;
	}

	public void setStartdate(long startdate) {
		this.startdate = startdate;
	}

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	
	
}

