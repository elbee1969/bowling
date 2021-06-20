package fr.laurent.bowlingGame.entities;

import java.util.Random;

public class Roll {
	private int pinsDown;
	private boolean isStrike = false;
	private boolean isSpare= false;



	
	public Roll(int pinsDown, boolean isStrike, boolean isSpare) {
		super();
		this.pinsDown = pinsDown;
		this.isStrike = isStrike;
		this.isSpare = isSpare;
	}


	public Roll() {

	}

	public int getPinsDown() {
		return pinsDown;
	}

	public void setPinsDown(int pinsDown) {
		this.pinsDown = pinsDown;
	}

	public boolean isStrike() {
		return isStrike;
	}

	public boolean setIsStrike(boolean isStrike) {
		return this.isStrike = isStrike;
	}

	public boolean isSpare() {
		return isSpare;
	}

	public boolean setIsSpare(boolean isSpare) {
		return this.isSpare = isSpare;
	}

	/**
	 * first delivery
	 * @return pinsDown
	 */
	public  int gameRoll1() {
		
		
		  Random r = new Random();
		 
		  int pinsDown = r.nextInt(10 + 1)+0;
		  //int pinsDown =10;
		  if( pinsDown == 10) {
				System.out.println("r1 = X");
				setIsStrike(true);
				  return pinsDown;
			}else {
				if(pinsDown == 0)	{
					System.out.println("r1 = --");
				}else {
				
				System.out.println("r1 = " + pinsDown );
				}
			}		
		  return pinsDown;		
	}
	
	/**
	 * second delivery (difference from 10)
	 * @param score1
	 * @return pinsDown
	 */
	public int  gameRoll2(int score1) {
		if( score1 != 10) {
		Random r = new Random();
		
		int pinsDown = r.nextInt((10 - score1) + 1);
		  //int pinsDown = 0;
		
			if(score1 + pinsDown == 10) {
				System.out.println("r2 = /");
				setIsSpare(true);
			}else {
				if(pinsDown == 0) {
					if(score1 == 10) {
					}else {
						System.out.println("r2 = --");
					}
				}else {
					System.out.println("r2 = " + pinsDown );
				}
			}
		return pinsDown;
		} else {
			return 0;
		}		
	}
	
	
	/**
	 * bonus delivery (score3 & 4) in frame 10
	 * @return pinsDown
	 */
	public int gameRollBonus() {
		Random r = new Random();
		int pinsDown = r.nextInt(10 + 1)+0;
		//int pinsDown = 10;
		switch(pinsDown) {
		case 10:
			System.out.println("rb = X");
			break;
		case 0 :
			System.out.println("rb = --");
			break;
		default:
			System.out.println("rb = " + pinsDown);	
		}
		return pinsDown;
	}
	
	@Override
	public String toString() {
		return pinsDown  + " ";
	}

	

}
