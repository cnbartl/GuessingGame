// Cooper Bartl
// CS141
// 7/24/23

import java.util.*;

public class cbGuess 
{
   static final int maxNum = 1; // max number for guessing game... its changable.
      
   public static void intro(){ // simple print statements and lets users know what they are guessing to
      System.out.println("It seems you want to play a game...");
      System.out.println("I think I can do that.");
      System.out.println("I'm thinking of a number between 1 and " + maxNum + ".");
      System.out.println("If you can guess it, you win.");
      System.out.println("You start now.");
      
   } // End of into()
   
   public static int playGame(int maxNum){ // the game itself. returns number of guess per game.
      Random rand = new Random();
      final int randomNum = rand.nextInt(maxNum) + 1; // Random number made a constant for switch / case.
      boolean winOrLose = false; // Wether guess is wrong or right
      int currentGuess = 0; // User's number they guessed
      int guessCount = 1;//Counts the amount of guesses.
      Scanner newInput = new Scanner ( System. in );
      System.out.println("Input a number 1-" + maxNum);
      currentGuess = newInput.nextInt();
      
      while (winOrLose == false){
         //guessCount++;
         
        
    if (randomNum == currentGuess){
            System.out.println("You got that right. I made that too easy.");
            System.out.println("It only took you " + guessCount + " guesses...");            
            winOrLose = true;
            //playAgain(); // Asks user wether they want to play again.
            break;

         } // End of if
         else if(randomNum > currentGuess ){
            guessCount++;
            System.out.println("You're wrong! Try again.");
            System.out.println("The number is higher.");
            currentGuess = newInput.nextInt();
         } // End of else / if
         else{
            guessCount++;
            System.out.println("You're wrong! Try again.");
            System.out.println("The number is Lower.");
            currentGuess = newInput.nextInt();
         }
       
              
      } // End of while loop
      System.out.println("fucking guess cunt"+guessCount);
      return guessCount;
   } // End of playGame
   
   public static boolean playAgain(){ // Asks user if they want to play again. Returns true or false
      Scanner newString = new Scanner ( System. in );
      System.out.println("Do you want to play again?");
      String nextGame = newString.next(); // Does user want to play another game
      char firstChar = nextGame.charAt(0); // First character of user input
      
      if (firstChar == 'y' || firstChar == 'Y'){
         //System.out.print("true");
         return true;
      }
      else{
         //System.out.print("false");
         return false;
      }
      
   } // End of playAgain() 
   
   
   public static void stats(int playCount, int totalGuessCount, int bestGuess){ // prints out all statistics gathered in main.
      int guessPerGame = totalGuessCount / playCount; // total guesses divided by games played
      System.out.println("\nHere Are Your Statistics:");
      System.out.println("Best Guess: " + bestGuess);
      System.out.println("Total Guesses: " + totalGuessCount);
      System.out.println("Total Games Played : " + playCount);
      System.out.println("Guesses Per Game: " + guessPerGame);
   } // End of stats()
   
   public static void main(String[] args)
   {
      //initialation
      int playCount = 1; // Counter of games played
      int guessCount = 1; // Counter of guesses per game
      int totalGuessCount = 0; // Counter of total guesses throughout all games
      int bestGuess = 0; // Stores lowest guess count in a game
      
      intro();
      guessCount = playGame(maxNum);
      totalGuessCount=guessCount;
      bestGuess = guessCount; // If user only plays one game, it will still have a correct best guess
      
      boolean keepGoing = playAgain(); // Wether or not game continues
      
      if (keepGoing == true){
         guessCount = 1;
         playCount++;
         guessCount++;

      while (keepGoing == true){
         guessCount = guessCount + 1;
         playCount++;
         //totalGuessCount += guessCount;// Continues to add to total guesses 
         System.out.println("FINALCOUNT"+totalGuessCount);
         if (guessCount <= playGame(maxNum)){ // If last stored guess count is greater then this next one, then...
            bestGuess = guessCount;
             guessCount =+ totalGuessCount;
             System.out.println("aftrFINALCOUNT"+totalGuessCount);
             break;
            //talGuessCount++;
         } // end of if
         keepGoing = playAgain();
      } // end of while  
      }  
      stats(playCount, totalGuessCount, bestGuess); // imports all stats to stats()
           
   } // End of main
   
} // End of class      
