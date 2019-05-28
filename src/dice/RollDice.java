package dice;

import java.util.Random;

public class RollDice {
	public static void main(String[] args) {
//		System.out.println(addDice(die(), die()));
//		playGame(addDice(die(), die()), firstRoll());
		playGame(addDice(die(), die()), firstRoll());

	}

	static int counter = 0;

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

//	public static String playGame(int randomNum, boolean firstRoll) {
//		if (randomNum == 7 || randomNum == 11) {
//			
//		}
//
//		return "win";
//	}

	public static String playGame(int dice, boolean firstRoll) {
		int point = firstRollPoint(dice, firstRoll);
		System.out.println("testing play game");

		System.out.println("dice = " + dice);

		System.out.println("is this the first roll? " + firstRoll);

		if (dice == 7 || dice == 11 && firstRoll) {
			System.out.println("win");
			return "win";
		} else if (dice == 2 || dice == 3 || dice == 12 && firstRoll) {
			System.out.println("lose");
			return "lose";
		} else if (firstRoll == false && dice == 7) {
			System.out.println("You rolled " + dice + ".\nYou lose!");
			return "lose";
		} else {
			return "something should happen";
		}

	}

	public static int addDice(int i, int j) {
		return i + j;
	}

	// this method is used to store the first roll;
	public static int firstRollPoint(int i, boolean firstRoll) {
		int point = 0;
		if (point == 0 && firstRoll == true) {
			point = i;
		}
		return point;
	}

}
