package com.epam.ordering.api.dto;
/**
 * 
 * @author vikash
 *
 */
public class Result {

	private String message;

	public Result() {
		super();
	}

	public Result(String message) {
		super();
		this.message = message;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	

}
