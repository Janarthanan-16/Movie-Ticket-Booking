package com.project.movieticketbooking.exception;

public class AdminEmailDuplicateException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String message;

	public AdminEmailDuplicateException(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

}
