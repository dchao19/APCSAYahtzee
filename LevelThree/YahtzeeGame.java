import com.sun.org.apache.xpath.internal.SourceTree;

import java.util.Scanner;

public class YahtzeeGame
{
	/* instance data should include the five yahtzee dice, a scoreboard, and a CONSTANT (static final) variable NUM_SIDES
	which should be set to six (the number of sides on a yahtzee die) */
	private YahtzeeDie dice1;
    private YahtzeeDie dice2;
    private YahtzeeDie dice3;
    private YahtzeeDie dice4;
    private YahtzeeDie dice5;
    private YahtzeeScorecard scorecard;
    private static final int NUM_SIDES = 6;



	/* initializes the dice and scoreboard */
	public YahtzeeGame()
	{
		dice1 = new YahtzeeDie(NUM_SIDES);
		dice2 = new YahtzeeDie(NUM_SIDES);
		dice3 = new YahtzeeDie(NUM_SIDES);
		dice4 = new YahtzeeDie(NUM_SIDES);
		dice5 = new YahtzeeDie(NUM_SIDES);
		scorecard = new YahtzeeScorecard();
	}

	/* check to see if the game is over, and while the game is not over call the method takeTurn()
	once the game ends (hint: there are 13 turns in a game of Yahtzee), the method should print a
	final scorecard and return the grand total */
	public int playGame()
	{
		for (int i = 0; i < 13; i++) {
            System.out.println("Round " + (i+1));
            takeTurn();
		}
        scorecard.printScoreCard();
		return scorecard.getGrandTotal();
	}

	/* 	1. call rollDice()
		2. call printDice()
		3. Ask the user if they are satisfied with their roll, or if they would like to roll again.
		   If they are not satisfied continue, otherwise call markScore()
		4. call chooseFrozen()
		5. call rollDice()
		6. call printDice()
		7. Ask the user if they are satisfied with their roll, or if they would like to roll again.
		   If they are not satisfied continue, otherwise call markScore()
		8. call chooseFrozen()
		9. call rollDice()
		10. call printDice()
		11. call markScore()
	*/
	private void takeTurn()
	{
		rollDice();
		printDice();
		System.out.println("Are you satisfied with this roll? Type y or n if you would like to roll again. ");
		Scanner s = new Scanner(System.in);
		String result = s.nextLine();
		if(result.equals("y")) {
			markScore();
			return;
		}
		chooseFrozen();
		System.out.println("Your second roll: ");
		rollDice();
		printDice();
		System.out.println("Are you satisfied with this roll? Type y or n if you would like to roll again. ");
		result = s.nextLine();
		if(result.equals("y")) {
			markScore();
			return;
		}
		chooseFrozen();
		System.out.println("Your third roll: ");
		rollDice();
		printDice();
		markScore();
	}

	/* Rolls all unfrozen dice.  Also resets all dice to the unfrozen state after the roll */
	private void rollDice()
	{
		if(!dice1.isFrozen())dice1.rollDie();
			else dice1.unfreezeDie();
		if(!dice2.isFrozen())dice2.rollDie();
			else dice2.unfreezeDie();
		if(!dice3.isFrozen())dice3.rollDie();
			else dice3.unfreezeDie();
		if(!dice4.isFrozen())dice4.rollDie();
			else dice4.unfreezeDie();
		if(!dice5.isFrozen())dice5.rollDie();
			else dice5.unfreezeDie();
	}

	/* Asks the user which dice should be frozen 1-5 (should be read in in one line) */
	private void chooseFrozen()
	{
		System.out.print("Would you like to freeze any dice? Enter the dice number separated by a space (ex: 1 2 3)");
		Scanner s = new Scanner(System.in);
		String freezes = s.nextLine();
		if(freezes.contains("1")) dice1.freezeDie();
		if(freezes.contains("2")) dice2.freezeDie();
		if(freezes.contains("3")) dice3.freezeDie();
		if(freezes.contains("4")) dice4.freezeDie();
		if(freezes.contains("5")) dice5.freezeDie();
	}

	/* Should print the value of all five dice separated by a tab (\t) to the console */
	private void printDice()
	{
		System.out.println("Your dice values: ");
		System.out.println(dice1.getValue() + "\t" + dice2.getValue() + "\t" + dice3.getValue() + "\t" + dice4.getValue() + "\t" + dice5.getValue() + "\t");
	}

	/* 1. Print a scoreboard
	   2. Ask the user where they would like to mark their score.
	   3. Call appropriate function
	   4. If false is returned the user entered an invalid number, so ask the user to try again	*/
	private void markScore()
	{
		scorecard.printScoreCard();

		int dice1 = this.dice1.getValue();
		int dice2 = this.dice2.getValue();
		int dice3 = this.dice3.getValue();
		int dice4 = this.dice4.getValue();
		int dice5 = this.dice5.getValue();


		Scanner s = new Scanner(System.in);
		int choice = 0;
		while(choice < 1 || choice > 13) {
			System.out.print("Where would you like to mark your score? ");
			System.out.println("1. Ones \t2. Twos\n3. Threes\t4. Fours\n5. Fives\t6. Sixes\n7. 3 of a kind \t8. 4 of a kind\n9. Full House\t10. Small Straight\n11. Large Straight\t12. Yahtzee\n13. Chance");
			System.out.print("Enter 1-13: ");
			choice = s.nextInt();
			switch (choice){
				case 1:
					scorecard.markOnes(dice1,dice2,dice3,dice4,dice5);
					break;
				case 2:
					scorecard.markTwos(dice1,dice2,dice3,dice4,dice5);
					break;
				case 3:
					scorecard.markThrees(dice1,dice2,dice3,dice4,dice5);
					break;
				case 4:
					scorecard.markFours(dice1,dice2,dice3,dice4,dice5);
					break;
				case 5:
					scorecard.markFives(dice1,dice2,dice3,dice4,dice5);
					break;
				case 6:
					scorecard.markSixes(dice1,dice2,dice3,dice4,dice5);
					break;
				case 7:
					scorecard.markThreeOfAKind(dice1,dice2,dice3,dice4,dice5);
					break;
				case 8:
					scorecard.markFourOfAKind(dice1,dice2,dice3,dice4,dice5);
					break;
				case 9:
					scorecard.markFullHouse(dice1,dice2,dice3,dice4,dice5);
					break;
				case 10:
					scorecard.markSmallStraight(dice1,dice2,dice3,dice4,dice5);
					break;
				case 11:
					scorecard.markLargeStraight(dice1,dice2,dice3,dice4,dice5);
					break;
				case 12:
					scorecard.markYahtzee(dice1,dice2,dice3,dice4,dice5);
					break;
				case 13:
					scorecard.markChance(dice1,dice2,dice3,dice4,dice5);
					break;
				default:
					System.out.println("No. You didn't do it right. Try again.");
					break;
			}
		}

	}
}