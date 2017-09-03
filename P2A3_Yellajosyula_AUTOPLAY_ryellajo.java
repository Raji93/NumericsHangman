import java.util.*;
import java.io.*;

public class P2A3_Yellajosyula_AUTOPLAY_ryellajo extends P2A3_Yellajosyula_GAME_ryellajo
{

	private int noOfplayers,noOfgames;

	public P2A3_Yellajosyula_AUTOPLAY_ryellajo()	
	{
		noOfplayers = 0;
		noOfgames = 0;

	}

	public P2A3_Yellajosyula_AUTOPLAY_ryellajo(int players,int games,String fileNme)throws FileNotFoundException
	{
		super(players,fileNme);
		noOfplayers = players;
		noOfgames = games;

	}

	public void setnoOfplayers(int n)
	{
			noOfplayers = n;

	}


	public void setnoOfgames(int n)
	{
			noOfgames = n;

	}

	public int getnoOfplayers()
	{
			return noOfplayers;

	}
	
	public int getnoOfgames()
	{
			return noOfgames;

	}

	public void play(boolean flag)
	{
				

				 	super.play(flag);
				 
			

	}


}
