package com.coreservlet.models;

public class PTBac2
{
	private int a;
	private int b;
	private int c;
	
	public PTBac2()
	{
		
	}
	public PTBac2(int a, int b, int c)
	{
		this.a = a;
		this.b = b;
		this.c = c;
	}
	
	public int getA()
	{
		return a;
	}
	public void setA(int a)
	{
		this.a = a;
	}
	public int getB()
	{
		return b;
	}
	public void setB(int b)
	{
		this.b = b;
	}
	public int getC()
	{
		return c;
	}
	public void setC(int c)
	{
		this.c = c;
	}
	
	public String GPT() 
	{
		if(this.a == 0)
		{
			if(b==0)
			{
				if(c==0)
				{
					return "Vo so nghiem"; 
				}				
				return "Vo nghiem";	
			}
			else 
			{
				return String.valueOf((-c)/b);
			}
		}
		else 
		{
			float delta = b*b - 4*a*c;
			
			if(delta <0)
			{
				return "Vo nghiem";
			}
			else 
			{
				if(delta==0)
				{
					float result = (-this.b)/(2*this.a);
					StringBuilder resultString  = new StringBuilder("");
					resultString.append("Phuong trinh co nghiem kep la: ");
					resultString.append(result);
					return resultString.toString();
				}
				float firstResult = (float) ((-this.b + Math.sqrt(delta))/(2*this.a));
				float secondResult = (float) ((-this.b - Math.sqrt(delta))/(2*this.a));
				StringBuilder resultString  = new StringBuilder("");
				resultString.append("Phuong trinh co 2 nghiem lan luot la: ");
				resultString.append(firstResult + " va ");
				resultString.append(secondResult);
				return resultString.toString(); 
			}
		}
	}
}
