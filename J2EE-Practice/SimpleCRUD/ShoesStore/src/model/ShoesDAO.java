package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ShoesDAO {
	private String jdbcURL;
    private String jdbcUsername;
    private String jdbcPassword;
    private Connection jdbcConnection;
    
    public ShoesDAO(String jdbcURL, String jdbcUsername, String jdbcPassword) {
        this.jdbcURL = jdbcURL;
        this.jdbcUsername = jdbcUsername;
        this.jdbcPassword = jdbcPassword;
    }
    
    protected void connect() throws SQLException 
    {
    	if(this.jdbcConnection == null || this.jdbcConnection.isClosed())
    	{
    		try 
    		{
    			Class.forName("com.mysql.jdbc.Driver");
    		}
    		catch(ClassNotFoundException e) 
    		{
    			throw new SQLException(e);
    		}
    		this.jdbcConnection = DriverManager.getConnection(this.jdbcURL, this.jdbcUsername, this.jdbcPassword);
    	}
    }
    
    protected void disconnect() throws SQLException 
    {
    	if(this.jdbcConnection != null && !this.jdbcConnection.isClosed())
    	{
    		this.jdbcConnection.close();
    	}
    }
    
    public boolean insertShoes(Shoes shoes) throws SQLException 
    {
    	String sql = "INSERT INTO Shoes (Name, Brand, Price) VALUES (?, ?, ?)";
    	this.connect();
    	
    	PreparedStatement statement = this.jdbcConnection.prepareStatement(sql);
    	statement.setString(1, shoes.getName());
    	statement.setString(2, shoes.getBrand());
    	statement.setFloat(3, shoes.getPrice());
    	
    	boolean rowInserted = statement.executeUpdate() > 0;
    	statement.close();
    	this.disconnect();
    	return rowInserted;
    }
    
    public boolean deleteShoes(int id) throws SQLException 
    {
    	String sql = "DELETE FROM Shoes WHERE Id = ?";
    	this.connect();
    	
    	PreparedStatement statement = this.jdbcConnection.prepareStatement(sql);
    	statement.setInt(1, id);
    	
    	boolean rowDeleted = statement.executeUpdate() > 0;
    	statement.close();
    	this.disconnect();
    	return rowDeleted;
    }
    
    public boolean updateShoes(Shoes shoes) throws SQLException 
    {
    	String sql = "UPDATE Shoes SET Name = ?, Brand = ?, Price= ? WHERE Id = ?";
    	this.connect();
    	
    	PreparedStatement statement = this.jdbcConnection.prepareStatement(sql);
    	statement.setString(1, shoes.getName());
    	statement.setString(2, shoes.getBrand());
    	statement.setFloat(3, shoes.getPrice());
    	statement.setInt(4, shoes.getId());
    	
    	boolean rowUpdated = statement.executeUpdate() > 0;
    	statement.close();
    	this.disconnect();
    	return rowUpdated;
    }
    
    public List<Shoes> listAllShoes() throws SQLException 
    {
    	List<Shoes> listShoes = new ArrayList<>();
    	String sql = "SELECT * FROM Shoes";
    	this.connect();
    	Statement statement = this.jdbcConnection.createStatement(); 
    	ResultSet resultSet = statement.executeQuery(sql);
    	
    	while(resultSet.next())
    	{
    		int id = resultSet.getInt("Id");
    		String name = resultSet.getString("Name");
    		String brand = resultSet.getString("Brand");
    		Float price = resultSet.getFloat("Price");
    		Shoes temp = new Shoes(id,name, brand, price);
    		listShoes.add(temp);
    	}
    	resultSet.close();
    	statement.close();
    	this.disconnect();    	
    	return listShoes;
    }
    
    public Shoes getShoes(int id) throws SQLException 
    {    	
    	Shoes tempShoes= null;
    	String sql = "SELECT * FROM Shoes WHERE Id = ?";
    	this.connect();
    	PreparedStatement statement = this.jdbcConnection.prepareStatement(sql);
    	statement.setInt(1, id);
    	ResultSet resultSet = statement.executeQuery();
    	
    	if(resultSet.next())
    	{    		
    		String name = resultSet.getString("Name");
    		String brand = resultSet.getString("Brand");
    		Float price = resultSet.getFloat("Price");
    		tempShoes = new Shoes(id,name, brand, price);    		
    	}
    	resultSet.close();
    	statement.close();
    	this.disconnect();    	
    	return tempShoes;
    }
}
