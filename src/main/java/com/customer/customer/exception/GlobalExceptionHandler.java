package com.customer.customer.exception;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

	@ExceptionHandler(value = CustomerAlreadyExistsException.class)
	public ResponseEntity<String> CustomerAlreadyExistsException(CustomerAlreadyExistsException customerAlreadyExistsException) {

		return new ResponseEntity<String>("user already exists in db. Please try again.", HttpStatus.CONFLICT);
	}

}
