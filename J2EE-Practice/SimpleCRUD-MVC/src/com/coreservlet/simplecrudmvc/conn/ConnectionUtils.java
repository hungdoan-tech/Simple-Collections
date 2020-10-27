package com.coreservlet.simplecrudmvc.conn;

import java.sql.Connection;
import java.sql.SQLException;

public class ConnectionUtils
{

	public static Connection getConnection() throws SQLException
	{
		return MySQLConnUtils.getMySQLConnection();
	}

	public static void closeConnection(Connection conn)
	{
		try
		{
			conn.close();
		} catch (Exception e)
		{
			System.out.println(e);
		}
	}

	public static void rollBackTransaction(Connection conn)
	{
		try
		{
			conn.rollback();
		} catch (Exception e)
		{
			System.out.println(e);
		}
	}
}
