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

/**
 * @author Om Yadav
 * Social API last call data information
 */

@Entity
@Table(name="last_api_call_data")
public class LastAPICallData extends BaseEntity<Integer> implements Serializable {

	private static final long serialVersionUID = 5964751298067713041L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
    
    
    @ManyToOne
    @JoinColumn(name="company_id")
	private Company company;
    
    
    @Column(name="last_resource_id")
    private Long lastResourceId;
	
    @Temporal(TemporalType.TIMESTAMP)
	@Column(name="last_request_date")
	private Date lastRequestedDate;
    
    @Temporal(TemporalType.TIMESTAMP)
   	@Column(name="created_at")
   	private Date createdAt;
    
    @Temporal(TemporalType.TIMESTAMP)
   	@Column(name="updated_at")
   	private Date updatedAt;

	@Column(name="resource_type")
    private Integer resourceType;
	
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



	public Date getLastRequestedDate() {
		return lastRequestedDate;
	}

	public void setLastRequestedDate(Date lastRequestedDate) {
		this.lastRequestedDate = lastRequestedDate;
	}
	
	public Integer getResourceType() {
		return resourceType;
	}

	public void setResourceType(Integer resourceType) {
		this.resourceType = resourceType;
	}

	public Long getLastResourceId() {
		return lastResourceId;
	}

	public void setLastResourceId(Long lastResourceId) {
		this.lastResourceId = lastResourceId;
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
	
}