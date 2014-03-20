package Battleship2;

import java.util.*;

import javax.swing.*;

public class Move {
	/*private static Player player = new Player();
	private static Player player2 = new Player();
	private static Computer computer = new Computer();*/
	private static boolean GameStarted = false;
	private static boolean PlayingComputer = true;
	
	public static void NewGame()
	{
		//player.reset();
		//player2.reset();
		//computer.reset();
		
		//Checks to see if a game has already started
		if(GameStarted)
		{
			int choice1 = JOptionPane.showConfirmDialog(null, 
					new JLabel("It seems a game has already started. \n"
							+ "Are you sure you want to end it?", JLabel.CENTER),
					"",
					JOptionPane.YES_NO_OPTION,
					JOptionPane.PLAIN_MESSAGE);
			
			//If the game has started
			if(choice1 == JOptionPane.YES_OPTION)
				SelectOpponent();
		}
		
		else
			SelectOpponent();
	}
	
	//Allows the player to select opponent he/she will be facing
	public static void SelectOpponent()
	{
		Object[] options = {"Player", "Computer", "Cancel"};

		//Which opponent you will be facing if you decide to restart game
		int choice2 = JOptionPane.showOptionDialog(null, 
				new JLabel("Which opponent would you like to face?", JLabel.CENTER),
				"New Game", JOptionPane.DEFAULT_OPTION, JOptionPane.PLAIN_MESSAGE,
				null, options, options[2]);
		
		//If they select a new player to face
		if(choice2 == 0)
		{
			//This will be included when using server coding
			JOptionPane.showMessageDialog(null, new JLabel("This feature hasn't been made yet.", JLabel.CENTER), 
					null, JOptionPane.WARNING_MESSAGE);
			
			GameStarted = true;
		}
		
		//If they select a computer to face
		else if(choice2 == 1)
		{
			//Rename function at later date
			//computer.constructor();
			
			GameStarted = true;
		}
	}
	
	public static void MakeAMove(int x, int y)
	{
		System.out.println("TRUE");
	}
}
