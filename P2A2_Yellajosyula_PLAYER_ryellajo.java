/**
  Author's Name: Rajya Laxmi Yellajosyula
  Creation day: June 8th 2017
  Last modification day: June 10th 2017
  
  This program illustrates the player creation by creating the user requested number of players with each having their own fields.
  It starts with setting the word values of each of the players with all underscores(length of user word is same as hint word)
  Then for every match found with the original word based on user inputs,the underscore is replaced with the actual word.

  This class has accessors and mutators for all the required fields.
  If user inputs a complete string equal to the length of original word,then the comparision is done accordingly.
  Else,it is done by character by character based on user input.
*/


import java.util.Scanner;
import java.io.*;


 
public class P2A2_Yellajosyula_PLAYER_ryellajo
{

  //Variables to hold chances left for the user,current color,word,game status,and the player numbers.
  private String word,color;
  private int noOfTicks,chancesLeft;
  private boolean gameStatus;
  private boolean win;
  public static boolean exitGame;
  public static int playerNo;


  //No arg constructor
  P2A2_Yellajosyula_PLAYER_ryellajo()
  {
    word = "";
    color = "";
    noOfTicks = 0;
    chancesLeft = 6;
    gameStatus = true;
    exitGame = false;
    playerNo++;
    win = false;

  }

  //Parameterised constructor
  P2A2_Yellajosyula_PLAYER_ryellajo(int n)
  {

    StringBuilder sb =new StringBuilder();

    //Prnting the place holder for the secret word which is initially set to all underscores
   for(int i=0;i<n;i++)
   {
    sb.append("_" );
   }
    

    word = sb.toString();

    win = false;
    color = "";
    noOfTicks = 0;
    chancesLeft = 6-noOfTicks;
    gameStatus = true;
    playerNo++;
    exitGame = false;

  }


  //Parameterised constructor
  P2A2_Yellajosyula_PLAYER_ryellajo(String w,String c,int ticks,boolean s)
  {

    word = w;
    color = c;
    noOfTicks = ticks;
    chancesLeft = 6-noOfTicks;
    gameStatus = s;
    exitGame = false;
    win = false;


  }

  //Mutator method that Sets win field value to the boolean b value
  public void setWinStatus(boolean b)
  {
      win = b;

  } 

   //Accessor method that returns win field value 
  public boolean getWinStatus()
  {
     return win;

  }


  //Mutator method that Sets noOfTicks field value to the int n value
  public void setnoOfTicks(int n)
  {

    noOfTicks = n;
  }

   //Accessor method that returns noOfTicks field value 
  public int getnoOfTicks()
  {
    return noOfTicks;
  }
  
  //Accessor method that returns gameStatus field value 
  public boolean getGameStatus()
  {
    return gameStatus;
  }

  //Mutator method that Sets gameStatus field value to the boolean n value
  public void setGameStatus(boolean n)
  {

    gameStatus = n;
  }

 //Mutator method that Sets chancesLeft field value to the int n value
  public void setchancesLeft(int n)
  {

    chancesLeft  = n;
  }

  public int getchancesLeft()
  {
    return chancesLeft;
  }

   //Mutator method that Sets word field value to the String w value
  public void setWord(String w)
  {

    word = w.toLowerCase();
  }

  //Mutator method that Sets word field value to the c char value at position pos 
  public void setWord(char c,int pos)
  {
              //Replaces the underscore with matched character 
              word =  word.substring(0,pos)+c+word.substring(pos+1);

  }

  public String getWord()
  {
    return word;
  }

  //Mutator method that Sets color field based on integer n  value
  public void setColor(int n)
  {
    
    switch(n)
    {
      case 1:
      color = "red";
      break;

      case 2:
      color = "orange";
      break;

      case 3:
      color = "yellow";
      break;

      case 4:
      color = "green";
      break;

      case 5:
      color = "blue";
      break;

      case 6:
      color = "purple";
      break;
    }
  
  }

  public String getColor()
  {
    return color;
  }

  public int getPlayerNo()
  {

    return playerNo;
  }

  public void getProperties(int n)
  {

    System.out.println("Player  "+ n + " Details ");
    System.out.println("--------------------------------------------------");

    System.out.println("Current word value: "+getWord());

    System.out.println("Your current color: "+getColor());


    System.out.println("No.of Chances left: "+chancesLeft);

  }

  public boolean equals(String user,P2A2_Yellajosyula_QUESTION_ryellajo q)
  {

    String actual = q.getWord();

    if(actual.equals(user))

      {
        gameStatus = false;
        win = true;
        return true;

      }
    else 
      return false;

  
  }
  //Compares user input to the actual word and returns the number of ticks earned so far
  public void  compare(P2A2_Yellajosyula_QUESTION_ryellajo a,char c)
  {

    String s1 = a.getWord();

    String s2 = word;

    //System.out.println("************************Current word"+s2);

    boolean found = false;

    char[] question =  s1.toCharArray();
 
      for(int j=0;j<question.length;j++)
      {
          if(c==question[j])
           { 
              found = true;

              System.out.println("Correct guess.Found \t"+c+ " at "+j+" position of the word");

              win = true;

              setWord(c,j);

           }
    

        
      }

     
             // System.out.println("compare"+found);

      if(!found)
      {
        System.out.println("********************************Oops!! No match found************************\n");
        noOfTicks++;
        chancesLeft--;
      
      }

}


public boolean verify(P2A2_Yellajosyula_QUESTION_ryellajo a)

{

    if(word.equals(a.getWord()))
            {
              System.out.println("**********************Word Found************************");
              gameStatus = false;
              win = true;
              return true;
            }

    return false;
}


}
