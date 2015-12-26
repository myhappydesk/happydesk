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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="social_cron_data")
public class SocialCronInfo extends BaseEntity<Integer> implements Serializable {
	private static final long serialVersionUID = 1L;

    @Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
    
    
   
    @JoinColumn(name="company_id")
	private Company company;
    
    
    @Column(name="social_cron_type")
    private Integer socialCronType;
    
    @Column(name="status")
    private Byte status;
    
    
    @Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_at")
	private Date createdAt;

    @Column(name="ipAddress")
    private String ipAddress;
	

    //setters and getters
    
	public Integer getId() {
		return id;
	}

	public String getIpAddress() {
		return ipAddress;
	}

	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
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


	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Integer getSocialCronType() {
		return socialCronType;
	}

	public void setSocialCronType(Integer socialCronType) {
		this.socialCronType = socialCronType;
	}

	public Byte getStatus() {
		return status;
	}

	public void setStatus(Byte status) {
		this.status = status;
	}

	
}