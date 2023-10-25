package com.netsurfingzone.error;

public class UserNotAuthorizedException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	String message;

	public UserNotAuthorizedException() {
		super();
	}

	public UserNotAuthorizedException(String message) {
		super(message);
		this.message = message;
	}
}
