package com.naveen.project.accountservice.errorhandler;

import java.util.List;

public class AccountServiceException extends Exception {
	
	private static final long serialVersionUID = 1L;



	private String language = "";
	private String code;
	private String errorType;
	private List<String> errors;

	public AccountServiceException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AccountServiceException(String code, List<String> errors, String language, String errorType) {

		this.language = language;
		this.code = code;
		this.errors = errors;
		this.errorType = errorType;

	}

	public String getLanguage() {
		return language;
	}

	public void setLanguage(String language) {
		this.language = language;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public List<String> getErrors() {
		return errors;
	}

	public void setErrors(List<String> errors) {
		this.errors = errors;
	}

	public String getErrorType() {
		return errorType;
	}

	public void setErrorType(String errorType) {
		this.errorType = errorType;
	}

}
