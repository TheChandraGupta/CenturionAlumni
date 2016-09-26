package com.deciders.alumni.database;

import java.sql.CallableStatement;
import java.sql.SQLException;

import com.deciders.alumni.bean.User;

public class DBCreator {
	
	public static void registerStudent(User user, DBManager dbManager) {

		System.out.println("registerStudent");
		
		try {
			
			CallableStatement pstm = dbManager.getCon().prepareCall("call studentRegister(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			
			pstm.setString(1, user.getInstituteId());
			pstm.setString(2, user.getDOB());
			pstm.setString(3, user.getProfileName());
			pstm.setString(4, user.getGender());
			pstm.setString(5, user.getCollegeMail());
			pstm.setString(6, user.getPhone());
			pstm.setString(7, user.getDeptName());
			pstm.setInt(8, Integer.parseInt(user.getBatch()));
			pstm.setString(9, user.getAdmissionType());
			pstm.setString(10, user.getDOA());
			pstm.setString(11, user.getNationality());
			pstm.setString(12, user.getReligion());
			pstm.setString(13, user.getLanguages());
			pstm.setString(14, user.getBloodGroup());
			pstm.setString(15, user.getCategory());
			pstm.setString(16, user.getNativeState());
			pstm.setString(17, user.getFatherName());
			pstm.setString(18, user.getMotherName());
			pstm.setString(19, user.getAddress());
			
			pstm.executeQuery();
						
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}
	
	public static void registerAdmin(User user, DBManager dbManager) {

		System.out.println("registerAdmin");
		
		try {
			
			CallableStatement pstm = dbManager.getCon().prepareCall("call adminRegister(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			
			pstm.setString(1, user.getInstituteId());
			pstm.setString(2, user.getDOB());
			pstm.setString(3, user.getProfileName());
			pstm.setString(4, user.getGender());
			pstm.setString(5, user.getCollegeMail());
			pstm.setString(6, user.getPhone());
			pstm.setString(7, user.getDeptName());
			pstm.setInt(8, Integer.parseInt(user.getBatch()));
			pstm.setString(9, user.getAdmissionType());
			pstm.setString(10, user.getDOA());
			pstm.setString(11, user.getNationality());
			pstm.setString(12, user.getReligion());
			pstm.setString(13, user.getLanguages());
			pstm.setString(14, user.getBloodGroup());
			pstm.setString(15, user.getCategory());
			pstm.setString(16, user.getNativeState());
			pstm.setString(17, user.getFatherName());
			pstm.setString(18, user.getMotherName());
			pstm.setString(19, user.getAddress());
			
			pstm.executeQuery();
						
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

}
