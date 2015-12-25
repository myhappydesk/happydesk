package com.happydesk.util;

import javax.servlet.http.HttpSession;


public class SessionUtil{
	HttpSession session;
	
	

	/**
	 * @return the session
	 */
	public HttpSession getSession() {
		return session;
	}

	/**
	 * @param session the session to set
	 */
	public void setSession(HttpSession session) {
		this.session = session;
	}
	

}
