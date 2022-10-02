package com.cms.bean;

public class BatchAndCoursePlan {

	private int batchid;
	private int courseid;
	private int facultyid;
	
	private int numstud;
	private String topic;
	private String status;
	
	public BatchAndCoursePlan() {
		super();
	}

	public BatchAndCoursePlan(int batchid, int courseid, int facultyid, int numstud, String topic, String status) {
		super();
		this.batchid = batchid;
		this.courseid = courseid;
		this.facultyid = facultyid;
		this.numstud = numstud;
		this.topic = topic;
		this.status = status;
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

	public String getTopic() {
		return topic;
	}

	public void setTopic(String topic) {
		this.topic = topic;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "BatchAndCoursePlan [batchid=" + batchid + ", courseid=" + courseid + ", facultyid=" + facultyid
				+ ", numstud=" + numstud + ", topic=" + topic + ", status=" + status + "]";
	}
	
	
	
}
