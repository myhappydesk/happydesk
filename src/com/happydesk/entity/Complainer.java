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
public class Complainer extends BaseEntity<Integer> {
	
	/**
	 * om yadav 
	 * Table : complainer
	 */
	
	private static final long serialVersionUID = -8159710465194637806L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "name")
	private String name;

	@Column(name = "source_type_id")
	private Integer sourceTypeId;

	@Column(name = "external_user_id")
	private Integer extrenalUserId;

	@Column(name = "location")
	private String location;

	@Column(name = "description")
	private String description;

	@Column(name = "profile_url")
	private String profileUrl;

	@Column(name = "profile_image_url")
	private String profileImageUrl;

	@Column(name = "email")
	private String email;
	
	@Column(name = "phone_no")
	private Integer phone;
	
	@Column(name = "impact_score")
	private Integer impactScroe;
	
	@Column(name = "screen_name")
	private Integer screenName;
	
	@Column(name = "friends_count")
	private Integer friendsCount;
	
	@Column(name = "followers_count")
	private Integer followersCount;
	
	@Column(name = "status_count")
	private Integer statusCount;
	
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
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name the name to set
	 */
	public void setName(String name) {
		this.name = name;
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
	 * @return the extrenalUserId
	 */
	public Integer getExtrenalUserId() {
		return extrenalUserId;
	}

	/**
	 * @param extrenalUserId the extrenalUserId to set
	 */
	public void setExtrenalUserId(Integer extrenalUserId) {
		this.extrenalUserId = extrenalUserId;
	}

	/**
	 * @return the location
	 */
	public String getLocation() {
		return location;
	}

	/**
	 * @param location the location to set
	 */
	public void setLocation(String location) {
		this.location = location;
	}

	/**
	 * @return the description
	 */
	public String getDescription() {
		return description;
	}

	/**
	 * @param description the description to set
	 */
	public void setDescription(String description) {
		this.description = description;
	}

	/**
	 * @return the profileUrl
	 */
	public String getProfileUrl() {
		return profileUrl;
	}

	/**
	 * @param profileUrl the profileUrl to set
	 */
	public void setProfileUrl(String profileUrl) {
		this.profileUrl = profileUrl;
	}

	/**
	 * @return the profileImageUrl
	 */
	public String getProfileImageUrl() {
		return profileImageUrl;
	}

	/**
	 * @param profileImageUrl the profileImageUrl to set
	 */
	public void setProfileImageUrl(String profileImageUrl) {
		this.profileImageUrl = profileImageUrl;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the phone
	 */
	public Integer getPhone() {
		return phone;
	}

	/**
	 * @param phone the phone to set
	 */
	public void setPhone(Integer phone) {
		this.phone = phone;
	}

	/**
	 * @return the impactScroe
	 */
	public Integer getImpactScroe() {
		return impactScroe;
	}

	/**
	 * @param impactScroe the impactScroe to set
	 */
	public void setImpactScroe(Integer impactScroe) {
		this.impactScroe = impactScroe;
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
	 * @return the friendsCount
	 */
	public Integer getFriendsCount() {
		return friendsCount;
	}

	/**
	 * @param friendsCount the friendsCount to set
	 */
	public void setFriendsCount(Integer friendsCount) {
		this.friendsCount = friendsCount;
	}

	/**
	 * @return the followersCount
	 */
	public Integer getFollowersCount() {
		return followersCount;
	}

	/**
	 * @param followersCount the followersCount to set
	 */
	public void setFollowersCount(Integer followersCount) {
		this.followersCount = followersCount;
	}

	/**
	 * @return the statusCount
	 */
	public Integer getStatusCount() {
		return statusCount;
	}

	/**
	 * @param statusCount the statusCount to set
	 */
	public void setStatusCount(Integer statusCount) {
		this.statusCount = statusCount;
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
