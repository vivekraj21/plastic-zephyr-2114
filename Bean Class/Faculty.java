package com.cms.bean;

public class Faculty {

	private int facultyid;
	private String facultyname;
	private String facultyadd;
	private String mobile;
	private String email;
	private String username;
	private String password;
	
	public Faculty() {
	}

	public Faculty(int facultyid, String facultyname, String facultyadd, String mobile, String email, String username,
			String password) {
		super();
		this.facultyid = facultyid;
		this.facultyname = facultyname;
		this.facultyadd = facultyadd;
		this.mobile = mobile;
		this.email = email;
		this.username = username;
		this.password = password;
	}

	public int getFacultyid() {
		return facultyid;
	}

	public void setFacultyid(int facultyid) {
		this.facultyid = facultyid;
	}

	public String getFacultyname() {
		return facultyname;
	}

	public void setFacultyname(String facultyname) {
		this.facultyname = facultyname;
	}

	public String getFacultyadd() {
		return facultyadd;
	}

	public void setFacultyadd(String facultyadd) {
		this.facultyadd = facultyadd;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}
	
}
