package com.happydesk.entity;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity
@Table(name="cron_jobs_data")
public class CronJobsData  extends BaseEntity<Integer> implements Serializable {
	

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name="job_name")
	private String jobName;
	
	@Column(name="job_desc")
	private String jonDesc;
	
	@Column(name="job_time_expression")
	private String jobTimeExpression;
	
	/*@OneToOne
	@JoinColumn(name="job_process_id")
	private AutomaticProcess automaticProcess;
	*/
	
	@Column(name="job_brand_id")
	private Integer brandId;
	
	@Column(name="job_class_name")
	private String jobClassName;
	
	@Temporal( TemporalType.TIMESTAMP)
	@Column(name="created_at")
	private Date createdAt;
	
	@Temporal( TemporalType.TIMESTAMP)
	@Column(name="updated_at")
	private Date updatedAt;
	
	@Column(name="updated_by")
	private Integer updatedBy;
	
	@Column(name="updated_by_name")
	private String updatedByName;
	
	@Column(name="updated_by_ip_address")
	private String updatedByIpAddress;
	
	@Column(name="process_host")
	private String processHost;
	
	@Column(name="status")
	private Byte status;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getJobName() {
		return jobName;
	}
	public void setJobName(String jobName) {
		this.jobName = jobName;
	}
	public String getJonDesc() {
		return jonDesc;
	}
	public void setJonDesc(String jonDesc) {
		this.jonDesc = jonDesc;
	}
	public String getJobTimeExpression() {
		return jobTimeExpression;
	}
	public void setJobTimeExpression(String jobTimeExpression) {
		this.jobTimeExpression = jobTimeExpression;
	}
	/*public AutomaticProcess getAutomaticProcess() {
		return automaticProcess;
	}
	public void setAutomaticProcess(AutomaticProcess automaticProcess) {
		this.automaticProcess = automaticProcess;
	}*/
	public Integer getBrandId() {
		return brandId;
	}
	public void setBrandId(Integer brandId) {
		this.brandId = brandId;
	}
	public String getJobClassName() {
		return jobClassName;
	}
	public void setJobClassName(String jobClassName) {
		this.jobClassName = jobClassName;
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
	public Integer getUpdatedBy() {
		return updatedBy;
	}
	public void setUpdatedBy(Integer updatedBy) {
		this.updatedBy = updatedBy;
	}
	public String getUpdatedByName() {
		return updatedByName;
	}
	public void setUpdatedByName(String updatedByName) {
		this.updatedByName = updatedByName;
	}
	public String getUpdatedByIpAddress() {
		return updatedByIpAddress;
	}
	public void setUpdatedByIpAddress(String updatedByIpAddress) {
		this.updatedByIpAddress = updatedByIpAddress;
	}
	public String getProcessHost() {
		return processHost;
	}
	public void setProcessHost(String processHost) {
		this.processHost = processHost;
	}
	public Byte getStatus() {
		return status;
	}
	public void setStatus(Byte status) {
		this.status = status;
	}
	

}
