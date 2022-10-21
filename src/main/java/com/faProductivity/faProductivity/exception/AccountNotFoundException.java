package com.faProductivity.faProductivity.exception;


import lombok.Getter;

@Getter
public class AccountNotFoundException extends RuntimeException {
	private String message;
	public AccountNotFoundException(String message) {
		super(message);
		this.message=message;
	}
	

}
