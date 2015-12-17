public class YahtzeeScorecard
{
	/* instance data given */
	private int ones;
	private int twos;
	private int threes;
	private int fours;
	private int fives;
	private int sixes;
	private int threeKind;
	private int fourKind;
	private int fiveKind;
	private int chance;
	private int fullHouse;
	private int smStraight;
	private int lgStraight;
	private boolean bonus;

	/* Sets up a new game.  Sets all instance data to incomplete (-1). Sets bonus to false */
	public YahtzeeScorecard()
	{
		ones = -1;
		twos = -1;
		threes = -1;
		fours = -1;
		fives = -1;
		sixes = -1;
		threeKind = -1;
		fourKind = -1;
		fiveKind = -1;
		chance = -1;
		fullHouse = -1;
		smStraight = -1;
		lgStraight = -1;
		bonus = false;
	}

	/* 1. If the field is already full, return false
	   2. Set data value ones equal to number of ones rolled multiplied by one.
	   3. Update the bonus (call updateBonus())
	   4. Return true   */
	public boolean markOnes(int die1, int die2, int die3, int die4, int die5)
	{
		int number = 0;
		if(ones>-1) return false;
		if(die1 == 1) number++;
		if(die2 == 1) number++;
		if(die3 == 1) number++;
		if(die4 == 1) number++;
		if(die5 == 1) number++;
		ones = number;
		updateBonus();
		return true;
	}

	/* 1. If the field is already full, return false
	   2. Set data value twos equal to number of twos rolled multiplied by two.
	   3. Update the bonus (call updateBonus())
	   4. Return true   */
	public boolean markTwos(int die1, int die2, int die3, int die4, int die5)
	{
		int number = 0;
		if(twos>-1) return false;
		if(die1 == 2) number++;
		if(die2 == 2) number++;
		if(die3 == 2) number++;
		if(die4 == 2) number++;
		if(die5 == 2) number++;
		twos = number*2;
		updateBonus();
		return true;
	}

	/* 1. If the field is already full, return false
	   2. Set data value threes equal to number of threes rolled multiplied by three.
	   3. Update the bonus (call updateBonus())
	   4. Return true  */
	public boolean markThrees(int die1, int die2, int die3, int die4, int die5)
	{
		int number = 0;
		if(threes>-1) return false;
		if(die1 == 3) number++;
		if(die2 == 3) number++;
		if(die3 == 3) number++;
		if(die4 == 3) number++;
		if(die5 == 3) number++;
		threes = number*3;
		updateBonus();
		return true;
	}

	/* 1. If the field is already full, the method returns false
	   2. Sets data value fours equal to number of fours rolled multiplied by four.
	   3. Update the bonus (call updateBonus())
	   4. Returns true   */
	public boolean markFours(int die1, int die2, int die3, int die4, int die5)
	{
		int number = 0;
		if(fours>-1) return false;
		if(die1 == 4) number++;
		if(die2 == 4) number++;
		if(die3 == 4) number++;
		if(die4 == 4) number++;
		if(die5 == 4) number++;
		fours = number*4;
		updateBonus();
		return true;
	}

	/* 1. If the field is already full, the method returns false
	   2. Sets data value fives equal to number of fives rolled multiplied by five.
	   3. Update the bonus (call updateBonus())
	   4. Returns true   */
	public boolean markFives(int die1, int die2, int die3, int die4, int die5)
	{
		int number = 0;
		if(fives>-1) return false;
		if(die1 == 5) number++;
		if(die2 == 5) number++;
		if(die3 == 5) number++;
		if(die4 == 5) number++;
		if(die5 == 5) number++;
		fives = number*5;
		updateBonus();
		return true;
	}

	/* 1. If the field is already full, the method returns false
	   2. Sets data value sixes equal to number of sixes rolled multiplied by six.
	   3. Update the bonus (call updateBonus())
	   4. Returns true */
	public boolean markSixes(int die1, int die2, int die3, int die4, int die5)
	{
		int number = 0;
		if(sixes>-1) return false;
		if(die1 == 6) number++;
		if(die2 == 6) number++;
		if(die3 == 6) number++;
		if(die4 == 6) number++;
		if(die5 == 6) number++;
		sixes = number*6;
		updateBonus();
		return true;
	}

	/* 	1. If the field is already full, return false
		2. Check to see if there are actually three of the same value.
		   If there are, set the data value threeKind to the value of all five dice.
		   If there aren’t set the value to 0.
	   	   (Hint: use YahtzeeSortDice class!)
	   	4. Return true   */
	public boolean markThreeOfAKind(int die1, int die2, int die3, int die4, int die5)
	{
		;
		if(threeKind > -1)return false;
		YahtzeeSortDice sorted = new YahtzeeSortDice(die1,die2,die3,die4,die5);
		System.out.println(sorted.getFirst());
		System.out.println(sorted.getSecond());
		System.out.println(sorted.getThird());
		System.out.println(sorted.getFourth());
		System.out.println(sorted.getFifth());
		if(sorted.getFirst() == sorted.getSecond() && sorted.getSecond() == sorted.getThird()) threeKind = die1 + die2 + die3 + die4 + die5;
		else if(sorted.getSecond() == sorted.getThird() && sorted.getThird() == sorted.getFourth()) threeKind = die1 + die2 + die3 + die4 + die5;
		else if(sorted.getThird() == sorted.getFourth() && sorted.getFourth() == sorted.getFifth())threeKind = die1 + die2 + die3 + die4 + die5;
		else threeKind = 0;
		return true;
	}

	/* 	1. If the field is already full, return false
		2. Check to see if there are actually four of the same value.
		   If there are, set the data value fourKind to the value of all five dice.
		   If there aren’t set the value to 0;
		   (Hint: use YahtzeeSortDice class!)
		4. Return true  */
	public boolean markFourOfAKind(int die1, int die2, int die3, int die4, int die5)
	{
		if(fourKind > -1)return false;
		YahtzeeSortDice sorted = new YahtzeeSortDice(die1,die2,die3,die4,die5);
		if(sorted.getFirst() == sorted.getSecond() && sorted.getFirst() == sorted.getThird() && sorted.getFirst() == sorted.getFourth())fourKind = die1 + die2 + die3 + die4 + die5;
		else if(sorted.getSecond() == sorted.getThird() && sorted.getSecond() == sorted.getFourth() && sorted.getSecond() == sorted.getFifth())fourKind = die1 + die2 + die3 + die4 + die5;
		else fourKind = 0;
		return true;
	}

	/* 1. If the field is already full, return false
	   2. Check to see if there are actually three die with the same value, and two with another value.
	      If there are, set the data value fullHouse to 25.
	      If there aren’t set the value to 0.
	      (Hint: Use YahtzeeSortedDice class!)
       3. Return true   */
	public boolean markFullHouse(int die1, int die2, int die3, int die4, int die5)
	{
		if(fullHouse > -1)return false;
		YahtzeeSortDice sorted = new YahtzeeSortDice(die1,die2,die3,die4,die5);
		if((sorted.getFirst() == sorted.getSecond()) && (sorted.getThird() == sorted.getFourth() && sorted.getThird() == sorted.getFifth())) fullHouse = 25;
		else if((sorted.getFirst() == sorted.getSecond() && sorted.getFirst() == sorted.getThird()) && sorted.getFourth() == sorted.getFifth()) fullHouse = 25;
		else fullHouse = 0;
		return true;
	}

	/* 	1. If the field is already full, return false
		2. Check to see if there are actually four consecutive dice numbers.
		   If there are, set the data value smStraight to 30.
		   If there aren’t set the value to 0.
		   (Hint: Use YahtzeeSortedDice class)
		4. Return true  */
	public boolean markSmallStraight(int die1, int die2, int die3, int die4, int die5)
	{
		if(smStraight > -1)return false;
		else {
			YahtzeeSortDice sorter = new YahtzeeSortDice(die1, die2, die3, die4, die5);
			int first = sorter.getFirst();
			int second = sorter.getSecond();
			int third = sorter.getThird();
			int fourth = sorter.getFourth();
			int fifth = sorter.getFifth();

			String roll = "" + first + second + third + fourth + fifth;
			if (roll.contains("" + (first + 1)) && roll.contains("" + (first + 2)) && roll.contains("" + (first + 3)))
				smStraight = 30;
			else smStraight = 0;
			return true;
		}

	}

	/* 	1. If the field is already full, return false
		2. Check to see if there are actually five consecutive dice numbers.
		   If there are, set the data value lgStraight to 40.
		   If there aren’t set the value to 0;
		   (Hint: use YahtzeeSortDice class!)
		3. Return true  */
	public boolean markLargeStraight(int die1, int die2, int die3, int die4, int die5)
	{
		if(lgStraight > -1) return false;
		YahtzeeSortDice sorted = new YahtzeeSortDice(die1,die2,die3,die4,die5);
		if((sorted.getSecond() == sorted.getFirst() + 1) && (sorted.getThird() == sorted.getFirst() + 2) && (sorted.getFourth() == sorted.getFirst() + 3) && (sorted.getFifth() == sorted.getFirst() + 4)) lgStraight = 40;
		else lgStraight = 0;
		return true;
	}

	/* 1. If the field is already full, return false
	   2. Checks to see if there are actually five of the same value.  If there are, set the data value fiveKind to 50.  If there aren’t set the value to 0;
       3. Return true   */
	public boolean markYahtzee(int die1, int die2, int die3, int die4, int die5)
	{
		if(fiveKind>-1)return false;
		if(die1 == die2 && die2 == die3 && die3 == die4 && die4==die5) fiveKind = 50;
		else fiveKind = 0;
		return true;
	}

	/* 1. If the field is already full, return false
	   2. Set the data value chance to the value of all five dice.
	   3. Return true  */
	public boolean markChance(int die1, int die2, int die3, int die4, int die5)
	{
		if(chance>-1)return false;
		chance = die1 + die2 + die3 + die4 + die5;
		return true;
	}

	/* 	1. If the bonus has already been assigned, do nothing
		2. If the upper section’s total is 63 or greater, set the data value bonus to true */
	private void updateBonus()
	{
		if(bonus) return;
		if(getUpperTotal()>=63)bonus = true;
	}

	/* 	returns the upper total, remember incompletes (-1s) should not be factored in! */
	public int getUpperTotal()
	{
		int total = 0;
		if(ones >-1)total += ones;
		if(twos >-1)total += twos;
		if(threes >-1)total += threes;
		if(fours >-1)total += fours;
		if(fives >-1)total += fives;
		if(sixes >-1)total += sixes;
		return total;
	}

	/* 	returns the lower total, remember incompletes (-1s) should not be factored in! */
	public int getLowerTotal()
	{
		int total = 0;
		if(threeKind>-1)total += threeKind;
		if(fourKind>-1)total += fourKind;
		if(fiveKind>-1)total += fiveKind;
		if(chance>-1)total += chance;
		if(fullHouse>-1)total += fullHouse;
		if(smStraight>-1)total += smStraight;
		if(lgStraight>-1)total +=lgStraight;

		return total;
	}

	/* 	returns the grand total, remember incompletes (-1s) should not be factored in! */
	public int getGrandTotal()
	{
		int bonus = 0;
		if(this.bonus) bonus = 35;
		return bonus + getUpperTotal() + getLowerTotal();
	}

	/*	Prints a scorecard with the current total, using "__" to mark uncompleted fields and a number to mark filled fields
		Sample:
		**********************************
		*  	    Yahtzee Score Card		 *
		*  					`		  	 *
		* 	Ones:				__		 *
		* 	Twos:				__		 *
		* 	Threes:				__		 *
		* 	Fours:				__		 *
		* 	Fives:				25		 *
		* 	Sixes:				__		 *
		*								 *
		*	Upper Bonus:		 0		 *
		* 	Upper Total:   		25		 *
		*								 *
		*	3 of Kind:			__		 *
		* 	4 of Kind:			__		 *
		* 	Full House:			25		 *
		* 	Sm Straight:		__		 *
		* 	Lg  Straight:		__		 *
		* 	Yahtzee:	  		 0		 *
		* 	Chance:				__		 *
		*								 *
		* 	Lower Total:		25		 *
		*								 *
		* 	Grand Total:		50		 *
		**********************************
		already implemented
	*/
	public void printScoreCard()
	{
		System.out.println();
		System.out.println("*********************************");
		System.out.println("*      Yahtzee Score Card       *");
		System.out.println("*                               *");
		System.out.print("*  Ones:\t\t\t");
		if(ones==-1)System.out.print("__");
		else System.out.print(ones);
		System.out.println("\t        *");
		System.out.print("*  Twos:\t\t\t");
		if(twos==-1)System.out.print("__");
		else System.out.print(twos);
		System.out.println("\t        *");
		System.out.print("*  Threes:\t\t\t");
		if(threes==-1)System.out.print("__");
		else System.out.print(threes);
		System.out.println("\t        *");
		System.out.print("*  Fours:\t\t\t");
		if(fours==-1)System.out.print("__");
		else System.out.print(fours);
		System.out.println("\t        *");
		System.out.print("*  Fives:\t\t\t");
		if(fives==-1)System.out.print("__");
		else System.out.print(fives);
		System.out.println("\t        *");
		System.out.print("*  Sixes:\t\t\t");
		if(sixes==-1)System.out.print("__");
		else System.out.print(sixes);
		System.out.println("\t        *");
		System.out.println("*\t\t\t\t                *");
		System.out.print("*  Upper Bonus:\t");
		if(bonus)System.out.print("35");
		else System.out.print("0");
		System.out.println("\t            *");
		System.out.print("*  Upper Total:\t");
		System.out.print(this.getUpperTotal());
		System.out.println("\t            *");
		System.out.println("*                               *");
		System.out.print("*  3 of Kind:\t\t");
		if(threeKind==-1)System.out.print("__");
		else System.out.print(threeKind);
		System.out.println("\t\t\t*");
		System.out.print("*  4 of Kind:\t\t");
		if(fourKind==-1)System.out.print("__");
		else System.out.print(fourKind);
		System.out.println("\t\t\t*");
		System.out.print("*  Full House:\t\t");
		if(fullHouse==-1)System.out.print("__");
		else System.out.print(fullHouse);
		System.out.println("\t\t\t*");
		System.out.print("*  Sm Straight:\t\t");
		if(smStraight==-1)System.out.print("__");
		else System.out.print(smStraight);
		System.out.println("\t\t\t*");
		System.out.print("*  Lg Straight:\t\t");
		if(lgStraight==-1)System.out.print("__");
		else System.out.print(lgStraight);
		System.out.println("\t\t\t*");
		System.out.print("*  Yahtzee:\t\t\t");
		if(fiveKind==-1)System.out.print("__");
		else System.out.print(fiveKind);
		System.out.println("\t\t\t*");
		System.out.print("*  Chance:\t\t\t");
		if(chance==-1)System.out.print("__");
		else System.out.print(chance);
		System.out.println("\t\t\t*");
		System.out.println("*                               *");
		System.out.print("*  Lower Total:\t\t");
		System.out.print(this.getLowerTotal());
		System.out.println("\t\t\t*");
		System.out.println("*                               *");
		System.out.print("*  Grand Total:\t\t");
		System.out.print(this.getGrandTotal());
		System.out.println("\t\t\t*");
		System.out.println("*********************************");
		System.out.println();
	}


}