package com.happydesk.util;

/**
 * @author Om Yadav 
 * HappyDeskException- General purpose exception class
 */
public class HappyDeskException extends java.lang.Exception {

	private static final long serialVersionUID = -4581740387522086879L;

	public HappyDeskException(String message, Throwable cause) {
		super(message, cause);
	}

	public HappyDeskException(Throwable cause) {
		super(cause);
	}

	public HappyDeskException(String message) {
		super(message);
	}
}
