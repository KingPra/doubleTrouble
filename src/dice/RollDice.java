package dice;

public class RollDice {
	int counter = 0;

	public boolean firstRoll() {
		if (counter == 0) {
			counter++;
			return true;
		} else {
			return false;
		}
	}

	public int dice() {
		// TODO Auto-generated method stub
		return 0;
	}

	public String playGame(int dice, boolean firstRoll) {
		// TODO Auto-generated method stub
		return "win";
	}

}
