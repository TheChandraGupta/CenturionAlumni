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
 * Servlet implementation class ForgotPassword
 */
@WebServlet("/ForgotPassword")
public class ForgotPassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ForgotPassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String instituteId = request.getParameter("instituteId");
		String personalMail = request.getParameter("email");	
		
		RequestDispatcher rd = null;
		DBManager dbManager = new DBManager();
		String password = DBHandler.userInfo(instituteId, personalMail, dbManager);
		
		if(password == null || password.equals("")) {
			System.out.println("ForgotPassword = " + "INVALID INSTITUTE ID OR EMAIL");
			request.setAttribute("msg", "INVALID INSTITUTE ID OR EMAIL");
			rd = request.getRequestDispatcher("login.jsp");
		}
		else {
			System.out.println("ForgotPassword = " + "Check Mail for Password Recovery, Else Please try After 15 Minutes.");
			request.setAttribute("msg", "Check Mail for Password Recovery, Else Please try After 15 Minutes.");
			rd = request.getRequestDispatcher("login.jsp");

			EmailSendingServlet mail =new EmailSendingServlet();
			
			String recipient = personalMail;
			String subject = "Alumni Portal : Password Recovery";
			String content = "Dear User\n\n"
					+ "Your password has been recovered\n"
					+ "Email : "+personalMail+"\n"
							+ "Password : "+password;
			
			mail.setRecipient(recipient);
			mail.setSubject(subject);
			mail.setContent(content);
			
			MailThread sendMail = new MailThread(mail);
			sendMail.start();
		}

		dbManager.close();
		
		rd.forward(request, response);
				
	}

}
