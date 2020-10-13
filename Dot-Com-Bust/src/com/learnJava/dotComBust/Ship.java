package com.learnJava.dotComBust;

import java.util.ArrayList;

public class Ship
{
	private ArrayList<String> locationCell;
	private String name;

	public String getName()
	{
		return name;
	}
	
	public void setName(String name)
	{
		this.name = name;
	}

	public void setLocationCell(ArrayList<String> locationCell)
	{
		this.locationCell = locationCell;
	}

	public Ship(String name)
	{
		this.name = name;
	}

	public String check(String userInput)
	{
		String result = "miss";
		int index = locationCell.indexOf(userInput);
		if (index > 0)
		{
			locationCell.remove(index);
			if (locationCell.isEmpty())
			{
				result = "kill";
			} else
			{
				result = "hit";
			}
		}
		return result;
	}
}
