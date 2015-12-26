package com.happydesk.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="facebook_page_admin")
public class FacebookPageAdmin extends BaseEntity<Integer> implements Serializable {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private Integer id;
	
	@Column(name="fb_user_id")
	private String fbUserId;
	
	@ManyToOne
	@JoinColumn(name="facebook_company_tokens_id")
	private FacebookCompanyTokens facebookCompanyTokensId;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFbUserId() {
		return fbUserId;
	}

	public void setFbUserId(String fbUserId) {
		this.fbUserId = fbUserId;
	}

	public FacebookCompanyTokens getFacebookCompanyTokensId() {
		return facebookCompanyTokensId;
	}

	public void setFacebookCompanyTokensId(FacebookCompanyTokens facebookCompanyTokensId) {
		this.facebookCompanyTokensId = facebookCompanyTokensId;
	}
	
	

}
