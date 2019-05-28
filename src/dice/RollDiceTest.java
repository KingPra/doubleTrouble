package dice;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RollDiceTest {
	RollDice roller = new RollDice();

	@Test
	@DisplayName("this should return true if it is the first roll")
	void isThisTheFirstRollTest() {
		assertTrue("this should return true if it is the first roll", roller.firstRoll() == true);
		assertTrue("this is the second call, this should return false", roller.firstRoll() == false);
		assertTrue("this is the third call, this should return false", roller.firstRoll() == false);
	}

	@Test
	@DisplayName("this should add two dice and return sum")
	void addTwoDiceTest() {
		assertEquals("this should return 5", 5, roller.addDice(3, 2));
		assertEquals("this should return 7", 7, roller.addDice(3, 4));
		assertEquals("this should return 2", 5, roller.addDice(1, 1));
	}

	@Test
	@DisplayName("roller dice should return a win or lose")
	void playGameTest() {
		assertTrue("this should return true if there is any return at all",
				roller.playGame(roller.dice(), roller.firstRoll()) == "win");
	}

	@Disabled("Comment")
	@Test
	void test() {
		fail("Hey lilShell, this is a commit test- King");
	}

}
