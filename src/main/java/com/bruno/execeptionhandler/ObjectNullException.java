package com.bruno.execeptionhandler;

public class ObjectNullException extends RuntimeException {

	private static final long serialVersionUID = 7834873907724860678L;
	
	
	public ObjectNullException(String message) {		
		super(message);
	}
}
