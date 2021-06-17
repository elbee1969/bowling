package fr.laurent.bowlingGame.entities;

import java.util.ArrayList;
import java.util.List;

public class Game {
	private List<Gamer> gamers =  new ArrayList<>();
	private List<Frame> frames = new ArrayList<>(10);
	private int tempScore;
	private int finalScore;
	
	public Game() {
		
	}
	
	public Game(List<Gamer> gamers, List<Frame> frames, int tempScore, int finalScore) {
		super();
		this.gamers = gamers;
		this.frames = frames;
		this.tempScore = tempScore;
		this.finalScore = finalScore;
	}

	public int getTempScore() {
		return tempScore;
	}
	public void setTempScore(int tempScore) {
		this.tempScore = tempScore;
	}
	public int getFinalScore() {
		return finalScore;
	}
	public void setFinalScore(int finalScore) {
		this.finalScore = finalScore;
	}
	public List<Gamer> getGamers() {
		return gamers;
	}
	public void setGamers(List<Gamer> gamers) {
		this.gamers = gamers;
	}
	public List<Frame> getFrames() {
		return frames;
	}
	public void setFrames(List<Frame> frames) {
		this.frames = frames;
	}

	@Override
	public String toString() {
		return "======================================================\n [gamers=" + gamers + "\n frames=" + frames + "]\n================ finalScore=" + finalScore + " ===============";
	}
	
	
	
}
