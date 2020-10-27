package com.coreservlet.simplecrudmvc.beans;

public class Account
{
	private int id;
	private String name;
	private String gender;
	private String password;

	public Account()
	{

	}

	public Account(String name, String gender, String password)
	{
		this.name = name;
		this.gender = gender;
		this.password = password;
	}

	public Account(int id, String name, String gender, String password)
	{
		this(name, gender, password);
		this.id = id;
	}

	public int getId()
	{
		return id;
	}

	public void setId(int id)
	{
		this.id = id;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getGender()
	{
		return gender;
	}

	public void setGender(String gender)
	{
		this.gender = gender;
	}

	public String getPassword()
	{
		return password;
	}

	public void setPassword(String password)
	{
		this.password = password;
	}

}
