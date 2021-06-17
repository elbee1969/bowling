package fr.laurent.bowlingGame.entities;

import java.util.ArrayList;
import java.util.List;

public class Frame {
	private int frameNumber;

	private List<Roll> rolls =  new ArrayList<Roll>();
	private boolean bonusStrike;
	private boolean bonusSpare;
	private int frameScore;
	private int tempScore;
	private int bonusFrame;
	public Frame() {
	}
	
	
	public Frame(int frameNumber, List<Roll> rolls, boolean bonusStrike,
			boolean bonusSpare, int frameScore, int tempScore, int bonusFrame) {
		super();
		this.frameNumber = frameNumber;
		this.rolls = rolls;
		this.bonusStrike = bonusStrike;
		this.bonusSpare = bonusSpare;
		this.frameScore = frameScore;
		this.tempScore = tempScore;
		this.bonusFrame = bonusFrame;
	}


	public int getFrameNumber() {
		return frameNumber;
	}
	public int setFrameNumber(int frameNumber) {
		return this.frameNumber = frameNumber;
	}
		
	public boolean getBonusStrike() {
		return bonusStrike;
	}

	public void setBonusStrike(boolean bonusStrike) {
		this.bonusStrike = bonusStrike;
	}

	public boolean getBonusSpare() {
		return bonusSpare;
	}

	public void setBonusSpare(boolean bonusSpare) {
		this.bonusSpare = bonusSpare;
	}

	public int getFrameScore() {
		return frameScore;
	}
	public int setFrameScore(int frameScore) {
		return this.frameScore = frameScore;
	}
	
	public int getTempScore() {
		return tempScore;
	}

	public void setTempScore(int tempScore) {
		this.tempScore = tempScore;
	}

	public int getBonusFrame() {
		return bonusFrame;
	}
	public void setBonusFrame(int bonusFrame) {
		this.bonusFrame = bonusFrame;
	}
	
	
	public List<Roll> getRolls() {
		return rolls;
	}

	public void setRolls(List<Roll> rolls) {
		this.rolls = rolls;
	}

	/**
	 * Add bonus when strike or spare
	 * @param bonusScore
	 * @return
	 */
	public int addBonus(int bonusScore) {
		return this.bonusFrame + bonusScore;
	}
	@Override
	public String toString() {
		return "\nFrame " + frameNumber + "\n rolls=" + rolls + "\n frameScore=" + frameScore + ", tempScore="
				+ tempScore ;
	}


	
	

	
	
	
	
	

	
}
