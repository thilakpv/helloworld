package org.kp.cloud.app.util;

public class NotFoundException extends RuntimeException {

	private static final long serialVersionUID = 2173921821231772739L;
	private String code;
	private String message;
	
	public NotFoundException(String code, String message) {
		this.code = code;
		this.message = message;
	}
	
	public String getCode() {
		return code;
	}
	
	public String getMessage() {
		return message;
	}
	
} // class NotFoundException