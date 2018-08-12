package com.ecommerce.customException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ApiExceptionhander {
	
	@ExceptionHandler(ConstraintVoilationException.class)
	public ResponseEntity<ErrorResponse> handle(ConstraintVoilationException e){
		ErrorResponse errors = new ErrorResponse();
		
		for(ConstraintVoilation voilation : e.getConstrainVoilation()) {
			ErrorItem error = new ErrorItem();
			error.setCode(voilation.getMessageTemplate());
			error.setMessage(voilation.getMessage());
			errors.addError(error);
		}
		return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(ResourceNotFoundException.class)
	public ResponseEntity<ErrorItem> handle(ResourceNotFoundException e) {
		ErrorItem error = new ErrorItem();
		error.setMessage(e.getMessage());
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}

}
