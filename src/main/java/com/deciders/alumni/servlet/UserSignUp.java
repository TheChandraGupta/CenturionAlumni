package com.deciders.alumni.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.deciders.alumni.bean.SignUpBean;
import com.deciders.alumni.constant.Constant;
import com.deciders.alumni.database.DBHandler;
import com.deciders.alumni.database.DBManager;
import com.deciders.alumni.mail.EmailSendingServlet;
import com.deciders.alumni.mail.MailThread;

/**
 * Servlet implementation class UserSignUp
 */
@WebServlet("/UserSignUp")
public class UserSignUp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserSignUp() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String instituteId = request.getParameter("instituteid");
		String personalMail = request.getParameter("email");
		String map = "26C198FB4D";
		
		SignUpBean user = new SignUpBean();
		RequestDispatcher rd = null;
		
		DBManager dbManager = new DBManager();
		
		user = DBHandler.userSignUp(instituteId, personalMail, dbManager);
		
		if(user.getUserId().equals("0")) {
			System.out.println("USERSIGNUP = " + "INVALID INSTITUTE ID OR ALREADY SIGNED UP" +" : User = " + user);
			request.setAttribute("msg", "INVALID INSTITUTE ID OR ALREADY SIGNED UP");
			rd = request.getRequestDispatcher("login.jsp");
		}
		else {
			System.out.println("USERSIGNUP = " + "USER SIGN UP SUCCESSFUL" +" : User = " + user);
			request.setAttribute("msg", "An email sent to your new email Id, follow for next step.");
			rd = request.getRequestDispatcher("login.jsp");

			EmailSendingServlet mail =new EmailSendingServlet();
			
			String recipient = personalMail;
			String subject = "Alumni Portal : Email Verification";
			String content = "Dear User,\n\n"
					+ "Your request for registration is under progress, please check on the link below to verify your email address.\n"
					+ "Institute Id : "+user.getInstituteId()+"\n"
					+ "Email : "+personalMail+"\n"
							+ "Click Here : http://"+ Constant.SERVER_LINK +"/UserCodeVerification?"
									+ "q="+user.getUserId()+"&"
											+ "map="+user.getCode()+"&"
													+ "instituteId="+user.getInstituteId()+"&"
															+ "code="+map;
			
			// "+Constant.SERVER_URL+":"+Constant.SERVER_PORT+"/"+Constant.PROJECT_NAME+"
			
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
