package com.deciders.alumni.bean;

public class GroupTagFollow {
	
	private String groupTagFollowId;
	private String groupTagId;
	private String groupTagName;
	private String description;
	private String totalFollowers;
	private String creationDate;
	private String userId;
	private String dateFollow;
	
	public GroupTagFollow() {
		super();
	}

	public GroupTagFollow(String groupTagFollowId, String groupTagId,
			String groupTagName, String description, String totalFollowers,
			String creationDate, String userId, String dateFollow) {
		super();
		this.groupTagFollowId = groupTagFollowId;
		this.groupTagId = groupTagId;
		this.groupTagName = groupTagName;
		this.description = description;
		this.totalFollowers = totalFollowers;
		this.creationDate = creationDate;
		this.userId = userId;
		this.dateFollow = dateFollow;
	}

	public String getGroupTagFollowId() {
		return groupTagFollowId;
	}

	public void setGroupTagFollowId(String groupTagFollowId) {
		this.groupTagFollowId = groupTagFollowId;
	}

	public String getGroupTagId() {
		return groupTagId;
	}

	public void setGroupTagId(String groupTagId) {
		this.groupTagId = groupTagId;
	}

	public String getGroupTagName() {
		return groupTagName;
	}

	public void setGroupTagName(String groupTagName) {
		this.groupTagName = groupTagName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTotalFollowers() {
		return totalFollowers;
	}

	public void setTotalFollowers(String totalFollowers) {
		this.totalFollowers = totalFollowers;
	}

	public String getCreationDate() {
		return creationDate;
	}

	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getDateFollow() {
		return dateFollow;
	}

	public void setDateFollow(String dateFollow) {
		this.dateFollow = dateFollow;
	}
	
}
