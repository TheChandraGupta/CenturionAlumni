package com.deciders.alumni.database;

import java.sql.CallableStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;
import java.util.ArrayList;

import com.deciders.alumni.bean.GroupTagFollow;
import com.deciders.alumni.bean.SignUpBean;
import com.deciders.alumni.bean.StudentUser;
import com.deciders.alumni.bean.User;
import com.deciders.alumni.database.DBManager;;

public class DBHandler {
	
	public static User login(String instituteId, String password, DBManager dbManager) {

		System.out.println("login");
		
		User user = new User();
		
		String query = "";
		
		try {
			
			CallableStatement pstm = dbManager.getCon().prepareCall("call login(?,?,?,?,?)");
			
			pstm.setString(1, instituteId);
			pstm.setString(2, password);
			pstm.registerOutParameter(3, Types.INTEGER);
			pstm.registerOutParameter(4, Types.VARCHAR);
			pstm.registerOutParameter(5, Types.VARCHAR);
			
			pstm.executeQuery();

			user.setInstituteId(instituteId);
			user.setUserId(String.valueOf(pstm.getInt(3)));
			user.setType(pstm.getString(4));
			user.setStatus(pstm.getString(5));
			
			if(user.getUserId().equals("0") || user.getUserId()==null) {
				
			}
			else {
				if(user.getType().equals("STUDENT")) {
					
					query = "SELECT * FROM studentuser WHERE userId="+user.getUserId();

					System.out.println(query);
					
					ResultSet rs = dbManager.getSt().executeQuery(query);
					
					while(rs.next()) {
						
						user.setPersonalMail(rs.getString("personalMail"));
						user.setDOB(rs.getString("DOB"));
						user.setVerification(rs.getString("verification"));
						user.setAddedDate(rs.getString("addedDate"));
						user.setActiveDate(rs.getString("activeDate"));
						user.setLastSeen(rs.getString("lastSeen"));
						user.setActiveCount(String.valueOf(rs.getInt("activeCount")));
						user.setProfileId(String.valueOf(rs.getInt("studentId")));
						user.setProfileName(rs.getString("studentName"));
						user.setGender(rs.getString("gender"));
						user.setCollegeMail(rs.getString("collegeMail"));
						user.setPhone(rs.getString("phone"));
						user.setDeptName(rs.getString("deptName"));
						user.setPic(rs.getString("pic"));
						user.setBatch(String.valueOf(rs.getInt("batch")));
						user.setAdmissionType(rs.getString("admissionType"));
						user.setDOA(rs.getString("DOA"));
						user.setMartialStatus(rs.getString("martialStatus"));
						user.setHobby(rs.getString("hobby"));
						user.setReligion(rs.getString("religion"));
						user.setStrength(rs.getString("strength"));
						user.setNationality(rs.getString("nationality"));
						user.setLanguages(rs.getString("languages"));
						user.setBloodGroup(rs.getString("bloodGroup"));
						user.setCategory(rs.getString("category"));
						user.setNativeState(rs.getString("nativeState"));
						user.setFatherName(rs.getString("fatherName"));
						user.setMotherName(rs.getString("motherName"));
						user.setAddress(rs.getString("address"));
						
					}					
					
				}
				else if(user.getType().equals("ADMIN")) {
					
					query = "SELECT * FROM adminuser WHERE userId="+user.getUserId();

					System.out.println(query);
					
					ResultSet rs = dbManager.getSt().executeQuery(query);
					
					while(rs.next()) {
						
						user.setPersonalMail(rs.getString("personalMail"));
						user.setDOB(rs.getString("DOB"));
						user.setVerification(rs.getString("verification"));
						user.setAddedDate(rs.getString("addedDate"));
						user.setActiveDate(rs.getString("activeDate"));
						user.setLastSeen(rs.getString("lastSeen"));
						user.setActiveCount(String.valueOf(rs.getInt("activeCount")));
						user.setProfileId(String.valueOf(rs.getInt("adminId")));
						user.setProfileName(rs.getString("adminName"));
						user.setGender(rs.getString("gender"));
						user.setCollegeMail(rs.getString("collegeMail"));
						user.setPhone(rs.getString("phone"));
						user.setDeptName(rs.getString("deptName"));
						user.setPic(rs.getString("pic"));
						user.setBatch(String.valueOf(rs.getInt("batch")));
						user.setAdmissionType(rs.getString("admissionType"));
						user.setDOA(rs.getString("DOA"));
						user.setMartialStatus(rs.getString("martialStatus"));
						user.setHobby(rs.getString("hobby"));
						user.setReligion(rs.getString("religion"));
						user.setStrength(rs.getString("strength"));
						user.setNationality(rs.getString("nationality"));
						user.setLanguages(rs.getString("languages"));
						user.setBloodGroup(rs.getString("bloodGroup"));
						user.setCategory(rs.getString("category"));
						user.setNativeState(rs.getString("nativeState"));
						user.setFatherName(rs.getString("fatherName"));
						user.setMotherName(rs.getString("motherName"));
						user.setAddress(rs.getString("address"));
						
					}					
					
				}
				
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return user;
		
	}

	public static SignUpBean userSignUp(String instituteId, String personalMail, DBManager dbManager) {

		System.out.println("userSignUp");
		
		SignUpBean user = new SignUpBean();
		
		try {
			
			CallableStatement pstm = dbManager.getCon().prepareCall("call register(?,?,?,?,?,?)");
			
			pstm.setString(1, instituteId);
			pstm.setString(2, personalMail);
			pstm.registerOutParameter(3, Types.INTEGER);
			pstm.registerOutParameter(4, Types.VARCHAR);
			pstm.registerOutParameter(5, Types.VARCHAR);
			pstm.registerOutParameter(6, Types.VARCHAR);
			
			pstm.executeQuery();
			
			user.setInstituteId(instituteId);
			user.setPersonalMail(personalMail);
			user.setUserId(String.valueOf(pstm.getInt(3)));
			user.setType(pstm.getString(4));	
			user.setCode(pstm.getString(5));
			user.setStatus(pstm.getString(6));	
						
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return user;
		
	}

	public static boolean verifyUserCode(String userId, String code, DBManager dbManager) {

		System.out.println("verifyUserCode");
		
		boolean flag = false;
		
		try {
			
			ResultSet rs = dbManager.getSt().executeQuery("SELECT code FROM user WHERE userId="+userId+" AND status='INACTIVE'");
			
			while(rs.next()) {
				if(rs.getString("code").equals(code)) {

					flag = true;
					
				}
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return flag;
		
	}

	public static String getUserPersonalMail(String userId, DBManager dbManager) {

		System.out.println("getUserPersonalMail");
		
		String mail = "";
		
		try {
			
			ResultSet rs = dbManager.getSt().executeQuery("SELECT email FROM user WHERE userId="+userId);
			
			while(rs.next()) {
				mail = rs.getString("email");
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return mail;
		
	}

	public static String userInfo(String instituteId, String personalMail, DBManager dbManager) {

		System.out.println("userInfo");
		
		String password = null;
		
		try {
			
			ResultSet rs = dbManager.getSt().executeQuery("SELECT * FROM user WHERE instituteId='"+instituteId+"' AND email='"+personalMail+"'");
			
			while(rs.next()) {
				password = rs.getString("password");
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return password;
		
	}
	
	public static boolean activateUser(String userId, String password, DBManager dbManager) {

		System.out.println("activateUser");
		
		boolean flag = false;
		
		try {
			
			CallableStatement pstm = dbManager.getCon().prepareCall("call activateuser(?,?)");
			
			pstm.setInt(1, Integer.parseInt(userId));
			pstm.setString(2, password);
			
			pstm.executeQuery();
			
			flag = true;
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return flag;
		
	}

	public static boolean verifyUser(String userId, String flag1, DBManager dbManager) {

		System.out.println("verifyUser");
		
		boolean flag = false;
		
		try {
			
			CallableStatement pstm = dbManager.getCon().prepareCall("call verifyuser(?,?)");

			pstm.setInt(1, Integer.parseInt(userId));
			pstm.setInt(2, Integer.parseInt(flag1));
			
			pstm.executeQuery();
			
			flag = true;
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return flag;
		
	}
	
	public static ArrayList<StudentUser> userToVerify(DBManager dbManager) {

		System.out.println("userToVerify");
		
		ArrayList<StudentUser> su = new ArrayList<StudentUser>();
		
		try {
			
			String query = "SELECT * FROM studentuser WHERE status='ACTIVE' AND verification='PENDING'";
			ResultSet rs = dbManager.getSt().executeQuery(query);
			
			while(rs.next()) {
				
				StudentUser s = new StudentUser();
				
				s.setUserId(String.valueOf(rs.getInt("userId")));
				s.setInstituteId(rs.getString("instituteId"));
				s.setPersonalMail(rs.getString("personalMail"));
				s.setStudentName(rs.getString("studentName"));
				s.setDeptName(rs.getString("deptName"));
				s.setBatch(String.valueOf(rs.getInt("batch")));
				s.setPic(rs.getString("pic"));
				
				su.add(s);
				
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return su;
		
	}
	
	public static int totalFollowers(String userId, DBManager dbManager) {

		System.out.println("totalFollowers");
		
		int count = 0;
		
		try {
			
			ResultSet rs = dbManager.getSt().executeQuery("SELECT followers("+ userId +") AS count");
			
			while(rs.next()) {
				count = rs.getInt("count");
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return count;
		
	}
	
	public static int totalFollowing(String userId, DBManager dbManager) {

		System.out.println("totalFollowing");
		
		int count = 0;
		
		try {
			
			ResultSet rs = dbManager.getSt().executeQuery("SELECT following("+ userId +") AS count");
			
			while(rs.next()) {
				count = rs.getInt("count");
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return count;
		
	}
	
	public static int totalQuestions(String userId, DBManager dbManager) {

		System.out.println("totalQuestions");
		
		int count = 0;
		
		try {
			
			ResultSet rs = dbManager.getSt().executeQuery("SELECT questions("+ userId +") AS count");
			
			while(rs.next()) {
				count = rs.getInt("count");
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return count;
		
	}
	
	public static int totalAnswer(String userId, DBManager dbManager) {

		System.out.println("totalAnswer");
		
		int count = 0;
		
		try {
			
			ResultSet rs = dbManager.getSt().executeQuery("SELECT answer("+ userId +") AS count");
			
			while(rs.next()) {
				count = rs.getInt("count");
			}
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return count;
		
	}
	
	public static boolean newQuestionMy(String userId, String question, DBManager dbManager) {

		System.out.println("newQuestionMy");
		
		boolean flag = false;
		
		try {
			
			CallableStatement pstm = dbManager.getCon().prepareCall("call newquestionmy(?,?)");

			pstm.setInt(1, Integer.parseInt(userId));
			pstm.setString(2, question);
			
			pstm.executeQuery();
			
			flag = true;
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return flag;
		
	}
	
	public static boolean newQuestionUser(String byUserId, String toUserId, String question, DBManager dbManager) {

		System.out.println("newQuestionUser");
		
		boolean flag = false;
		
		try {
			
			CallableStatement pstm = dbManager.getCon().prepareCall("call newquestionuser(?,?,?)");

			pstm.setInt(1, Integer.parseInt(byUserId));
			pstm.setInt(2, Integer.parseInt(toUserId));
			pstm.setString(3, question);
			
			pstm.executeQuery();
			
			flag = true;
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return flag;
		
	}
	
	public static boolean newQuestionGroupTag(String byUserId, String toGroupTagId, String question, DBManager dbManager) {

		System.out.println("newQuestionGroupTag");
		
		boolean flag = false;
		
		try {
			
			CallableStatement pstm = dbManager.getCon().prepareCall("call newquestiongrouptag(?,?,?)");

			pstm.setInt(1, Integer.parseInt(byUserId));
			pstm.setInt(2, Integer.parseInt(toGroupTagId));
			pstm.setString(3, question);
			
			pstm.executeQuery();
			
			flag = true;
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
		return flag;
		
	}
	
	public static ArrayList<GroupTagFollow> userGroupTagFollow(String userId, DBManager dbManager) {

		System.out.println("userGroupTagFollow");
		
		ArrayList<GroupTagFollow> gtf = new ArrayList<GroupTagFollow>();
		
		try {
			
			ResultSet rs = dbManager.getSt().executeQuery("SELECT * FROM usergrouptagfollow WHERE userId="+userId);
			int i = 0;
			
			while(rs.next()) {
				
				GroupTagFollow groupTagFollow = new GroupTagFollow(
						String.valueOf(rs.getInt("groupTagFollowId")),
						String.valueOf(rs.getInt("groupTagId")),
						rs.getString("groupTagName"),
						String.valueOf(rs.getInt("description")),
						String.valueOf(rs.getInt("totalFollowers")),
						rs.getString("creationDate"),
						String.valueOf(rs.getInt("userId")),
						rs.getString("dateFollow")
						);
				
				gtf.add(i, groupTagFollow);
				i++;
				
			}
			
			rs.close();
			
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		return gtf;
		
	}
	
}
