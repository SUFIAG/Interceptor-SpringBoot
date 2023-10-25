package com.netsurfingzone.error;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

@ControllerAdvice
public class GlobalErrorHandler {
	@ExceptionHandler(UserNotAuthorizedException.class)
	@ResponseBody
	public ResponseError handleCustomException(UserNotAuthorizedException ex) {
		ResponseError responseError = new ResponseError();
		responseError.setErrorMessage(ex.getMessage());
		responseError.setStatusCode(HttpStatus.UNAUTHORIZED.value());
		return responseError;

	}
}
