package com.deciders.alumni.bean;

public class AdminUser {
	
	private String userId;
	private String instituteId;
	private String personalMail;
	private String DOB;
	private String type;
	private String status;
	private String verification;
	private String addedDate;
	private String activeDate;
	private String lastSeen;
	private String activeCount;
	private String adminId;
	private String adminName;
	private String gender;
	private String collegeMail;
	private String phone;
	private String deptName;
	private String pic;
	private String batch;
	private String admissionType;
	private String DOA;
	private String martialStatus;
	private String hobby;
	private String religion;
	private String strength;
	private String nationality;
	private String languages;
	private String bloodGroup;
	private String category;
	private String nativeState;
	private String fatherName;
	private String motherName;
	private String address;
	
	public AdminUser() {
		super();
	}

	public AdminUser(String userId, String instituteId, String personalMail,
			String dOB, String type, String status, String verification,
			String addedDate, String activeDate, String lastSeen,
			String activeCount, String adminId, String adminName,
			String gender, String collegeMail, String phone, String deptName,
			String pic, String batch, String admissionType, String dOA,
			String martialStatus, String hobby, String religion,
			String strength, String nationality, String languages,
			String bloodGroup, String category, String nativeState,
			String fatherName, String motherName, String address) {
		super();
		this.userId = userId;
		this.instituteId = instituteId;
		this.personalMail = personalMail;
		DOB = dOB;
		this.type = type;
		this.status = status;
		this.verification = verification;
		this.addedDate = addedDate;
		this.activeDate = activeDate;
		this.lastSeen = lastSeen;
		this.activeCount = activeCount;
		this.adminId = adminId;
		this.adminName = adminName;
		this.gender = gender;
		this.collegeMail = collegeMail;
		this.phone = phone;
		this.deptName = deptName;
		this.pic = pic;
		this.batch = batch;
		this.admissionType = admissionType;
		DOA = dOA;
		this.martialStatus = martialStatus;
		this.hobby = hobby;
		this.religion = religion;
		this.strength = strength;
		this.nationality = nationality;
		this.languages = languages;
		this.bloodGroup = bloodGroup;
		this.category = category;
		this.nativeState = nativeState;
		this.fatherName = fatherName;
		this.motherName = motherName;
		this.address = address;
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

	public String getDOB() {
		return DOB;
	}

	public void setDOB(String dOB) {
		DOB = dOB;
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

	public String getVerification() {
		return verification;
	}

	public void setVerification(String verification) {
		this.verification = verification;
	}

	public String getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(String addedDate) {
		this.addedDate = addedDate;
	}

	public String getActiveDate() {
		return activeDate;
	}

	public void setActiveDate(String activeDate) {
		this.activeDate = activeDate;
	}

	public String getLastSeen() {
		return lastSeen;
	}

	public void setLastSeen(String lastSeen) {
		this.lastSeen = lastSeen;
	}

	public String getActiveCount() {
		return activeCount;
	}

	public void setActiveCount(String activeCount) {
		this.activeCount = activeCount;
	}

	public String getAdminId() {
		return adminId;
	}

	public void setAdminId(String adminId) {
		this.adminId = adminId;
	}

	public String getAdminName() {
		return adminName;
	}

	public void setAdminName(String adminName) {
		this.adminName = adminName;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getCollegeMail() {
		return collegeMail;
	}

	public void setCollegeMail(String collegeMail) {
		this.collegeMail = collegeMail;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getDeptName() {
		return deptName;
	}

	public void setDeptName(String deptName) {
		this.deptName = deptName;
	}

	public String getPic() {
		return pic;
	}

	public void setPic(String pic) {
		this.pic = pic;
	}

	public String getBatch() {
		return batch;
	}

	public void setBatch(String batch) {
		this.batch = batch;
	}

	public String getAdmissionType() {
		return admissionType;
	}

	public void setAdmissionType(String admissionType) {
		this.admissionType = admissionType;
	}

	public String getDOA() {
		return DOA;
	}

	public void setDOA(String dOA) {
		DOA = dOA;
	}

	public String getMartialStatus() {
		return martialStatus;
	}

	public void setMartialStatus(String martialStatus) {
		this.martialStatus = martialStatus;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getReligion() {
		return religion;
	}

	public void setReligion(String religion) {
		this.religion = religion;
	}

	public String getStrength() {
		return strength;
	}

	public void setStrength(String strength) {
		this.strength = strength;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getLanguages() {
		return languages;
	}

	public void setLanguages(String languages) {
		this.languages = languages;
	}

	public String getBloodGroup() {
		return bloodGroup;
	}

	public void setBloodGroup(String bloodGroup) {
		this.bloodGroup = bloodGroup;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getNativeState() {
		return nativeState;
	}

	public void setNativeState(String nativeState) {
		this.nativeState = nativeState;
	}

	public String getFatherName() {
		return fatherName;
	}

	public void setFatherName(String fatherName) {
		this.fatherName = fatherName;
	}

	public String getMotherName() {
		return motherName;
	}

	public void setMotherName(String motherName) {
		this.motherName = motherName;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	

}
