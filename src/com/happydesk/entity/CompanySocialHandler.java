package com.happydesk.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "company_social_handler")
public class CompanySocialHandler extends BaseEntity<Integer> {

	/**
	 * om yadav 
	 * Table : company_social_handler
	 */

	private static final long serialVersionUID = 3942695735970852616L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "company_id")
	private Integer companyId;
	  
	@Column(name = "company_token")
	private String companyToken;

	@Column(name = "token_secret_key")
	private String companyTokenKey;
	
	@Column(name = "social_media_id")
	private Integer userSocialMediaId;

	@Column(name = "source_type_id")
	private Integer sourceTypeId;
	
	@Column(name = "screen_name")
	private Integer screenName;
	
	@Column(name = "created_by")
	private Integer createdBy;

	@Column(name = "updated_by")
	private Integer updatedBy;

	@Temporal( TemporalType.TIMESTAMP)
	@Column(name = "created_at")
	private Date createdAt;

	@Temporal( TemporalType.TIMESTAMP)
	@Column(name = "updated_at")
	private Date updatedAt;

	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
	}

	/**
	 * @return the companyId
	 */
	public Integer getCompanyId() {
		return companyId;
	}

	/**
	 * @param companyId the companyId to set
	 */
	public void setCompanyId(Integer companyId) {
		this.companyId = companyId;
	}

	/**
	 * @return the companyToken
	 */
	public String getCompanyToken() {
		return companyToken;
	}

	/**
	 * @param companyToken the companyToken to set
	 */
	public void setCompanyToken(String companyToken) {
		this.companyToken = companyToken;
	}

	/**
	 * @return the companyTokenKey
	 */
	public String getCompanyTokenKey() {
		return companyTokenKey;
	}

	/**
	 * @param companyTokenKey the companyTokenKey to set
	 */
	public void setCompanyTokenKey(String companyTokenKey) {
		this.companyTokenKey = companyTokenKey;
	}

	/**
	 * @return the userSocialMediaId
	 */
	public Integer getUserSocialMediaId() {
		return userSocialMediaId;
	}

	/**
	 * @param userSocialMediaId the userSocialMediaId to set
	 */
	public void setUserSocialMediaId(Integer userSocialMediaId) {
		this.userSocialMediaId = userSocialMediaId;
	}

	/**
	 * @return the sourceTypeId
	 */
	public Integer getSourceTypeId() {
		return sourceTypeId;
	}

	/**
	 * @param sourceTypeId the sourceTypeId to set
	 */
	public void setSourceTypeId(Integer sourceTypeId) {
		this.sourceTypeId = sourceTypeId;
	}

	/**
	 * @return the screenName
	 */
	public Integer getScreenName() {
		return screenName;
	}

	/**
	 * @param screenName the screenName to set
	 */
	public void setScreenName(Integer screenName) {
		this.screenName = screenName;
	}

	/**
	 * @return the createdBy
	 */
	public Integer getCreatedBy() {
		return createdBy;
	}

	/**
	 * @param createdBy the createdBy to set
	 */
	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	/**
	 * @return the updatedBy
	 */
	public Integer getUpdatedBy() {
		return updatedBy;
	}

	/**
	 * @param updatedBy the updatedBy to set
	 */
	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}

	/**
	 * @return the createdAt
	 */
	public Date getCreatedAt() {
		return createdAt;
	}

	/**
	 * @param createdAt the createdAt to set
	 */
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	/**
	 * @return the updatedAt
	 */
	public Date getUpdatedAt() {
		return updatedAt;
	}

	/**
	 * @param updatedAt the updatedAt to set
	 */
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	
	
}
