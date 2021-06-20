package fr.laurent.bowlingGame.entities;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Random;

import org.junit.jupiter.api.Test;

class RollTest {

	@Test
	void testRandom() {
		// Arrange
		int pinsDown = 11;
		// Act  
		boolean ecart = 0 <= pinsDown && pinsDown<= 10;
		// Assert
		assertEquals(ecart, true);
	}

}
