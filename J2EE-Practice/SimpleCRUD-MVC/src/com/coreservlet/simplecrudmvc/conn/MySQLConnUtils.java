package com.coreservlet.simplecrudmvc.conn;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnUtils
{
	public static Connection getMySQLConnection() throws SQLException
	{
		String hostName = "localhost";
		String dbName = "SimpleStore";
		String userName = "root";
		String passWord = "Admin123*";
		return getMySQLConnection(hostName, dbName, userName, passWord);
	}

	public static Connection getMySQLConnection(String hostName, String dbName, String userName, String passWord)
			throws SQLException
	{
		try 
		{
			Class.forName("com.mysql.cj.jdbc.Driver");
		}
		catch(ClassNotFoundException e) 
		{
			throw new SQLException(e);
		}
		String connectionURL = "jdbc:mysql://" + hostName + ":3306/" + dbName;
		Connection conn = DriverManager.getConnection(connectionURL, userName, passWord);
		return conn;
	}
}
