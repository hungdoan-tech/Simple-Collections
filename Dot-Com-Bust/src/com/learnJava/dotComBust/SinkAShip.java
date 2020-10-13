package com.learnJava.dotComBust;

import java.util.ArrayList;

public class SinkAShip
{
	private GameHelper helper;
	private int numOfShots;
	private ArrayList<Ship> shipList;

	public void setUpGame()
	{
		for (int i = 0; i < 3; i++)
		{
			Ship tempShip = new Ship("Battle Ship" + i);
			this.shipList.add(tempShip);
		}
		
		System.out.println("Your goal is to sink three ship");
		for (int i = 0; i < 3; i++)
		{
			System.out.print(this.shipList.get(i).getName()+" "); 
		}
		
		for(Ship ShipSet: this.shipList)
		{
			ArrayList<String> newLocation = helper.placeShip(3);
			ShipSet.setLocationCell(newLocation);
		}
	}

	public void startPlaying()
	{
		while (!this.shipList.isEmpty())
		{
			String userGuess = helper.getUserInput("Enter a guess");
			checkUserShot(userGuess);
		}
		finishGame();
	}

	public void checkUserShot(String userShot)
	{
		this.numOfShots++;
		String result = "miss";
		
		for(Ship shipToTest : shipList)
		{
			result = shipToTest.check(userShot);
			if(result.equals("hit"))
			{
				break;
			}
			else 
			{
				shipList.remove(shipToTest);
				break;
			}
		}
		System.out.println(result);
	}

	public void finishGame()
	{
		System.out.println("Game over");
		if (this.numOfShots < 18)
		{
			System.out.println("It only tool you "+ this.numOfShots +" guesses");
			System.out.println("You did it very well");
		} else
		{
			System.out.println("Took you too long enough. "+ this.numOfShots +" guesses");
			System.out.println("Just finish the game ! You may wanna try again to get a better score ?");
		}
	}
	
	public static void main(String[] args)
	{
		SinkAShip game = new SinkAShip();
		game.setUpGame();
		game.startPlaying();
	}
}
