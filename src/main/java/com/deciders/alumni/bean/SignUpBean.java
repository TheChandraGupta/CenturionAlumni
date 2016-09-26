package com.deciders.alumni.bean;

public class SignUpBean {
	
	private String userId;
	private String instituteId;
	private String personalMail;
	private String code;
	private String type;
	private String status; 
	
	public SignUpBean() {
		super();
	}

	public SignUpBean(String userId, String instituteId, String personalMail,
			String code, String type, String status) {
		super();
		this.userId = userId;
		this.instituteId = instituteId;
		this.personalMail = personalMail;
		this.code = code;
		this.type = type;
		this.status = status;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

	public String getInstituteId() {
		return instituteId;
	}

	public void setInstituteId(String instituteId) {
		this.instituteId = instituteId;
	}

	public String getPersonalMail() {
		return personalMail;
	}

	public void setPersonalMail(String personalMail) {
		this.personalMail = personalMail;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}
	
}
