package com.cms.exceptions;

public class FacultyException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FacultyException() {
		
	}
	
	public FacultyException(String message) {
		super(message);
		System.out.println(message);
	}
}
