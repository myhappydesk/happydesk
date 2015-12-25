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
@Table(name = "complainer")
public class Conversation extends BaseEntity<Integer> {
	

	/**
	 * om yadav 
	 * Table : conversation
	 */
	
	private static final long serialVersionUID = -4029129027692330817L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	@Column(name = "source_type_id")
	private Integer sourceTypeId;
	
	@Column(name = "resource_id")
	private Integer resourceId;
	
	@Column(name = "resource_text")
	private String resourceText;
	
	@Column(name = "resource_type")
	private Integer resourceType;
	
	@Column(name = "resource_url")
	private String resourceUrl;
	
	@Temporal( TemporalType.TIMESTAMP)
	@Column(name = "resource_publish_date")
	private Date resourcePublishDate;
	
	@Column(name = "resource_parent_id")
	private Integer resourceParentId;
	
	@Column(name = "ticket_id")
	private Integer ticketId;
	
	@Column(name = "company_id")
	private Integer companyId;
	
	@Column(name = "sentiment")
	private Integer sentiment;
	
	@Column(name = "top_parent_id")
	private Integer topParentId;
	
	@Column(name = "corrected_sentiment")
	private Integer correctedSentiment;
	
	@Temporal( TemporalType.TIMESTAMP)
	@Column(name = "sentiment_corrected_at")
	private Date sentimentCorrectedAt;
	
	@Column(name = "external_user_id")
	private Integer externalUserId;
	  
	@Column(name = "resource_group_id")
	private Integer resourceGroupId;
	
	@Column(name = "favourite_by_brand")
	private Integer favouriteByBrand;
	
	@Column(name = "handle_id")
	private Integer handleId;
	
	@Column(name = "attachment_id")
	private Integer attachmentId;
	
	@Temporal( TemporalType.TIMESTAMP)
	@Column(name = "createdAt")
	private Date created_at;
	
	@Column(name = "created_by")
	private Integer createdBy;
	
	@Temporal( TemporalType.TIMESTAMP)
	@Column(name = "updated_at")
	private Date updatedAt;
	
	@Column(name = "updated_by")
	private Integer updatedBy;
	
	@Override
	public Integer getId() {
		return id;
	}

	@Override
	public void setId(Integer id) {
		this.id = id;
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
	 * @return the resourceId
	 */
	public Integer getResourceId() {
		return resourceId;
	}

	/**
	 * @param resourceId the resourceId to set
	 */
	public void setResourceId(Integer resourceId) {
		this.resourceId = resourceId;
	}

	/**
	 * @return the resourceText
	 */
	public String getResourceText() {
		return resourceText;
	}

	/**
	 * @param resourceText the resourceText to set
	 */
	public void setResourceText(String resourceText) {
		this.resourceText = resourceText;
	}

	/**
	 * @return the resourceType
	 */
	public Integer getResourceType() {
		return resourceType;
	}

	/**
	 * @param resourceType the resourceType to set
	 */
	public void setResourceType(Integer resourceType) {
		this.resourceType = resourceType;
	}

	/**
	 * @return the resourceUrl
	 */
	public String getResourceUrl() {
		return resourceUrl;
	}

	/**
	 * @param resourceUrl the resourceUrl to set
	 */
	public void setResourceUrl(String resourceUrl) {
		this.resourceUrl = resourceUrl;
	}

	/**
	 * @return the resourcePublishDate
	 */
	public Date getResourcePublishDate() {
		return resourcePublishDate;
	}

	/**
	 * @param resourcePublishDate the resourcePublishDate to set
	 */
	public void setResourcePublishDate(Date resourcePublishDate) {
		this.resourcePublishDate = resourcePublishDate;
	}

	/**
	 * @return the resourceParentId
	 */
	public Integer getResourceParentId() {
		return resourceParentId;
	}

	/**
	 * @param resourceParentId the resourceParentId to set
	 */
	public void setResourceParentId(Integer resourceParentId) {
		this.resourceParentId = resourceParentId;
	}

	/**
	 * @return the ticketId
	 */
	public Integer getTicketId() {
		return ticketId;
	}

	/**
	 * @param ticketId the ticketId to set
	 */
	public void setTicketId(Integer ticketId) {
		this.ticketId = ticketId;
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
	 * @return the sentiment
	 */
	public Integer getSentiment() {
		return sentiment;
	}

	/**
	 * @param sentiment the sentiment to set
	 */
	public void setSentiment(Integer sentiment) {
		this.sentiment = sentiment;
	}

	/**
	 * @return the topParentId
	 */
	public Integer getTopParentId() {
		return topParentId;
	}

	/**
	 * @param topParentId the topParentId to set
	 */
	public void setTopParentId(Integer topParentId) {
		this.topParentId = topParentId;
	}

	/**
	 * @return the correctedSentiment
	 */
	public Integer getCorrectedSentiment() {
		return correctedSentiment;
	}

	/**
	 * @param correctedSentiment the correctedSentiment to set
	 */
	public void setCorrectedSentiment(Integer correctedSentiment) {
		this.correctedSentiment = correctedSentiment;
	}

	/**
	 * @return the sentimentCorrectedAt
	 */
	public Date getSentimentCorrectedAt() {
		return sentimentCorrectedAt;
	}

	/**
	 * @param sentimentCorrectedAt the sentimentCorrectedAt to set
	 */
	public void setSentimentCorrectedAt(Date sentimentCorrectedAt) {
		this.sentimentCorrectedAt = sentimentCorrectedAt;
	}

	/**
	 * @return the externalUserId
	 */
	public Integer getExternalUserId() {
		return externalUserId;
	}

	/**
	 * @param externalUserId the externalUserId to set
	 */
	public void setExternalUserId(Integer externalUserId) {
		this.externalUserId = externalUserId;
	}

	/**
	 * @return the resourceGroupId
	 */
	public Integer getResourceGroupId() {
		return resourceGroupId;
	}

	/**
	 * @param resourceGroupId the resourceGroupId to set
	 */
	public void setResourceGroupId(Integer resourceGroupId) {
		this.resourceGroupId = resourceGroupId;
	}

	/**
	 * @return the favouriteByBrand
	 */
	public Integer getFavouriteByBrand() {
		return favouriteByBrand;
	}

	/**
	 * @param favouriteByBrand the favouriteByBrand to set
	 */
	public void setFavouriteByBrand(Integer favouriteByBrand) {
		this.favouriteByBrand = favouriteByBrand;
	}

	/**
	 * @return the handleId
	 */
	public Integer getHandleId() {
		return handleId;
	}

	/**
	 * @param handleId the handleId to set
	 */
	public void setHandleId(Integer handleId) {
		this.handleId = handleId;
	}

	/**
	 * @return the attachmentId
	 */
	public Integer getAttachmentId() {
		return attachmentId;
	}

	/**
	 * @param attachmentId the attachmentId to set
	 */
	public void setAttachmentId(Integer attachmentId) {
		this.attachmentId = attachmentId;
	}

	/**
	 * @return the created_at
	 */
	public Date getCreated_at() {
		return created_at;
	}

	/**
	 * @param created_at the created_at to set
	 */
	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
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
	
}
