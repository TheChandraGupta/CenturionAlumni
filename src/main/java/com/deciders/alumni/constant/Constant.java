package com.deciders.alumni.constant;

public class Constant {
	
	/*
	 * Constant for Java Email Connection via SMTP
	 */
	public static final String EMAIL_HOST = "smtp.gmail.com";
	public static final String EMAIL_PORT = "587";
	public static final String EMAIL_USER = "alumni.portal2017@gmail.com";
	public static final String EMAIL_PASS = "thedeciders";
	//public static final String EMAIL_USER = "cbcs.cit@gmail.com";
	//public static final String EMAIL_PASS = "thedeciders";
	
	/*
	 * Constants for Database Connection
	 */
	/*
	public static final String DRIVER = "com.mysql.jdbc.Driver";
	public static final String URL = "jdbc:mysql://localhost:3306/alumni";
	public static final String USER = "root";
	public static final String PASS = "root";
	*/
	public static final String DRIVER = "com.mysql.jdbc.Driver";
	//public static final String URL = "jdbc:mysql://127.13.151.2:3306/demo";
	public static final String HOST = System.getenv("OPENSHIFT_MYSQL_DB_HOST");
	public static final String PORT = System.getenv("OPENSHIFT_MYSQL_DB_PORT");
	public static final String URL = "jdbc:mysql://"+HOST+":"+PORT+"/alumni";
	public static final String USER = System.getenv("OPENSHIFT_MYSQL_DB_USERNAME");  //"adminkg4Hlnv";
	public static final String PASS = System.getenv("OPENSHIFT_MYSQL_DB_PASSWORD");  //"MSxlBfVm-HaM";

	
	/*
	 * Constant for Database Queries
	 */
	public static final String LOGIN_QUERY = "";
	
	/*
	 *  Constant for Apache Tomcat Server
	 */
	public static final String SERVER_URL = "localhost"; // http://alumni-guptas.rhcloud.com/
	public static final String SERVER_PORT = "8088"; //
	public static final String SERVER_LINK = "alumni-guptas.rhcloud.com";
	// public static final String SERVER_LINK = SERVER_URL + ":" + SERVER_PORT + "/Alumni"
	
	/*
	 * Constant for Project Directory
	 */
	public static final String PROJECT_NAME = "Alumni";
			
}
