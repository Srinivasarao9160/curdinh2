package com.ojas.exception;

public class ProductAlreadyExit extends RuntimeException{
	
	private String message;

	public ProductAlreadyExit(String message) {
		super();
		this.message = message;
	}

	public ProductAlreadyExit() {
		super();
	}
	
	

}
