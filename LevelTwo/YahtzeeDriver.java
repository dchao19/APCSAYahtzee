import java.util.Random;
import java.util.Scanner;

public class YahtzeeDriver
{
	/*
	1. Creates a new instance of the YahtzeeGame class
	2. Calls the playGame method on the Yahtzee object
	3. Asks user if they would like to play again
	4. When the user is done playing, prints the number of games played, min, max, and average score
	*/
	public static void main(String [] args)
	{
        Scanner s = new Scanner(System.in);
        int score;
        int sum = 0;
        int minScore = -999;
        int maxScore = 0;
        int numGames = 0;
        String input;
        do{
            numGames++;
            YahtzeeGame game = new YahtzeeGame();
            int gameResult = game.playGame();
            sum += gameResult;
            if(gameResult > maxScore) maxScore = gameResult;
            if(gameResult < minScore || minScore != 999) minScore = gameResult;

            System.out.print("Would you like to play again? (y/n)");
            input = s.nextLine();

        }while(input.equals("y"));

        System.out.println("Number of Games Played: " + numGames);
        System.out.println("Max Score: " + maxScore);
        System.out.println("Min Score: " + minScore);
        System.out.println("Average Score: " + (double)sum/numGames);
    }
}
