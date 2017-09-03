import java.util.*;
import java.io.*;


public class P2A3_Yellajosyula_GAME_ryellajo
{

	private int numberOfTimes;
	private P2A2_Yellajosyula_PLAYER_ryellajo[] players;
	private P2A2_Yellajosyula_QUESTION_ryellajo question;
	private int results[];


	public P2A3_Yellajosyula_GAME_ryellajo()
	{
		numberOfTimes = 0;
		players = new P2A2_Yellajosyula_PLAYER_ryellajo[numberOfTimes];
		question = new P2A2_Yellajosyula_QUESTION_ryellajo() ;

	}


	public P2A3_Yellajosyula_GAME_ryellajo(int n,String filename)throws FileNotFoundException
	{
		numberOfTimes = n;
		int lineNumber =generateNumb();
		try{
			players = new P2A2_Yellajosyula_PLAYER_ryellajo[numberOfTimes];
			question = new P2A2_Yellajosyula_QUESTION_ryellajo(filename,lineNumber);
			setPlayers(n,question.getWord().length());
		
			}
		catch(Exception e)
		{
			System.out.println(e);
		}
	}

	//Method that generates a randfom number between 1 an d6 and returns the value
	public static int generateNumb()
	{ 
		   //generates a random number between 1 and 2 considering a 6 faced dice
		   Random rand = new Random();
		   int  n = rand.nextInt(4) + 1;
		   return n;                                                        
	}

	public void setNumberOfTimes(int n)
	{
		numberOfTimes = n;

	}
	public int getNumberOfTimes()
	{
		return numberOfTimes;

	}

	

	public void setQuestion(String fileNme)throws FileNotFoundException
	{
		
		try{
			question = new P2A2_Yellajosyula_QUESTION_ryellajo(fileNme,generateNumb());
			}
		catch(Exception e)
		{
			System.out.println(e);
		}

	}
	

	public P2A2_Yellajosyula_QUESTION_ryellajo getQuestion()
	{
		
		return question;
	}

	public P2A2_Yellajosyula_PLAYER_ryellajo[] getPlayers()
	{
		return players;

	}

	public void setPlayers(int n,int wordLength)
	{
		players = new P2A2_Yellajosyula_PLAYER_ryellajo[n];
		
		for (int i=0;i<n;i++)
		{
		 players[i] = new P2A2_Yellajosyula_PLAYER_ryellajo(wordLength);
	
		}

	}
	
	public void play(boolean autoplay)
	{

		System.out.println("\n---------------------------------------------------------------------------\n");
				

		System.out.println("\n \n Here is your hint\t"+ question.getDescription()+"\t");
	
		displayValues(autoplay);


	}


	public void displayValues(boolean autoplay)
	{

	boolean repeat = true;

	if(!autoplay)
	{	System.out.println("\n ************************************************************************ \n \n");
		
		while(repeat)
		{	
			for(int i=0;i<players.length;i++)
			{	
				System.out.println("\n **********User Properties values before the guess************ \n");
				players[i].getProperties(i+1);

				repeat = setValues(players[i]);
				players[i].exitGame = !repeat;

				System.out.println("******************User Properties values after the guess**********");
				players[i].getProperties(i+1);


				if(players[i].exitGame)
				{
				System.out.println("Exiting the game!");
				if(!autoplay)
				return;
				}
			}

			
		}
				

		System.out.println("\n ************************************************************************ \n \n");
	}
		else
		{

			while(repeat)
			{	

					for(int i=0;i<players.length;i++)
					{	
						System.out.println("\n **********User Properties values before the guess************ \n");
						players[i].getProperties(i+1);

						repeat = setAutoplayValues(players[i],i);
						players[i].exitGame = !repeat;

						System.out.println("******************User Properties values after the guess**********");
						players[i].getProperties(i+1);


						if(players[i].exitGame)
						{
						System.out.println("Exiting the game!");

						return;
						}
			
					}

			}	
		}

}
	public boolean setAutoplayValues(P2A2_Yellajosyula_PLAYER_ryellajo player,int gameNumber)
	{

		int count = 0;

			
		char ch = getRandomChar();


	    //Sets user object  word field to the input provided by user
	    player.compare(question,ch);
			
		
		count = player.getnoOfTicks();

		//sets the bomb color
		player.setColor(count);


				if(count==6)
				{
					player.setGameStatus(false);
					System.out.println("\n \n ----------------------------------------------------\n\n");	
					System.out.println("BOOM!!!! YOU FAILED TO UNLOCK THE WORD AND THE BOMB EXPLODED");
					System.out.println("\n \n ----------------------------------------------------\n\n");

					
					return player.getGameStatus();


				}

				else if(player.verify(question))
					{
						System.out.println("\n \n ----------------------------------------------------\n\n");	
						System.out.println("Congrats!!! You won and the secret word is \t"+player.getWord()+"\n\n");
						System.out.println("\n \n ----------------------------------------------------\n\n");
					
						player.setWinStatus(true);
						return player.getGameStatus();

					}
			

			

			return player.getGameStatus();
	

	}

	public char getRandomChar()
	{

			Random num = new Random();
			return (char)(num.nextInt(26) + 'a');


	}
	public boolean setValues(P2A2_Yellajosyula_PLAYER_ryellajo player)
	{
		
		StringBuilder sb = new StringBuilder();
		int count = 0;


		Scanner s = new Scanner(System.in);

		System.out.println("Make a guess!!\n");
		System.out.println("************************************************************************************* \n");

			
		String userInput = s.nextLine().toLowerCase();



	     if(player.equals(userInput,question))
	      {
	        	System.out.println("You got it right!!! Congrats!!");
	        	return player.getGameStatus();

	       }

	       else
	       {

	        char temp[] = userInput.toCharArray();


	        for(int i=0;i<temp.length;i++)
	        //Sets user object  word field to the input provided by user
	        player.compare(question,temp[i]);
			
		
			count = player.getnoOfTicks();

			//sets the bomb color
			player.setColor(count);


				if(count==6)
				{
					player.setGameStatus(false);
					System.out.println("\n \n ----------------------------------------------------\n\n");	
					System.out.println("BOOM!!!! YOU FAILED TO UNLOCK THE WORD AND THE BOMB EXPLODED");
					return player.getGameStatus();


				}

				else if(player.verify(question))
					{
						System.out.println("\n \n ----------------------------------------------------\n\n");	
						System.out.println("Congrats!!! You won and the secret word is \t"+player.getWord()+"\n\n");
						player.setWinStatus(true);
						return player.getGameStatus();

					}
			

			}

			return player.getGameStatus();
	}
}