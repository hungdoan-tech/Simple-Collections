package com.learnJava.dotComBust;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class GameHelper
{
	public static final String ALPHABET = "abcdefg";
	private int gridLenght = 7;
	private int gridSize = 49;
	private int[] grid = new int[gridSize];
	private int shipCount = 0;

	public String getUserInput(String prompt)
	{
		String inputLine = null;
		System.out.print(prompt + " ");
		try
		{
			BufferedReader is = new BufferedReader(new InputStreamReader(System.in));
			inputLine = is.readLine();
			if (inputLine.length() == 0)
			{
				return null;
			}
		} catch (IOException e)
		{
			System.out.println("IOException" + e);
		}
		return inputLine.toLowerCase();
	}

	public ArrayList<String> placeShip(int size)
	{
		ArrayList<String> alphaCell = new ArrayList<String>();
		//String[] alphacoord = new String[size];
		String temp = null;
		int[] coords = new int[size];
		int attempts = 0;
		boolean success = false;
		int location = 0;
		shipCount++;
		int incr = 1;

		if ((shipCount % 2) == 1)
		{
			incr = gridLenght;
		}

		while (!success & attempts++ < 200)
		{
			location = (int) (Math.random() * gridSize);
			// System.out.print("try" + location);
			int x = 0;
			success = true;
			while (success && x < size)
			{
				if (grid[location] == 0)
				{
					coords[x++] = location;
					location += incr;
					if (location >= gridSize)
					{
						success = false;
					}
					if (x > 0 & (location % gridLenght == 0))
					{
						// System.out.print("used "+location);
						success = false;
					}
				}
			}
		}

		int x = 0;
		int row = 0;
		int column = 0;
		while (x < size)
		{
			grid[coords[x]] = 1;
			row = (int) (coords[x] / gridLenght);
			column = coords[x] % gridLenght;
			temp = String.valueOf(ALPHABET.charAt(column));
			alphaCell.add(temp.concat(Integer.toString(row)));
			x++;
		}
		return alphaCell;
	}
}
