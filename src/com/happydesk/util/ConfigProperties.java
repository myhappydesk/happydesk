package com.happydesk.util;

import java.io.Serializable;

public class ConfigProperties implements Serializable {
	
	/**
	 * Om Yadav
	 * For application properties configuration pop-up
	 */
	
	private static final long serialVersionUID = 6224841344358919025L;
	private String twitterConsumerKey;
	private String twitterConsumerSecret;
	private String twitterCallbackURL;
	private String twitterAccessKey;
	private String twitterAccessSecret;
	
	
	/**
	 * @return the twitterConsumerKey
	 */
	public String getTwitterConsumerKey() {
		return twitterConsumerKey;
	}
	/**
	 * @param twitterConsumerKey the twitterConsumerKey to set
	 */
	public void setTwitterConsumerKey(String twitterConsumerKey) {
		this.twitterConsumerKey = twitterConsumerKey;
	}
	/**
	 * @return the twitterConsumerSecret
	 */
	public String getTwitterConsumerSecret() {
		return twitterConsumerSecret;
	}
	/**
	 * @param twitterConsumerSecret the twitterConsumerSecret to set
	 */
	public void setTwitterConsumerSecret(String twitterConsumerSecret) {
		this.twitterConsumerSecret = twitterConsumerSecret;
	}
	/**
	 * @return the twitterCallbackURL
	 */
	public String getTwitterCallbackURL() {
		return twitterCallbackURL;
	}
	/**
	 * @param twitterCallbackURL the twitterCallbackURL to set
	 */
	public void setTwitterCallbackURL(String twitterCallbackURL) {
		this.twitterCallbackURL = twitterCallbackURL;
	}
	/**
	 * @return the twitterAccessKey
	 */
	public String getTwitterAccessKey() {
		return twitterAccessKey;
	}
	/**
	 * @param twitterAccessKey the twitterAccessKey to set
	 */
	public void setTwitterAccessKey(String twitterAccessKey) {
		this.twitterAccessKey = twitterAccessKey;
	}
	/**
	 * @return the twitterAccessSecret
	 */
	public String getTwitterAccessSecret() {
		return twitterAccessSecret;
	}
	/**
	 * @param twitterAccessSecret the twitterAccessSecret to set
	 */
	public void setTwitterAccessSecret(String twitterAccessSecret) {
		this.twitterAccessSecret = twitterAccessSecret;
	}
	
	
}
