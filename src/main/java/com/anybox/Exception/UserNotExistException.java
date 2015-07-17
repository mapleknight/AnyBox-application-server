package com.anybox.Exception;

public class UserNotExistException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -3541515489469655399L;
	
	public UserNotExistException(String msg){
		super(msg);
	}

}
