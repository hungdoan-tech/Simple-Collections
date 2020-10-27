package com.coreservlet.simplecrudmvc.filter;

import java.io.IOException;
import java.sql.Connection;
import java.util.Collection;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.coreservlet.simplecrudmvc.conn.ConnectionUtils;
import com.coreservlet.simplecrudmvc.utils.ApplicationUtils;

/**
 * Servlet Filter implementation class JDBCFilter
 */
public class JDBCFilter implements Filter
{

	/**
	 * Default constructor.
	 */
	public JDBCFilter()
	{
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see Filter#init(FilterConfig)
	 */
	public void init(FilterConfig fConfig) throws ServletException
	{
		// TODO Auto-generated method stub
	}

	/**
	 * @see Filter#destroy()
	 */
	public void destroy()
	{
		// TODO Auto-generated method stub
	}

	private boolean needJDBC(HttpServletRequest request)
	{
		System.out.println("JDBC Filter");
		String servletPath = request.getServletPath();
		String pathInfo = request.getPathInfo();

		String urlPattern = servletPath;

		if (pathInfo != null)
		{
			urlPattern = servletPath + "/*";
		}
		Map<String, ? extends ServletRegistration> servletRegistrations = request.getServletContext()
				.getServletRegistrations();
		Collection<? extends ServletRegistration> values = servletRegistrations.values();
		for (ServletRegistration sr : values)
		{
			Collection<String> mappings = sr.getMappings();
			if (mappings.contains(urlPattern))
			{
				return true;
			}
		}
		return false;
	}

	/**
	 * @see Filter#doFilter(ServletRequest, ServletResponse, FilterChain)
	 */
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException
	{
		HttpServletRequest req = (HttpServletRequest) request;
		if (this.needJDBC(req))
		{

			System.out.println("Open Connection for: " + req.getServletPath());

			Connection conn = null;
			try
			{
				conn = ConnectionUtils.getConnection();
				conn.setAutoCommit(false);
				ApplicationUtils.storeConnection(request, conn);
				chain.doFilter(request, response);
				conn.commit();
			} catch (Exception e)
			{
				e.printStackTrace();
				ConnectionUtils.rollBackTransaction(conn);
				throw new ServletException();
			} finally
			{
				ConnectionUtils.closeConnection(conn);
			}
		} else
		{
			chain.doFilter(request, response);
		}
	}
}
