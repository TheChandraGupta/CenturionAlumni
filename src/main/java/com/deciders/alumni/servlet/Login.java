package com.deciders.alumni.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.deciders.alumni.bean.GroupTagFollow;
import com.deciders.alumni.bean.User;
import com.deciders.alumni.database.DBHandler;
import com.deciders.alumni.database.DBManager;

/**
 * Servlet implementation class Login
 */
@WebServlet("/Login")
public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Login() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		String instituteId = request.getParameter("instituteId");
		String password = request.getParameter("password");
		
		User user = new User();
		RequestDispatcher rd = null;
		
		DBManager dbManager = new DBManager();
		
		user = DBHandler.login(instituteId, password, dbManager);
		
		if(user.getUserId().equals("0")) {
			System.out.println("LOGIN = " + "INVALID INSTITUTE ID OR PASSWORD" +" : User = " + user);
			request.setAttribute("msg", "INVALID INSTITUTE ID OR PASSWORD");
			rd = request.getRequestDispatcher("login.jsp");
		}
		else {
			if(user.getVerification().equals("VERIFIED")) {
				
				ArrayList<GroupTagFollow> gtf = DBHandler.userGroupTagFollow(user.getUserId(), dbManager);
				
				HttpSession session = request.getSession();
				session.setAttribute("user", user);
				session.setAttribute("groupTagFollow", gtf);

				System.out.println("LOGIN = " + "User = " + session.getAttribute("user"));

				if(user.getType().equals("ADMIN")) {
					System.out.println("LOGIN = " + "LOGIN SUCESSFUL - ADMIN" +" : User = " + user);
					request.setAttribute("msg", "LOGIN SUCESSFUL - ADMIN");
					rd = request.getRequestDispatcher("adminhome.jsp");					
				}
				else if(user.getType().equals("STUDENT")) {
					System.out.println("LOGIN = " + "LOGIN SUCESSFUL - STUDENT" +" : User = " + user);
					request.setAttribute("msg", "LOGIN SUCESSFUL - STUDENT");
					rd = request.getRequestDispatcher("index.jsp");
				}
			}
			else {
				System.out.println("LOGIN = " + "INACTIVE ACCOUNT" +" : User = " + user);
				request.setAttribute("msg", "INACTIVE ACCOUNT");
				rd = request.getRequestDispatcher("errorpage.jsp");
			}
		}

		dbManager.close();
		
		rd.forward(request, response);
		
	}

}
