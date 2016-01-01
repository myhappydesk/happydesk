package com.happydesk.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="social_cron_data")
public class SocialCronData extends BaseEntity<Integer> implements Serializable {
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
    
    @Column(name="created_by")
    private Integer createdBy;
    
    @Column(name="updated_by")
    private Integer updatedBy;
    
    @Temporal(TemporalType.TIMESTAMP)
	@Column(name="created_at")
	private Date createdAt;
    
    @Temporal(TemporalType.TIMESTAMP)
	@Column(name="updated_at")
	private Date updatedAt;

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

	public Integer getCreatedBy() {
		return createdBy;
	}

	public void setCreatedBy(Integer createdBy) {
		this.createdBy = createdBy;
	}

	public Integer getUpdatedBy() {
		return updatedBy;
	}

	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	
}