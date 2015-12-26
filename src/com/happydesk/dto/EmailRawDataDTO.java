package com.happydesk.dto;

import java.io.Serializable;

/**
 * @author amit
 *
 */
public class EmailRawDataDTO implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String headers;
	private String messageId; 
	private String mailText;
	private  String bodyText;
	private String bodyHtml;
	private  String to;
	private String from ;
	private String cc;
	private String subject;
	private String SPF ;
	private String envelope; 
	private String charsets;
	private String spam_score; 
	private String spam_report; 
	private String attachments; 
	private String attachments_info;
	private String attachmentX;
	
	
	/**
	 * @return the headers
	 */
	public String getHeaders() {
		return headers;
	}
	/**
	 * @param headers the headers to set
	 */
	public void setHeaders(String headers) {
		this.headers = headers;
	}
	/**
	 * @return the messageId
	 */
	public String getMessageId() {
		return messageId;
	}
	/**
	 * @param messageId the messageId to set
	 */
	public void setMessageId(String messageId) {
		this.messageId = messageId;
	}
	/**
	 * @return the mailText
	 */
	public String getMailText() {
		return mailText;
	}
	/**
	 * @param mailText the mailText to set
	 */
	public void setMailText(String mailText) {
		this.mailText = mailText;
	}
	/**
	 * @return the bodyText
	 */
	public String getBodyText() {
		return bodyText;
	}
	/**
	 * @param bodyText the bodyText to set
	 */
	public void setBodyText(String bodyText) {
		this.bodyText = bodyText;
	}
	/**
	 * @return the bodyHtml
	 */
	public String getBodyHtml() {
		return bodyHtml;
	}
	/**
	 * @param bodyHtml the bodyHtml to set
	 */
	public void setBodyHtml(String bodyHtml) {
		this.bodyHtml = bodyHtml;
	}
	/**
	 * @return the to
	 */
	public String getTo() {
		return to;
	}
	/**
	 * @param to the to to set
	 */
	public void setTo(String to) {
		this.to = to;
	}
	/**
	 * @return the from
	 */
	public String getFrom() {
		return from;
	}
	/**
	 * @param from the from to set
	 */
	public void setFrom(String from) {
		this.from = from;
	}
	/**
	 * @return the cc
	 */
	public String getCc() {
		return cc;
	}
	/**
	 * @param cc the cc to set
	 */
	public void setCc(String cc) {
		this.cc = cc;
	}
	/**
	 * @return the subject
	 */
	public String getSubject() {
		return subject;
	}
	/**
	 * @param subject the subject to set
	 */
	public void setSubject(String subject) {
		this.subject = subject;
	}
	/**
	 * @return the sPF
	 */
	public String getSPF() {
		return SPF;
	}
	/**
	 * @param sPF the sPF to set
	 */
	public void setSPF(String sPF) {
		SPF = sPF;
	}
	/**
	 * @return the envelope
	 */
	public String getEnvelope() {
		return envelope;
	}
	/**
	 * @param envelope the envelope to set
	 */
	public void setEnvelope(String envelope) {
		this.envelope = envelope;
	}
	/**
	 * @return the charsets
	 */
	public String getCharsets() {
		return charsets;
	}
	/**
	 * @param charsets the charsets to set
	 */
	public void setCharsets(String charsets) {
		this.charsets = charsets;
	}
	/**
	 * @return the spam_score
	 */
	public String getSpam_score() {
		return spam_score;
	}
	/**
	 * @param spam_score the spam_score to set
	 */
	public void setSpam_score(String spam_score) {
		this.spam_score = spam_score;
	}
	/**
	 * @return the spam_report
	 */
	public String getSpam_report() {
		return spam_report;
	}
	/**
	 * @param spam_report the spam_report to set
	 */
	public void setSpam_report(String spam_report) {
		this.spam_report = spam_report;
	}
	/**
	 * @return the attachments
	 */
	public String getAttachments() {
		return attachments;
	}
	/**
	 * @param attachments the attachments to set
	 */
	public void setAttachments(String attachments) {
		this.attachments = attachments;
	}
	/**
	 * @return the attachments_info
	 */
	public String getAttachments_info() {
		return attachments_info;
	}
	/**
	 * @param attachments_info the attachments_info to set
	 */
	public void setAttachments_info(String attachments_info) {
		this.attachments_info = attachments_info;
	}
	/**
	 * @return the attachmentX
	 */
	public String getAttachmentX() {
		return attachmentX;
	}
	/**
	 * @param attachmentX the attachmentX to set
	 */
	public void setAttachmentX(String attachmentX) {
		this.attachmentX = attachmentX;
	}
	
	
	

}
