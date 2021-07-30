package com.ojas.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
	
	@ExceptionHandler(ProductIdNotFound.class)
	public ResponseEntity<String> productNotFound(ProductIdNotFound productIdNotFound ) {
		return new ResponseEntity<String>("please entervalid id ", HttpStatus.BAD_REQUEST);
		
	}
	@ExceptionHandler(ProductAlreadyExit.class)
	public ResponseEntity<String> ProductAlreadyExists(ProductAlreadyExit productAlreadyExit ) {
		return new ResponseEntity<String>("Product is already exists ", HttpStatus.BAD_REQUEST);
		
	}
	@ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> databaseConnectionFailsException(Exception exception) {
        return new ResponseEntity<>("method is not correct", HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
