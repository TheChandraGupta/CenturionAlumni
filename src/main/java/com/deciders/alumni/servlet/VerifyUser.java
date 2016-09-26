package com.deciders.alumni.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.deciders.alumni.database.DBHandler;
import com.deciders.alumni.database.DBManager;
import com.deciders.alumni.mail.EmailSendingServlet;
import com.deciders.alumni.mail.MailThread;

/**
 * Servlet implementation class VerifyUser
 */
@WebServlet("/VerifyUser")
public class VerifyUser extends HttpServlet {
	
       
    /**
	 * 
	 */
	private static final long serialVersionUID = 1676329197469546234L;

	/**
     * @see HttpServlet#HttpServlet()
     */
    public VerifyUser() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String userId = request.getParameter("userId");
		String instituteId = request.getParameter("instituteId");
		String personalMail = request.getParameter("personalMail");
		String studentName = request.getParameter("studentName");
		String flag = request.getParameter("flag");
		String status = "";		
		
		if(flag.equals("0")) {
			status = "VERIFIED";
		}
		else {
			status = "REJECTED";
		}
		
		RequestDispatcher rd = null;
		
		DBManager dbManager = new DBManager();
		
		if(DBHandler.verifyUser(userId, flag, dbManager)) {
			System.out.println("VERIFY USER = " + "Verification Successful");
			request.setAttribute("VERIFY USER", "Verification Successful");
			rd = request.getRequestDispatcher("adminhome.jsp");
			
			EmailSendingServlet mail =new EmailSendingServlet();
			
			String recipient = personalMail;
			String subject = "Alumni Portal : Account Verification";
			String content = "Dear "+studentName+",\n\n"
					+ "Your request for registration is "+status+"."
							+ "\n\nFor any query please contact administration.";
			
			mail.setRecipient(recipient);
			mail.setSubject(subject);
			mail.setContent(content);
			
			MailThread sendMail = new MailThread(mail);
			sendMail.start();
			
		}
		else {
			System.out.println("VERIFY USER = " + "Verification Unuccessful");
			request.setAttribute("VERIFY USER", "Verification Unsuccessful");
			rd = request.getRequestDispatcher("adminhome.jsp");
		}
		
		dbManager.close();
		
		rd.forward(request, response);
		
	}

}
