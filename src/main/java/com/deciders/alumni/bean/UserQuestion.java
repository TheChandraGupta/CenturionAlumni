package com.deciders.alumni.bean;

public class UserQuestion {
	
	private String userQuestionId;
	private String questionId;
	private String question;
	private String totalView;
	private String byUserId;
	private String toUserId;
	
	public UserQuestion() {
		super();
	}

	public UserQuestion(String userQuestionId, String questionId,
			String question, String totalView, String byUserId, String toUserId) {
		super();
		this.userQuestionId = userQuestionId;
		this.questionId = questionId;
		this.question = question;
		this.totalView = totalView;
		this.byUserId = byUserId;
		this.toUserId = toUserId;
	}

	public String getUserQuestionId() {
		return userQuestionId;
	}

	public void setUserQuestionId(String userQuestionId) {
		this.userQuestionId = userQuestionId;
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

	public String getToUserId() {
		return toUserId;
	}

	public void setToUserId(String toUserId) {
		this.toUserId = toUserId;
	}
	
}
