package com.happydesk.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity
@Table(name="facebook_company_tokens")
public class FacebookCompanyTokens extends BaseEntity<Integer> implements Serializable {
	
	private static final long serialVersionUID = -7516397604909872024L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@ManyToOne
	@JoinColumn(name ="brand_id")
	private Company company;
	
	@Column(name="page_access_token")
	private String pageAccessToken;
	
	@Column(name="fb_page_id")
	private String fbPageId;
	
	@Column(name="fb_page_name")
	private String fbPageName;
	
	@Column(name="created_at")
	private Date createdAt;

	@Column(name="updated_at")
	private Date updatedAt;
	
	@Column(name="status")
	private Byte status;
	
	@Column(name="fb_realtime_feed")
	private int fbRealTimeFeed;

	
	
	
	public int getFbRealTimeFeed() {
		return fbRealTimeFeed;
	}

	public void setFbRealTimeFeed(int fbRealTimeFeed) {
		this.fbRealTimeFeed = fbRealTimeFeed;
	}
	
	

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public String getPageAccessToken() {
		return pageAccessToken;
	}

	public void setPageAccessToken(String pageAccessToken) {
		this.pageAccessToken = pageAccessToken;
	}

	public String getFbPageId() {
		return fbPageId;
	}

	public void setFbPageId(String fbPageId) {
		this.fbPageId = fbPageId;
	}

	public String getFbPageName() {
		return fbPageName;
	}

	public void setFbPageName(String fbPageName) {
		this.fbPageName = fbPageName;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	
	

}
