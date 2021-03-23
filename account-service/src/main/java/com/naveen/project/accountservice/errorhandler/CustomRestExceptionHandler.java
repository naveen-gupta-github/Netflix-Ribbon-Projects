package com.naveen.project.accountservice.errorhandler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.naveen.project.accountservice.util.AppHelper;



@ControllerAdvice
public class CustomRestExceptionHandler extends ResponseEntityExceptionHandler {

	@Autowired
	AppHelper appHelper;

	@ExceptionHandler({ AccountServiceException.class })
	public ResponseEntity<Object> handleAccountServiceException(final AccountServiceException ex, final WebRequest request) {
		logger.error(ex.getClass().getName());
		ApiError apiError = new ApiError();
		if ("DB_ERROR".equals(ex.getErrorType())) {
			apiError = new ApiError(HttpStatus.BAD_REQUEST,
					appHelper.getMessagePropValue(ex.getCode(), ex.getLanguage()), ex.getCode(), ex.getErrors());
		} 
		return new ResponseEntity<Object>(apiError, new HttpHeaders(), apiError.getStatus());
	}
	

	
}