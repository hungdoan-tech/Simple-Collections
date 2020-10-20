package controller;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Shoes;
import model.ShoesDAO;

public class ShoesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ShoesDAO shoesDAO;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ShoesController() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    public void init()
    {
    	 String jdbcURL = getServletContext().getInitParameter("jdbcURL");
         String jdbcUsername = getServletContext().getInitParameter("jdbcUsername");
         String jdbcPassword = getServletContext().getInitParameter("jdbcPassword");  
         shoesDAO = new ShoesDAO(jdbcURL, jdbcUsername, jdbcPassword);
    }
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		
		String action = request.getServletPath();
		try 
		{
			switch (action) 
			{
				case "/new":
		            showNewForm(request, response);
		            break;
		        case "/insert":
		            insertShoes(request, response);
		            break;
		        case "/delete":
		            deleteShoes(request, response);
		            break;
		        case "/edit":
		            showEditForm(request, response);
		            break;
		        case "/update":
		            updateShoes(request, response);
		            break;
		        case "/list":
		        	listShoes(request, response);
		            break;
		        default:
		            listShoes(request, response);
		            break;
			}
		}
		catch(SQLException e)
		{
			throw new ServletException(e);
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		// TODO Auto-generated method stub
		doGet(request, response);
	}
	
	private void listShoes(HttpServletRequest request, HttpServletResponse response) throws SQLException, ServletException, IOException 
	{
		List<Shoes> listShoes = shoesDAO.listAllShoes();
		request.setAttribute("listShoes", listShoes);
		RequestDispatcher dispatcher = request.getRequestDispatcher("ShoesList.jsp");
		dispatcher.forward(request, response);
	}
	
	private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException 
	{
		 RequestDispatcher dispatcher = request.getRequestDispatcher("ShoesForm.jsp");
	     dispatcher.forward(request, response);
	}
	
	private void showEditForm(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        Shoes existingShoes = shoesDAO.getShoes(id);
        RequestDispatcher dispatcher = request.getRequestDispatcher("ShoesForm.jsp");
        request.setAttribute("shoes", existingShoes);
        dispatcher.forward(request, response); 
    }
	
	private void insertShoes(HttpServletRequest request, HttpServletResponse response)
	            throws SQLException, IOException {
        String name = request.getParameter("name");
        String brand = request.getParameter("brand");
        float price = Float.parseFloat(request.getParameter("price"));
 
        Shoes newShoes = new Shoes(name, brand, price);
        shoesDAO.insertShoes(newShoes);
        response.sendRedirect("list");
	 }
	
	private void updateShoes(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {
		int id = Integer.parseInt(request.getParameter("id"));
		String name = request.getParameter("name");
	    String brand = request.getParameter("brand");
	    float price = Float.parseFloat(request.getParameter("price"));
	
	    Shoes newShoes = new Shoes(id, name, brand, price);
	    shoesDAO.updateShoes(newShoes);
	    response.sendRedirect("list");
	 }
	
	private void deleteShoes(HttpServletRequest request, HttpServletResponse response)
            throws SQLException, IOException {		
		int id = Integer.parseInt(request.getParameter("id"));	    
	    shoesDAO.deleteShoes(id);
	    response.sendRedirect("list");
	 }
}
