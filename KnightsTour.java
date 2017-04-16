/**
 * @student.info
 *<BR> Name:          Hammad Qureshi
 *<BR> Date:          02-13-2016
 *<BR> Period:        6
 *<BR> Assignment:    Lesson23
 *<BR> Description:   Create a program that can take a knight and move it to every square on a chess board once.
 *<BR> Cite Sources:  None
 */

import java.util.Random;
public class KnightsTour
{
	private int [][] board = new int [9][9];
	private boolean [] taken = new boolean[9];
	private int [] horizontalMoves = {0, 1, 2, 2, 1, -1, -2, -2, -1};
	private int [] verticalMoves = {0, -2, -1, 1, 2, 2, 1, -1, -2};
	private int xPos, yPos;
	private int count;
	
	public KnightsTour()
	{
		xPos = 1;
		yPos = 1;
		count = 1;
		board[1][1] = 1;
	}
	
	public void doKnightsTour()
	{
		while(moveKnight() == true)
		{
		
		}
	}
	
	private boolean moveKnight()
	{
		Random Dice = new Random();
		int random = 0;
		boolean moveMade = false;
		
		if(count < 64)
		{
			if(allTakenNearby() == false)
			{
				while(moveMade == false)
				{
					random = Dice.nextInt(8) + 1;
					
					if(taken[random] == false)
					{
						xPos += horizontalMoves[random];
						yPos += verticalMoves[random];
						count++;
						board[yPos][xPos] = count;
						moveMade = true;
					}
				}
			}
		}
		return moveMade;
	}
	
	private boolean allTakenNearby()
	{
		boolean allFilled = true;
		int tempX, tempY;
		
		for(int i = 1; i < 9; i++)
		{
			taken[i] = false;
		}	
		
		for(int i = 1; i < 9; i++)
		{
			tempX = xPos + horizontalMoves[i];
			tempY = yPos + verticalMoves[i];
			
			if(tempX >= 1 && tempX <= 8 && tempY >= 1 && tempY <= 8)
			{
				if(board[tempY][tempX] > 0)
				{
					taken[i] = true;
				}
				else
				{
					allFilled = false;
				}
			}
			else
			{
				taken[i] = true;
			}
		}
		return allFilled;
	}
	
	public void printKnightsTour()
	{
		int squareCount = 0;
		
		for(yPos = 1; yPos < 9; yPos++)
		{
			for(xPos = 1; xPos < 9; xPos++)
			{
				if(board[yPos][xPos] == 0)
				{
					System.out.print("--");
				}
				else if(board[yPos][xPos]  < 9)
				{
					System.out.print("0" + board[yPos][xPos]);
					squareCount++;
				}
				else
				{
					System.out.print(board[yPos][xPos]);
					squareCount++;
				}
				System.out.print("  ");
			}
			System.out.println();
			System.out.println();
		}
		System.out.println();
		System.out.println("Number of Squares visited is: " + squareCount);
	}
}

/*
RUN OUTPUT:

*/