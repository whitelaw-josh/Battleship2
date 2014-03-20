/*
 * Josh Whitelaw
 * Creator of Second BattleShip
 * Date Crated: 3/17/2014
 */
package Battleship2;

import java.util.*;
import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class Board extends JFrame{
	private static ArrayList<JButton> optionButtons= new ArrayList();
	private static ArrayList<String> labels = new ArrayList();
	private static JFrame frame = new Board();
	
	public Board(){
		JPanel window = new JPanel();
		window.setLayout(new BoxLayout(window, BoxLayout.X_AXIS));
		
		//This board displays your own board
		JPanel playerBoard = new JPanel();
		playerBoard.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		LabelConstructor();
		
		playerBoard.add(new JButton());
		playerBoard.add(new JButton());
		window.add(playerBoard);
		
		//This board displays the moves that were made
		JPanel enemyBoard = new JPanel();
		enemyBoard.setLayout(new GridLayout(11,11,1,1));

		//Counters to set specific values for buttons
		int xCount = 0;
		int yCount = 0;
				
		for(int a = 0; a < 121; a++)
		{
			JButton button = new JButton();
			
			button.setSize(50,50);//FIX DIS SHIT
			
			if(a!=0)
			{
				//Sets the letter labeling for enemy board
				if(a < 11)
					button.setLabel(labels.get(a-1));
				
				//Sets the number labeling for enemy board
				else if(a%11==0)
					button.setLabel(labels.get(((a-1)/11)+10)); //FIGURE OUT PROBLEM HERE
				
				//Adds action listeners to specific buttons
				else
				{
					final int xFinal = xCount;
					final int yFinal = yCount;
					//Will make a move if clicked upon
					button.addActionListener(new ActionListener()
					{
						public void actionPerformed (ActionEvent e)
						{
							int x = xFinal, y = yFinal;
							Move.MakeAMove(x, y);
						}
					});
					
					if(xCount % 9 == 0 && xCount != 0)
					{
						xCount = 0;
						yCount++;
					}
					
					else
					{
						xCount++;
					}
				}
			}
			
			enemyBoard.add(button);
		}
		
		window.add(enemyBoard);
		window.add(Box.createHorizontalGlue());
		
		//This adds buttons with options
		JPanel options = new JPanel();
		options.setLayout(new GridLayout(2,1,10,10));
		OptionButtonConstructor();
		
		for(int a = 0; a < optionButtons.size(); a++)
			options.add(optionButtons.get(a));
		
		window.add(options);
		
		add(window);
	}
	
	public static void main(String[] args)
	{
		frame.setSize(new Dimension(1000,500));
		frame.setTitle("Battleship");
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(EXIT_ON_CLOSE);
		frame.setVisible(true);
	}	
	
	//Makes buttons for the options bar
	private static void OptionButtonConstructor(){
		JButton NewGame = new JButton("New Game");
		JButton Quit = new JButton("Quit");
		
		NewGame.setSize(100,200);  //FIX THIS
		Quit.setSize(100,200);
		
		//Starts a New Game
		NewGame.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				Move.NewGame();
			}
		});
		
		//Quits the frame
		Quit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				int choice = JOptionPane.showConfirmDialog(null, 
						new JLabel("Are you sure you want to quit?", JLabel.CENTER),
						"",
						JOptionPane.YES_NO_OPTION,
						JOptionPane.PLAIN_MESSAGE);

				if(choice == JOptionPane.YES_OPTION)
					frame.dispose();
			}
		});
		
		optionButtons.add(NewGame);
		optionButtons.add(Quit);
	}
	
	//Constructs the labels for the board
	private static void LabelConstructor(){
		labels.add("A");
		labels.add("B");
		labels.add("C");
		labels.add("D");
		labels.add("E");
		labels.add("F");
		labels.add("G");
		labels.add("H");
		labels.add("I");
		labels.add("J");
		
		for(int a = 1; a <= 10; a++)
			labels.add(""+a);
	}

}
