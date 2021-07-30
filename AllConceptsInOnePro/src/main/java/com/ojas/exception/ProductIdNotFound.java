package com.ojas.exception;

public class ProductIdNotFound extends RuntimeException {

	private String message;

	public ProductIdNotFound(String message) {
		super();
		this.message = message;
	}

	public ProductIdNotFound() {
		super();
	}
	
}
