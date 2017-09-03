import java.util.*;
import java.io.*;

public class P2A3_Yellajosyula_ryellajo
{
	
		public static void main(String[] args) throws FileNotFoundException
		{		
				//variable that holds suer's input for number of players
				int number=0;
				boolean repeat = true;

				//Variable that holds user inout for filename
				String fileNme;

				welcome();

				//Creating a scanner object to read user inputs
				Scanner in = new Scanner(System.in);
				
				System.out.println("enter the input file");
				//Accepting user inputs
   				fileNme = in.nextLine();

   				while(repeat)
   				{
   				System.out.println("\n---------------------------------------------------------------------------\n");

   				modeOfPlay(fileNme);


				
				System.out.println("\nEnter 1 for uni player mode and 2 for multi player mode \n");
			
				int userChoice = in.nextInt();

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

				P2A3_Yellajosyula_GAME_ryellajo game = new P2A3_Yellajosyula_GAME_ryellajo(number,fileNme);
					game.play(false);

					System.out.println("Enter 0 to exit.Else press 1.Only numbers are allowed");
					
					if(in.nextInt()==0)
						System.exit(1);


					
			}
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

public static void modeOfPlay(String filename)throws FileNotFoundException
{
		System.out.println("Would you like to play manually or in autoplay mode? Enter 1 for manual. 2 to select Autoplay ");	
		Scanner in = new Scanner(System.in);

		int choice = in.nextInt();

		if(choice==1)
		return;

		else if(choice==2)
		{

				System.out.println("Enter the number of games you want the computer to play ");	
				int games = in.nextInt();

				System.out.println("Enter the number of players in each game");	
				int players = in.nextInt();

				 for(int i=0;i<games;i++)
				 {
				 	    System.out.println("\n---------------------------------------------------------------------------\n");	

						System.out.println("Starting Game "+(i+1));
				   	    System.out.println("\n---------------------------------------------------------------------------\n");	
						P2A3_Yellajosyula_AUTOPLAY_ryellajo autoplay = new P2A3_Yellajosyula_AUTOPLAY_ryellajo(players,games,filename);
				 		 autoplay.play(true);
				 		 P2A2_Yellajosyula_PLAYER_ryellajo[] results = autoplay.getPlayers();

				 		 for(int j=0;j<results.length;j++)
				 		 {
				 		 	if(results[j].getWinStatus())
				 		 		System.out.println("Player \t "+ (j+1)+" won in this game");

				 		 }

				 }
			System.out.println("\n------------------Finished Auto play mode---------------------------------------------------------\n");	
			System.exit(1);
		}
		else
		{
			System.out.println("Please enter a valid input");
			modeOfPlay(filename);
		}


}
}