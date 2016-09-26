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

/**
 * Servlet implementation class UserCodeVerification
 */
@WebServlet("/UserCodeVerification")
public class UserCodeVerification extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserCodeVerification() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String userId = request.getParameter("q");
		String code = request.getParameter("map");
		
		RequestDispatcher rd = null;
		DBManager dbManager = new DBManager();
		
		if(DBHandler.verifyUserCode(userId, code, dbManager)) {
			System.out.println("UserCodeVerification = " + "CODE VERIFICATION COMPLETE");
			request.setAttribute("msg", "CODE VERIFICATION COMPLETE");
			request.setAttribute("userId", userId);
			rd = request.getRequestDispatcher("signupcomplete.jsp");
		}
		else {
			System.out.println("UserCodeVerification = " + "EXPIRED VERIFICATION LINK");
			request.setAttribute("msg", "EXPIRED VERIFICATION LINK");
			rd = request.getRequestDispatcher("login.jsp");
		}

		dbManager.close();
		
		rd.forward(request, response);
		
	}

}
