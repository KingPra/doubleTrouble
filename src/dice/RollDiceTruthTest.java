package dice;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

class RollDiceTruthTest {
	RollDice roller = new RollDice();

	@Test
	void firstRollTest() {
		assertTrue(RollDice.firstRoll() == true);
	}

	@Test
	void test() {
		fail("Not yet implemented");
	}

}
