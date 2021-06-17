package fr.laurent.bowlingGame;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import fr.laurent.bowlingGame.entities.Frame;
import fr.laurent.bowlingGame.entities.Game;
import fr.laurent.bowlingGame.entities.Gamer;
import fr.laurent.bowlingGame.entities.Roll;

@SpringBootApplication
public class BowlingApplication {

	public static void main(String[] args) {
		SpringApplication.run(BowlingApplication.class, args);
		
		int allFrame = 10;
		int tempScore = 0;
		int frameScore = 0;
		int totalScore = 0;
		int score1 = 0;
		int score2 = 0;
		int score3 = 0;
		int score4 = 0;
		Game game1 = new Game();
		Gamer gamer1 = new Gamer();
		gamer1.setName("Laurent");
		List<Frame> frames = new ArrayList<Frame>();
		List<Gamer> gamers = new ArrayList<Gamer>();
		gamers.add(gamer1);

		System.out.println("Gamers : " + gamer1.getName());
		game1.setGamers(gamers);
		
		while (allFrame != 0) {

			ArrayList<Roll> rolls =  new ArrayList<Roll>();
			Roll roll1 = new Roll();
			Roll roll2 = new Roll();
			
			int j = (11 - allFrame);
			Frame frame = new Frame();

			int frameNumber = frame.setFrameNumber(j);
			
			System.out.println("------- Start frame number : " + frameNumber + " -------------");

				score1 = roll1.gameRoll1();
				roll1.setPinsDown(score1);
				score2 = roll2.gameRoll2(score1);
				roll2.setPinsDown(score2);
				
				if(roll1.isStrike()) {
					frame.setBonusStrike(true);
					frame.setBonusFrame(10);
				} else if(roll2.isSpare()) {
					frame.setBonusSpare(true);
					frame.setBonusFrame(10);
				} 


			if (!frames.isEmpty()) {
				Frame previousFrame = previousFrame(frames,frameNumber);
				
				if(previousFrame.getBonusSpare() || previousFrame.getBonusStrike()) {
					
					if(previousFrame.getBonusSpare()) {
					
						previousFrame.setTempScore(previousFrame.getTempScore() + score1);
					
					}else{
		
						previousFrame.setTempScore(previousFrame.getTempScore()  + score1 + score2);
						if(frameNumber > 2) {
							Frame beforePreviousFrame = beforePreviousFrame(frames,frameNumber);
							if(beforePreviousFrame.getBonusStrike()) {
								previousFrame.setTempScore(previousFrame.getTempScore() + score1);
								beforePreviousFrame.setTempScore(beforePreviousFrame.getTempScore() + score1);
							}
						}
					}
					
				} else {
					
				}
				
				tempScore = previousFrame.getTempScore()+ score1 + score2;
				
				if(frameNumber == 10 && (frame.getBonusSpare() || frame.getBonusStrike())) {
					Roll roll3 = new Roll();
					score3 = roll3.gameRollBonus();
					roll3.setPinsDown(score3);
					rolls.add(roll3);
					
					if(frame.getBonusSpare()) {
						tempScore += score3;
					}else {
						if(score3 == 10) {
							previousFrame.setTempScore(previousFrame.getTempScore() + score1);
							Roll roll4 = new Roll();
							score4 = roll4.gameRollBonus();
							roll4.setPinsDown(score4);
							rolls.add(roll4);

							tempScore += (score1+score3+score4);
						}else {
							tempScore += (score1+score3);
						}
						
					}
					
					
				}else {
					
				}
			}else {

				tempScore = score1 +score2;
			}
			
			frameScore = frame.setFrameScore(score1 + score2);
			frame.setTempScore(tempScore);
			

			allFrame -= 1; 
			
			if(score1 == 10) {
				rolls.add(roll1);
			}else {
				rolls.add(roll1);
				rolls.add(roll2);
			}

			
			frame.setRolls(rolls);
			frames.add(frame);
			game1.setFrames(frames);
			System.out.println("------- End frame number : " + frame.getFrameNumber()+ " -------------\n");
		}
		
		for(Frame frame : frames) {
			System.out.println("frames " + frame.getFrameNumber() + " : " + frame.getRolls() + " --> score : " + frame.getTempScore());

		}

		
		int finalScore = (tempScore);
		System.out.println("totalscore : " + finalScore);
		game1.setFinalScore(tempScore);	
		gamer1.setScore(tempScore);
		
		System.out.println("game1 : \n" + game1);
		


	}

	private static Frame beforePreviousFrame(List<Frame> frames, int frameNumber) {
		return frames.get((frameNumber-3));
	}

	private static Frame previousFrame(List<Frame> frames, int frameNumber) {
		return frames.get((frameNumber-2));
	}


}

