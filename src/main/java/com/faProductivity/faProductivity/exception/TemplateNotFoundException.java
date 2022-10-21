package com.faProductivity.faProductivity.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;

@Getter
public class TemplateNotFoundException extends RuntimeException {
	private String message;
	public TemplateNotFoundException(String message) {
		super(message);
		this.message=message;
	}
	

}
