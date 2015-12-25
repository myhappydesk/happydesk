package com.happydesk.dto;

/**
 * @author amit
 *
 */
public class EmailDTO {

	private String userName;
	private String fromEmail;
	private String toEmail; // this is for storing this mail as the source for the complaint
	private String mailSubject;
	private String mailBody;
	private Integer attachmentNumber;
	private String senderIpAddress;
	private String toEmailList;
	private String ccEmailList;
	private String fromWithName;
	
	/**
	 * @return the userName
	 */
	public String getUserName() {
		return userName;
	}
	/**
	 * @param userName the userName to set
	 */
	public void setUserName(String userName) {
		this.userName = userName;
	}
	/**
	 * @return the fromEmail
	 */
	public String getFromEmail() {
		return fromEmail;
	}
	/**
	 * @param fromEmail the fromEmail to set
	 */
	public void setFromEmail(String fromEmail) {
		this.fromEmail = fromEmail;
	}
	/**
	 * @return the toEmail
	 */
	public String getToEmail() {
		return toEmail;
	}
	/**
	 * @param toEmail the toEmail to set
	 */
	public void setToEmail(String toEmail) {
		this.toEmail = toEmail;
	}
	/**
	 * @return the mailSubject
	 */
	public String getMailSubject() {
		return mailSubject;
	}
	/**
	 * @param mailSubject the mailSubject to set
	 */
	public void setMailSubject(String mailSubject) {
		this.mailSubject = mailSubject;
	}
	/**
	 * @return the mailBody
	 */
	public String getMailBody() {
		return mailBody;
	}
	/**
	 * @param mailBody the mailBody to set
	 */
	public void setMailBody(String mailBody) {
		this.mailBody = mailBody;
	}
	/**
	 * @return the attachmentNumber
	 */
	public Integer getAttachmentNumber() {
		return attachmentNumber;
	}
	/**
	 * @param attachmentNumber the attachmentNumber to set
	 */
	public void setAttachmentNumber(Integer attachmentNumber) {
		this.attachmentNumber = attachmentNumber;
	}
	/**
	 * @return the senderIpAddress
	 */
	public String getSenderIpAddress() {
		return senderIpAddress;
	}
	/**
	 * @param senderIpAddress the senderIpAddress to set
	 */
	public void setSenderIpAddress(String senderIpAddress) {
		this.senderIpAddress = senderIpAddress;
	}
	/**
	 * @return the toEmailList
	 */
	public String getToEmailList() {
		return toEmailList;
	}
	/**
	 * @param toEmailList the toEmailList to set
	 */
	public void setToEmailList(String toEmailList) {
		this.toEmailList = toEmailList;
	}
	/**
	 * @return the ccEmailList
	 */
	public String getCcEmailList() {
		return ccEmailList;
	}
	/**
	 * @param ccEmailList the ccEmailList to set
	 */
	public void setCcEmailList(String ccEmailList) {
		this.ccEmailList = ccEmailList;
	}
	/**
	 * @return the fromWithName
	 */
	public String getFromWithName() {
		return fromWithName;
	}
	/**
	 * @param fromWithName the fromWithName to set
	 */
	public void setFromWithName(String fromWithName) {
		this.fromWithName = fromWithName;
	}
}
