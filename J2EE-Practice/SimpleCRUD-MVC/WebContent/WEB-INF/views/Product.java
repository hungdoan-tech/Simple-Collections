package com.coreservlet.simplecrudmvc.beans;

public class Product
{

	private int code;
	private String name;
	private float price;

	public Product()
	{

	}

	public Product(String name, float price)
	{
		this.name = name;
		this.price = price;
	}

	public Product(int code, String name, float price)
	{
		this(name, price);
		this.code = code;
	}

	public int getCode()
	{
		return code;
	}

	public void setCode(int code)
	{
		this.code = code;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public float getPrice()
	{
		return price;
	}

	public void setPrice(float price)
	{
		this.price = price;
	}
}