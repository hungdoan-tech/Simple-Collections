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

import com.coreservlet.simplecrudmvc.beans.Product;
import com.coreservlet.simplecrudmvc.dao.ProductDAO;
import com.coreservlet.simplecrudmvc.utils.ApplicationUtils;

/**
 * Servlet implementation class CreateProduct
 */
@WebServlet("/createProduct")
public class CreateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CreateProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		RequestDispatcher dispatcher = request.getServletContext()
                .getRequestDispatcher("/WEB-INF/views/createProductView.jsp");
        dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Connection conn = ApplicationUtils.getStroredConnection(request);
		String name = (String) request.getParameter("name");
		String priceStr = (String) request.getParameter("price");
		
		float price = 0;
		try 
		{
			price = Float.parseFloat(priceStr);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		Product product = new Product(name,price);
		
		try 
		{
			ProductDAO prdDAO = new ProductDAO();
			prdDAO.insertProduct(conn, product);
		}
		catch(SQLException e) 
		{
			System.out.println(e.getMessage());
		}		
		
		request.setAttribute("product", product);
		response.sendRedirect(request.getContextPath()+"/productList");
	}
}
