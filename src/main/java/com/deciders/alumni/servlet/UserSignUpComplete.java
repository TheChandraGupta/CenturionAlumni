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
 * Servlet implementation class UserSignUpComplete
 */
@WebServlet("/UserSignUpComplete")
public class UserSignUpComplete extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserSignUpComplete() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub

		String userId = request.getParameter("userId");
		String password = request.getParameter("password");
		
		RequestDispatcher rd = null;
		DBManager dbManager = new DBManager();
		String personalMail = DBHandler.getUserPersonalMail(userId, dbManager);
		
		if(DBHandler.activateUser(userId, password, dbManager)) {
			System.out.println("UserSignUpComplete = " + "User Sign Up Complete, Please Login Again.");
			request.setAttribute("msg", "User Sign Up Complete, Please Login Again.");
			rd = request.getRequestDispatcher("login.jsp");

			EmailSendingServlet mail =new EmailSendingServlet();
			
			String recipient = personalMail;
			String subject = "Alumni Portal : Email Verification Complete";
			String content = "Dear User,\n\n"
					+ "Your Email Id = " + personalMail + " has been successfully verified and registered.";
			
			mail.setRecipient(recipient);
			mail.setSubject(subject);
			mail.setContent(content);
			
			MailThread sendMail = new MailThread(mail);
			sendMail.start();
			
		}
		else {
			System.out.println("UserSignUpComplete = " + "Something Went wrong, Please try again later.");
			request.setAttribute("msg", "Something Went wrong, Please try again later.");
			rd = request.getRequestDispatcher("login.jsp");
		}

		dbManager.close();
		
		rd.forward(request, response);
		
	}

}
