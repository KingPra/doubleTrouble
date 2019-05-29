package dice;

import java.util.Random;

public class RollDice {
	public static void main(String[] args) {
		playGame(addDice(die(), die()), firstRoll());

	}

	static int counter = 0;
	static int point = 0;

	public static boolean firstRoll() {
		if (counter == 0) {
			counter++;
			return true;
		} else {
			return false;
		}
	}

	public static int die() {
		Random random = new Random();
		int num = (int) (1 + Math.random() * 6);
		return num;
	}

	public static String playGame(int dice, boolean firstRoll) {
		point = firstRollPoint(dice, firstRoll);

		if (dice == 7 && firstRoll || dice == 11 && firstRoll) {

			System.out.println("You rolled a " + dice + " on the first roll. You win");
			return "win";
		} else if (dice == 2 && firstRoll || dice == 3 && firstRoll || dice == 12 && firstRoll) {
			System.out.println("You rolled a " + dice + " on the first roll. You lose");
			return "lose";
		} else if (firstRoll == false && dice == 7) {
			System.out.println("You rolled " + dice + ".\nYou lose!");
			return "lose";

		} else if (firstRoll) {
			playGame(addDice(die(), die()), firstRoll());
		} else if (firstRoll == false && dice != point) {
			System.out.println("You rolled " + dice + " Your point is " + point);
			playGame(addDice(die(), die()), firstRoll());
		} else {
			System.out.println("You rolled a " + dice + " Your point is " + point + "\nYou win!");
			return "You rolled a " + dice + " Your point is " + point + "\nYou win!";
		}
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
