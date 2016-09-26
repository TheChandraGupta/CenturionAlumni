package com.deciders.alumni.bean;

public class GroupTagQuestion {
	
	private String groupTagQuestionId;
	private String questionId;
	private String question;
	private String totalView;
	private String byUserId;
	private String toGrouptagId;
	
	public GroupTagQuestion() {
		super();
	}

	public GroupTagQuestion(String groupTagQuestionId, String questionId,
			String question, String totalView, String byUserId,
			String toGrouptagId) {
		super();
		this.groupTagQuestionId = groupTagQuestionId;
		this.questionId = questionId;
		this.question = question;
		this.totalView = totalView;
		this.byUserId = byUserId;
		this.toGrouptagId = toGrouptagId;
	}

	public String getGroupTagQuestionId() {
		return groupTagQuestionId;
	}

	public void setGroupTagQuestionId(String groupTagQuestionId) {
		this.groupTagQuestionId = groupTagQuestionId;
	}

	public String getQuestionId() {
		return questionId;
	}

	public void setQuestionId(String questionId) {
		this.questionId = questionId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getTotalView() {
		return totalView;
	}

	public void setTotalView(String totalView) {
		this.totalView = totalView;
	}

	public String getByUserId() {
		return byUserId;
	}

	public void setByUserId(String byUserId) {
		this.byUserId = byUserId;
	}

	public String getToGrouptagId() {
		return toGrouptagId;
	}

	public void setToGrouptagId(String toGrouptagId) {
		this.toGrouptagId = toGrouptagId;
	}
	
}
