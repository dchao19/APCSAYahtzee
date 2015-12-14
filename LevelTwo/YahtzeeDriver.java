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

        int score;
        YahtzeeGame myGame=new YahtzeeGame();
        System.out.println("Welcome to Daniel's APCSA Yahtzee Game!");
        score=myGame.playGame();
        Scanner s = new Scanner(System.in);
        System.out.print("Would you like to play again?");
        String input = s.nextLine();
        while(!input.equals("n")){
            score = myGame.playGame();
        }

	}
}
