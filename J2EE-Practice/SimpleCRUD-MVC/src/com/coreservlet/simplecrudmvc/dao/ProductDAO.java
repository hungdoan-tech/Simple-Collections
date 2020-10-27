package com.coreservlet.simplecrudmvc.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.coreservlet.simplecrudmvc.beans.Product;

public class ProductDAO
{

	public List<Product> queryProducts(Connection conn) throws SQLException
	{

		String sql = "Select * from Product";
		Statement stm = conn.createStatement();
		ResultSet rs = stm.executeQuery(sql);

		List<Product> listProduct = new ArrayList<Product>();
		while(rs.next())
		{
			int code = rs.getInt("Code");
			String name = rs.getString("Name");
			float price = rs.getFloat("Price");
			Product product = new Product(code, name, price);
			listProduct.add(product);
		}
		return listProduct;
	}

	public Product findProduct(Connection conn, int code) throws SQLException
	{
		String sql = "Select * from Product where Code = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, code);
		ResultSet rs = pstm.executeQuery();
		while(rs.next())
		{
			String name = rs.getString("Name");
			float price = rs.getFloat("Price");
			Product product = new Product(code, name, price);
			return product;
		}
		return null;
	}

	public int insertProduct(Connection conn, Product product) throws SQLException
	{
		String sql = "Insert into Product (Name,Price) values (?,?)";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, product.getName());
		pstm.setFloat(2, product.getPrice());
		int code = pstm.executeUpdate();
		return code;
	}

	public int updateProduct(Connection conn, Product product) throws SQLException
	{
		String sql = "Update Product set Name = ?, Price = ? where Code = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setString(1, product.getName());
		pstm.setFloat(2, product.getPrice());
		pstm.setInt(3, product.getCode());
		int code = pstm.executeUpdate();
		return code;
	}

	public void deleteProduct(Connection conn, int code) throws SQLException
	{
		String sql = "Delete From Product where Code = ?";
		PreparedStatement pstm = conn.prepareStatement(sql);
		pstm.setInt(1, code);
		pstm.executeUpdate();
	}
}
