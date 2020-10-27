package com.coreservlet.simplecrudmvc.filter;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.coreservlet.simplecrudmvc.beans.Account;
import com.coreservlet.simplecrudmvc.dao.AccountDAO;
import com.coreservlet.simplecrudmvc.utils.ApplicationUtils;

/**
 * Servlet Filter implementation class CookieFilter
 */
public class CookieFilter implements Filter
{
	/**
	 * Default constructor.
	 */
	public CookieFilter()
	{
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy()
	{
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException
	{
		HttpServletRequest req = (HttpServletRequest) request;
		HttpSession session = req.getSession();

		Account userInSession = ApplicationUtils.getLoginedUser(session);
		if (userInSession != null)
		{
			session.setAttribute("COOKIE_CHECKED", "CHECKED");
			chain.doFilter(request, response);
			return;
		}

		Connection conn = ApplicationUtils.getStroredConnection(request);
	
		String checked = (String) session.getAttribute("COOKIE_CHECKED");
		if (checked == null && conn != null)
		{
			String userName = ApplicationUtils.getUserNameInCookie(req);
			try
			{
				AccountDAO accDAO = new AccountDAO();
				Account user = accDAO.findAccount(conn, userName);
				ApplicationUtils.storeLoginedUser(session, user);
			} catch (SQLException e)
			{
				e.printStackTrace();
			}			
			session.setAttribute("COOKIE_CHECKED", "CHECKED");
		}
		chain.doFilter(request, response);
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException
	{
		// TODO Auto-generated method stub
	}
}
