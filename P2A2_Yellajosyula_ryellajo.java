import java.util.Scanner;   // Needed to use Scanner class
import java.io.*; 
import java.util.Random;

/**
  Author's Name: Rajya Laxmi Yellajosyula
  Creation day: June 8th 2017
  Last modification day: June 8th 2017
  This program illustrates the use of classes,constructors,mutators and accessors methods
*/

public class P2A2_Yellajosyula_ryellajo
{

	public static void main(String args[]) throws IOException
   {

     	
	//Declaring required variables and array to hold user file input
	String fileNme,str;

	//Calling method to welcome the user and provide instructions
	welcome();

	//Creating a scanner object to read user inputs
	Scanner in = new Scanner(System.in);
	System.out.println("enter the input file");
	//Accepting user inputs
   	fileNme = in.nextLine();

   	boolean repeat = true;

   	while(repeat)
   	{	
   		System.out.println("Do you wish to play? YES or NO");
   		str = in.nextLine();

   		if(str.equals("NO")||str.equals("no"))
   			System.exit(1);
   		else

   			while(str.equals("YES")||str.equals("yes"))
   			userChoice(fileNme,in);
   			
	}	


	}

public static void userChoice(String fileNme,Scanner in) throws FileNotFoundException,IOException
{

	//Variable to store the line number of the word chosen randomly from the input file
   	int n = generateNumb();
   	//variables to holder user choice for mode of play and the number of players
	int userChoice,number=0;

		
	P2A2_Yellajosyula_QUESTION_ryellajo question = new P2A2_Yellajosyula_QUESTION_ryellajo(fileNme,n);
	String word =question.getWord();
	String hint = question.getDescription();
	int wordLength = word.length();
	boolean repeat = true;

	while(repeat)
	{

	System.out.println("\n---------------------------------------------------------------------------\n");



	//Creating multiple players
	System.out.println("\nEnter 1 for uni player mode and 2 for multi player mode.0 to exit \n");
	
	 userChoice = in.nextInt();

	if((userChoice!=1)&&(userChoice!=2))
	{
		System.out.println("Invalid Input.Exiting");
		number=0;
		System.exit(1);
	}
	if(userChoice ==1)
	{
		number = 1;

	}

	else if(userChoice ==2)
	{	
		System.out.println("Enter the number of players");
		number = in.nextInt();
	}

	P2A2_Yellajosyula_PLAYER_ryellajo[] players = new P2A2_Yellajosyula_PLAYER_ryellajo[number];
	

	for (int i=0;i<number;i++)
	{
	 players[i] = new P2A2_Yellajosyula_PLAYER_ryellajo(wordLength);
	
	}

	System.out.println("\n---------------------------------------------------------------------------\n");

	System.out.println("Number of players eligible to play\t"+players.length);

	System.out.println("\n---------------------------------------------------------------------------\n");

	System.out.println("\n \n Here is your hint\t"+hint+"\t");
	
	chanceGamePlay(question,players);

		System.out.println("Enter 0 to exit.Else press 1.Only numbers are allowed");
					
		if(in.nextInt()==0)
			System.exit(1);


		}


}






public static void chanceGamePlay(P2A2_Yellajosyula_QUESTION_ryellajo ques,P2A2_Yellajosyula_PLAYER_ryellajo[] players)
{

	System.out.println("\n ************************************************************************ \n \n");
	boolean repeat = true;

	while(repeat)
	{	
		for(int i=0;i<players.length;i++)
		{	
			System.out.println("\n **********User Properties values before the guess************ \n");
			players[i].getProperties(i+1);

			repeat = gamePlay(ques,players[i]);
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
			

	System.out.println("\n ************************************************************************ \n \n");
	

}




public static boolean gamePlay(P2A2_Yellajosyula_QUESTION_ryellajo ques,P2A2_Yellajosyula_PLAYER_ryellajo player)
{


	
	StringBuilder sb = new StringBuilder();
	int count = 0;


	Scanner s = new Scanner(System.in);

	System.out.println("Make a guess!!\n");
	System.out.println("************************************************************************************* \n");

		
	String userInput = s.nextLine().toLowerCase();



      if(player.equals(userInput,ques))
        {
        	System.out.println("You got it right!!! Congrats!!");
        	return player.getGameStatus();

        }

        else
        {

        char temp[] = userInput.toCharArray();


        for(int i=0;i<temp.length;i++)
        //Sets user object  word field to the input provided by user
        player.compare(ques,temp[i]);
		
	
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

		else if(player.verify(ques))
			{
				System.out.println("\n \n ----------------------------------------------------\n\n");	
				System.out.println("Congrats!!! You won and the secret word is \t"+player.getWord()+"\n\n");
				return player.getGameStatus();

			}

		}


return player.getGameStatus();
}



//Method that generates a randfom number between 1 an d6 and returns the value
public static int generateNumb()
{ 
	   //generates a random number between 1 and 2 considering a 6 faced dice
	   Random rand = new Random();
	   int  n = rand.nextInt(4) + 1;
	   return n;                                                        
}

//Static method that takes user name as inout and prints a customised welcome message	
public static void welcome()
{

		Scanner in = new Scanner(System.in);
		System.out.println("Hi! Please enter your name");

		String s = in.nextLine();
		System.out.println("Welcome "+s+"!\n");
		
		System.out.println("Below are the instructions of this interesting game ChipARoonie!\n");

		System.out.println("Shall we start? YES or NO ?\n");

		
		String choice = in.nextLine();

				if(choice.equals("YES")||choice.equals("yes"))
				{
					System.out.println("Here are the instructions\nThis is a game to guess a secret word using the provided hint.\n");
					System.out.println("For each round of the game,you are prompted to input a guessed letter to see if that letter is in the secret word\n");
					System.out.println("If the guessed letter is contained in the secret word, you win that round.\n\nIf your guessed letter is not in the secret word:\n\n the guessed word thus far is printed (consisting of blank underscores and any correctly guessed letters)\n and you earn a tick with condition that you can accumulate upto 6 ticks.\n");
					System.out.println("Each tick will correspond to the bomb exploding sooner, for each incorrectly guessed letter:\n");
					System.out.println("1 tick = red \n");
					System.out.println("2 ticks = orange\n");
					System.out.println("3 ticks = yellow\n");
					System.out.println("4 ticks = green\n");
					System.out.println("5 ticks = blue\n");
					System.out.println("6 ticks = purple  BOOM!!!\n");
					System.out.println("\n\nLets begin\n\n");
					System.out.println("********************************************************************************************************");

				}
				else if(choice.equals("NO")||choice.equals("no"))
				{
					System.exit(0);
				}
				else
				{	System.out.println("Please enter a valid input.Proceeding again to the start");
					welcome();
				}

		}



}