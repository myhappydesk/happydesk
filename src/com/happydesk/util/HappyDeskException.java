package com.happydesk.util;

public class HappyDeskException extends java.lang.Exception {

	private static final long serialVersionUID = 1L;
	
	public HappyDeskException(String message, Throwable cause)
	{
		super(message, cause);
	}
	
	public HappyDeskException(Throwable cause)
	{
		super(cause);
	}
	
	public HappyDeskException(String message)
	{
		super(message);
	}
}