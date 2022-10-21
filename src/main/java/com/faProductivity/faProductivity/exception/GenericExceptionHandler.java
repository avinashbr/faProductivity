package com.faProductivity.faProductivity.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@ControllerAdvice
@Slf4j
public class GenericExceptionHandler {


	@ExceptionHandler(TemplateNotFoundException.class)
	public final ResponseEntity<Object> handleTemplateNotFoundException(TemplateNotFoundException ex) throws Exception {
		log.error(ex.getMessage());
		return new ResponseEntity(ex.getMessage(),HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler(Exception.class)
	public final ResponseEntity<Object> handleException(Exception ex) throws Exception {		
		log.error(ex.getMessage());
		return new ResponseEntity("Unexpected error occured. pleaes contact Admin",HttpStatus.INTERNAL_SERVER_ERROR);
	}
	
}
