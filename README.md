# NumericsHangman
Activity 1:
In this activity, the Question class is used to fetch inputs from the user input file. A random number line is fetched from the file and is split into the word and its description using a comma as separator.
Then using Player class, user requested number of players are created. These player’s word values are initially set to all underscores. These words are created with the same length as that of the word fetched by Question class object from input file.
Then, the user is prompted for his choice of mode of Play i.e. single player or multi player. If user chooses multiplayer, the user is again prompted for the number of players value. Once this value is fetched, the actual Game begins.
Using the hint provided, the user can guess the complete word at once or a char or group of characters in several rounds for each of the player. Based on the matches, for every non match found the tick value of the player increments. Once this value equates to 6,that player is declared as loser.
On the other hand, if one of the player succeeds in guessing the word in rounds or at a single shot before exhausting  the number of chances, he is declared as winner.
For every round, the player’s current word of guess, the current colour and number of chances left are printed to the console.
For any of the results ,i.e. win or lose cases ,the user is prompted if he wishes to continue or exit.
Activity 3:
This activity is build using activity 2 Question class, Player class and separating the evaluation logic into Game class.Autoplay is a child class created that extends Game class. The main purpose of this class if to provide the user an option to choose the computer to play for him.
The user begins by providing the user input file and his consent to use auto play or play manually. If he choses manual mode, the flow is same as activity 2.
If he choses auto play, then he is prompted for number of games to be played by computer and the number of players. These are set as the autoplay class object values and game class play method is overridden in autoplay class to facilitate the computer to play the game.
For every game, the output and the player words are printed to the console at every stage. Once the autoplay is finished, the user is asked for his wish to continue or exit the game.
Applications:
One of the most significant application of this game theory is used in password/user credential evaluation.
For example, while logging into any of our user accounts be it bank accounts or emails, we are prompted for password. For every wrong password we provide ,the number of ticks goes up. Once the number of attempts reach the threshold value, the user account is locked or temporarily suspended until we prove our user integrity.
Another application is in Adaptive academic tests. In these tests, for every question answered incorrectly, the level of difficulty goes down and vice versa.So,as the user makes more mistakes, the questions are picked from a easier category than tough category.
Improvements:

The above activities can be improved by making intelligent guessing than random ones. In English alphabets like a,r,e,i etc tend to occur in words at a higher frequency than others. So when user makes a guess, using the description/hint highly probable alphabets should be used first before proceeding with the rest. This increases the probability of winning.
On the other hand, the user can provide an input file with words that have minimal common alphabets in them. This way, the user cant easily guess the word thus increasing the efficiency of the game.



