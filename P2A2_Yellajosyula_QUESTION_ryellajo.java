/**
  Author's Name: Rajya Laxmi Yellajosyula
  Creation day: June 8th 2017
  Last modification day: June 10th 2017
  This program illustrates the concept of using class and its fields.This forms the basis of the game where the field values ares et with 
  the values that are read from a user input file.
  The line which is to be read is determined by randomly generating a number and fetching that line from the file.


  The fetched content of the file is seperated by a comma with former part set to the word field and latter as description field 
  of this class.

  All the required accessors and mutators are also defined for all the fields.

*/


import java.util.*;
import java.io.*;


 
public class P2A2_Yellajosyula_QUESTION_ryellajo
{
  //Declaring private variables of the word and its hints
  private  String word,description;
  
 
  //No arg constructor
  public P2A2_Yellajosyula_QUESTION_ryellajo()
  {
      
      word = "";
      description = "";
    
 
  }


  //This constructor accepts filename as input and the line number in file that is to be considered for the game
  public P2A2_Yellajosyula_QUESTION_ryellajo(String filename,int lineNumber) throws FileNotFoundException,IOException,ArrayIndexOutOfBoundsException
  {
    
    try {

      //Variable to hold the line numbers of file
      int counter = 0;
      String line = null;


      // FileReader reads text files in the default encoding.
      FileReader fileReader = new FileReader(filename);

      BufferedReader br = new BufferedReader(fileReader);

        while((line = br.readLine()) != null) 
        {
            counter++;
            if(counter == lineNumber)
            {
              //Splits the file content read by comma
              String[] temp = line.split(",");

              //Stored the contents in an array list
              List<String> hints = new ArrayList<String>(Arrays.asList(temp));

              //Sets the field values with the corresponding contents from input file
              setWord(hints.get(0).toLowerCase());
              setDescription(hints.get(1));
               

            }
        }  

      

     }
       catch(FileNotFoundException f)
       {
          System.out.println(f);

       }

  }

//Mutator for word field with a string argument and void return type
public void setWord(String s)
{

  word = s;
}


//Accessor for word field with a  string return type
public String getWord()
{

  return word;
}

//Mutator for description fie with a string argument and void return type
public void setDescription(String d)
{
  description = d;

}

 
//Accessor for description fie with a  string return type
public String getDescription()
{

  return description;
}
}