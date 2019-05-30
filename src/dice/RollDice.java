package dice;

public class RollDice {
	public static void main(String[] args) {
		// calls play game method and passes in dice() as an int argument and
		// firstRoll() as a boolean argument
		playGame(dice(), firstRoll());
	}

	// these variables are global to track throughout game play;
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
	public static int dice() {
		int num = (int) (3 + Math.random() * 10);
		return num;
	}

	// game logic
	public static String playGame(int dice, boolean firstRoll) {
		// if this is the first roll and you roll a 7 or 11
		if (dice == 7 && firstRoll == true || dice == 11 && firstRoll == true) {
			System.out.println("You rolled a " + dice + " on the first roll. You win");
			return "win";
			// if this is the first roll and you roll a 2, 3 or 12
		} else if (dice == 2 && firstRoll == true || dice == 3 && firstRoll == true
				|| dice == 12 && firstRoll == true) {
			System.out.println("You rolled a " + dice + " on the first roll. You lose");
			return "lose";
			// if its not the first roll and you roll a 7
		} else if (firstRoll == false && dice == 7) {
			System.out.println("You rolled " + dice + ".\nYou lose!");
			return "lose";
			// if it gets pass the other logic and it's the first roll, play the game
		} else if (firstRoll && point == 0) {
			// sets the point
			point = firstRollPoint(dice, firstRoll);
			playGame(dice(), firstRoll());
			// if it's not the first roll and dice is not equal to points, print out and
			// play game
		} else if (firstRoll == false && dice != point) {
			System.out.println("You rolled " + dice + " Your point is " + point);
			playGame(dice(), firstRoll());
			// if the dice and the points are equal, this should catch it and print out a
			// win
		} else {
			System.out.println("You rolled a " + dice + " Your point is " + point + "\nYou win!");
			// return "You rolled a " + dice + " Your point is " + point + "\nYou win!";
			return "win";
		}
		return "end";

	}

	// this method is used to store the first roll;
	public static int firstRollPoint(int i, boolean firstRoll) {
		if (point == 0 && firstRoll == true) {
			point = i;
		}
		return point;
	}

}
