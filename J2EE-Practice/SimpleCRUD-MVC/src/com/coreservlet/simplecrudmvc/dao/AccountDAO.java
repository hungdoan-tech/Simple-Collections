package com.coreservlet.simplecrudmvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.coreservlet.simplecrudmvc.beans.Account;

public class AccountDAO
{

	public Account findAccount(Connection conn, String userName, String password) throws SQLException
	{

		String sql = "Select Name, Password, Gender from Account where Name= ? and Password=?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, userName);
		pstm.setString(2, password);
		ResultSet rs = pstm.executeQuery();

		while(rs.next())
		{
			String gender = rs.getString("Gender");
			Account acc = new Account(userName, gender, password);
			return acc;
		}
		return null;
	}

	public Account findAccount(Connection conn, String userName) throws SQLException
	{

		String sql = "Select Name, Password, Gender from Account where Name= ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, userName);
		ResultSet rs = pstm.executeQuery();

		while(rs.next())
		{
			String gender = rs.getString("Gender");
			String password = rs.getString("Password");
			Account acc = new Account(userName, gender, password);
			return acc;
		}
		return null;
	}
}
