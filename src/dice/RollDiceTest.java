package dice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RollDiceTest {

	@Test
	@DisplayName("this should return true if it is the first roll")
	void isThisTheFirstRollTest() {
		assertTrue("this should return true if it is the first roll", RollDice.firstRoll() == true);
		assertTrue("this is the second call, this should return false", RollDice.firstRoll() == false);
		assertTrue("this is the third call, this should return false", RollDice.firstRoll() == false);
	}

	@Test
	@DisplayName("should generate a number between 2-12")
	void diceLowestNumTest() {
		assertTrue("should be greater than or equal to 2", RollDice.dice() > 1);
	}

	@Test
	@DisplayName("should generate a number between 2-12")
	void diceLargestNumTest() {
		assertTrue("should be greater than or equal to 2", RollDice.dice() > 1);
	}

	@Test
	@DisplayName("Should only store first roll")
	void pointTest() {
		assertEquals("this should return 5", 5, RollDice.firstRollPoint(5, true));
		assertEquals("this should return 5 and not 8 becuase it is not the first roll", 5,
				RollDice.firstRollPoint(8, false));
		RollDice.point = 0;
		assertEquals("this should return 8", 8, RollDice.firstRollPoint(8, true));

	}

	@Test
	@DisplayName("roller dice should return a win or lose and it's the first roll")
	void playGameTest() {
		assertEquals("this should return win if they roll a 7 on the first roll", RollDice.playGame(7, true), "win");
		assertEquals("this should return win if they roll an 11 on the first roll", RollDice.playGame(11, true), "win");
		assertEquals("this should return a lose if they roll a 2 on the first roll", RollDice.playGame(2, true),
				"lose");
		assertEquals("this should return a lose if they roll a 3 on the first roll", RollDice.playGame(3, true),
				"lose");
		assertEquals("this should return a lose if they roll a 12 on the first roll", RollDice.playGame(12, true),
				"lose");
	}

	@Test
	@DisplayName("test game play logic if it is NOT the first roll")
	void playGameSecondRollTest() {
		assertEquals("this should return lose if they roll a 7 and it is NOT the first roll",
				RollDice.playGame(7, false), "lose");
		RollDice.point = 0;
		assertEquals("this sets first roll to 8", 8, RollDice.firstRollPoint(8, true));
		assertEquals("this should return a win if we roll an 8 and first roll is false", "win",
				RollDice.playGame(8, false));
	}

}
