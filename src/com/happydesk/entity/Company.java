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
@Table(name = "company")
public class Company extends BaseEntity<Integer> {

	/**
	 * om yadav 
	 * Table : company
	 */
	private static final long serialVersionUID = 1059363551240227899L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "name")
	private String companyName;

	@Column(name = "logo")
	private String companyLogo;

	@Column(name = "website_url")
	private String companyWebsiteUrl;

	@Column(name = "company_address")
	private String companyAddress;

	@Column(name = "description")
	private Integer companyDescription;

	@Column(name = "twitter_feed_enable")
	private boolean twitterEnable;
	
	@Column(name = "facebook_realtime_enable")
	private boolean facebookRealtimeEnable;
	
	@Column(name = "email_parser_enable")
	private boolean emailParserEnable;

	@Column(name = "sub_domain_name")
	private Integer companySubDomainName;

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
	 * @return the companyName
	 */
	public String getCompanyName() {
		return companyName;
	}

	/**
	 * @param companyName the companyName to set
	 */
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}

	/**
	 * @return the companyLogo
	 */
	public String getCompanyLogo() {
		return companyLogo;
	}

	/**
	 * @param companyLogo the companyLogo to set
	 */
	public void setCompanyLogo(String companyLogo) {
		this.companyLogo = companyLogo;
	}

	/**
	 * @return the companyWebsiteUrl
	 */
	public String getCompanyWebsiteUrl() {
		return companyWebsiteUrl;
	}

	/**
	 * @param companyWebsiteUrl the companyWebsiteUrl to set
	 */
	public void setCompanyWebsiteUrl(String companyWebsiteUrl) {
		this.companyWebsiteUrl = companyWebsiteUrl;
	}

	/**
	 * @return the companyAddress
	 */
	public String getCompanyAddress() {
		return companyAddress;
	}

	/**
	 * @param companyAddress the companyAddress to set
	 */
	public void setCompanyAddress(String companyAddress) {
		this.companyAddress = companyAddress;
	}

	/**
	 * @return the companyDescription
	 */
	public Integer getCompanyDescription() {
		return companyDescription;
	}

	/**
	 * @param companyDescription the companyDescription to set
	 */
	public void setCompanyDescription(Integer companyDescription) {
		this.companyDescription = companyDescription;
	}

	/**
	 * @return the twitterEnable
	 */
	public boolean isTwitterEnable() {
		return twitterEnable;
	}

	/**
	 * @param twitterEnable the twitterEnable to set
	 */
	public void setTwitterEnable(boolean twitterEnable) {
		this.twitterEnable = twitterEnable;
	}

	/**
	 * @return the facebookRealtimeEnable
	 */
	public boolean isFacebookRealtimeEnable() {
		return facebookRealtimeEnable;
	}

	/**
	 * @param facebookRealtimeEnable the facebookRealtimeEnable to set
	 */
	public void setFacebookRealtimeEnable(boolean facebookRealtimeEnable) {
		this.facebookRealtimeEnable = facebookRealtimeEnable;
	}

	/**
	 * @return the emailParserEnable
	 */
	public boolean isEmailParserEnable() {
		return emailParserEnable;
	}

	/**
	 * @param emailParserEnable the emailParserEnable to set
	 */
	public void setEmailParserEnable(boolean emailParserEnable) {
		this.emailParserEnable = emailParserEnable;
	}

	/**
	 * @return the companySubDomainName
	 */
	public Integer getCompanySubDomainName() {
		return companySubDomainName;
	}

	/**
	 * @param companySubDomainName the companySubDomainName to set
	 */
	public void setCompanySubDomainName(Integer companySubDomainName) {
		this.companySubDomainName = companySubDomainName;
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
