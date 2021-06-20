package fr.laurent.bowlingGame.entities;



import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Random;

import org.junit.jupiter.api.Test;

class RollTest {

	@Test
	void testRandom() {
		// Arrange
		int range = 10;
		int i;
		for(i = 0; i<100; i++) {
			Random r = new Random();
			int pinsDown = r.nextInt(range + 1)+0;
			// Act  
			boolean ecart = 0 <= pinsDown && pinsDown<= 10;
			// Assert
			if(!ecart) {
				break;
			};
			
		}
		if(i == 100) {
			System.out.println("test succed");
		}else{
			System.out.println("test failed");
		};
	}

}
