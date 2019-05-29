package dice;

import java.util.Random;

public class RollDice {
	public static void main(String[] args) {
		playGame(addDice(die(), die()), firstRoll());

	}

	// used to track if its the first roll
	static int counter = 0;
	// used to store the sum of the first roll
	static int point = 0;

	// returns true if its the first roll and false for anything else
	public static boolean firstRoll() {
		if (counter == 0) {
			counter++;
			return true;
		} else {
			return false;
		}
	}

	// generates a random number between 1-6;
	public static int die() {
		Random random = new Random();
		int num = (int) (1 + Math.random() * 6);
		return num;
	}

	// game logic
	public static String playGame(int dice, boolean firstRoll) {
		// sets the point
		point = firstRollPoint(dice, firstRoll);

		// if this is the first roll and you roll a 7 or 11
		if (dice == 7 && firstRoll || dice == 11 && firstRoll) {
			System.out.println("You rolled a " + dice + " on the first roll. You win");
			return "win";
			// if this is the first roll and you roll a 2, 3 or 12
		} else if (dice == 2 && firstRoll || dice == 3 && firstRoll || dice == 12 && firstRoll) {
			System.out.println("You rolled a " + dice + " on the first roll. You lose");
			return "lose";
			// if its not the first roll and you roll a 7
		} else if (firstRoll == false && dice == 7) {
			System.out.println("You rolled " + dice + ".\nYou lose!");
			return "lose";
			// if it gets pass the other logic and it's the first roll, play the game
		} else if (firstRoll) {
			playGame(addDice(die(), die()), firstRoll());
			// if it's not the first roll and dice is not equal to points, print out and
			// play game
		} else if (firstRoll == false && dice != point) {
			System.out.println("You rolled " + dice + " Your point is " + point);
			playGame(addDice(die(), die()), firstRoll());
			// if the dice and the points are equal, this should catch it and print out a
			// win
		} else {
			System.out.println("You rolled a " + dice + " Your point is " + point + "\nYou win!");
			return "You rolled a " + dice + " Your point is " + point + "\nYou win!";
		}
		System.out.println("end");
		return "end";

	}

	public static int addDice(int i, int j) {
		return i + j;
	}

	// this method is used to store the first roll;
	public static int firstRollPoint(int i, boolean firstRoll) {
		if (point == 0 && firstRoll == true) {
			point = i;
		}
		return point;
	}

}
