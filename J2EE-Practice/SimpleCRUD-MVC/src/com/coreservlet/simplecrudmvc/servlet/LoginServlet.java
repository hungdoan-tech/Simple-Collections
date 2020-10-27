package com.coreservlet.simplecrudmvc.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.coreservlet.simplecrudmvc.beans.Account;
import com.coreservlet.simplecrudmvc.dao.AccountDAO;
import com.coreservlet.simplecrudmvc.utils.ApplicationUtils;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/login")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/loginView.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String userName = request.getParameter("username");
		String password = request.getParameter("password");
		String rememberMeStr = request.getParameter("rememberme");
		
		boolean remember = "Y".equals(rememberMeStr);
		Account user = null;
		boolean hasError = false;
		String errorString = null;
		
		if(userName == null || password == null || userName.length() == 0 || password.length()==0)
		{
			hasError = true;
			errorString = "Require username and password";
		}
		else 
		{
			Connection conn = ApplicationUtils.getStroredConnection(request);
			try 
			{
				AccountDAO accDAO = new AccountDAO();
				user = accDAO.findAccount(conn, userName, password);
				if(user == null)
				{
					hasError = true;
					errorString = "User name or password invalid";
				}
			}
			catch(SQLException e)
			{
				e.printStackTrace();
				hasError = true;
				errorString = e.getMessage();
			}
		}
		
		if(hasError)
		{
			user = new Account();
			user.setName(userName);
			user.setPassword(password);
			
			request.setAttribute("errorString", errorString);
			request.setAttribute("user", user);
			
			RequestDispatcher dispatcher = this.getServletContext().getRequestDispatcher("/WEB-INF/views/loginView.jsp");
			dispatcher.forward(request, response);
		}
		else 
		{
			HttpSession session = request.getSession();
			ApplicationUtils.storeLoginedUser(session, user);
			
			if(remember)
			{
				ApplicationUtils.storeUserCookie(response, user);
			}
			else 
			{
				ApplicationUtils.deleteUserCookie(response);
			}
			response.sendRedirect(request.getContextPath()+"/userInfo");
		}
	}
}
