package fr.laurent.bowlingGame.entities;

import java.util.ArrayList;
import java.util.List;

public class BowlingGame {
	private static int counter;
    List<Frame> frames = new ArrayList<>();
    Frame actualFrame;
    Frame prevFrame;
    private int roll;

    public BowlingGame() {
        counter = 0;
    }

    public void roll(int pins) {
        if (++roll == 1) {
            actualFrame = new Frame();
            actualFrame.firstRoll = pins;
            if (prevFrame != null) {
                prevFrame.nextFrame = actualFrame;
                actualFrame.prevFrame = prevFrame;
            }
            frames.add(actualFrame);
        } else {
            actualFrame.secondRoll = pins;
            roll = 0;
        }
        if (actualFrame.isStrike()) {
            roll = 0;
        }
        prevFrame = actualFrame;
    }

    public int score() {
        gameCheck();
        int result = 0;
        for (Frame frame : frames) {
            frame.check();
            result += frame.isBonus() ? 0 : frame.getScore();
        }
        return result;
    }

    private void gameCheck() {
        if (frames.size() < 10) {
            throw new IllegalStateException("Score cannot be taken until the end of the game");
        }
    }

    class Frame {

        private int num;
        private int firstRoll;
        private int secondRoll;
        private Frame nextFrame;
        private Frame prevFrame;

        public Frame() {
            num = ++counter;
        }

        public boolean isStrike() {
            return firstRoll == 10;
        }

        public boolean isSpare() {
            return firstRoll + secondRoll == 10 && !isStrike();
        }

        public boolean isBonus() {
            return num > 10;
        }

        public int getScore() {
            int result;
            if (isSpare() || isStrike()) {
                result = 10 + (nextFrame != null ? nextFrame.firstRoll : 0);
                if (isStrike() && nextFrame != null) {
                    if (nextFrame.isStrike()) {
                        result += nextFrame.nextFrame != null ? nextFrame.nextFrame.firstRoll : 0;
                    } else {
                        result += nextFrame.secondRoll;
                    }
                }
            } else {
                result = firstRoll + secondRoll;
            }
            return result;
        }

        public void check() {
            if (firstRoll < 0 || secondRoll < 0) {
                throw new IllegalStateException("Negative roll is invalid");
            }
            if (firstRoll > 10 || firstRoll + secondRoll > 10) {
                throw new IllegalStateException("Pin count exceeds pins on the lane");
            }
            if (num == 10) {
                if (nextFrame != null && !isStrike() && !isSpare()) {
                    throw new IllegalStateException("Cannot roll after game is over");
                }
                if (nextFrame == null && (isStrike() || isSpare())) {
                    throw new IllegalStateException("Score cannot be taken until the end of the game");
                }
            }
            if (num == 11 && prevFrame.isStrike()) {
                if ((!isStrike() && secondRoll == 0) || (isStrike() && nextFrame == null)) {
                    throw new IllegalStateException("Score cannot be taken until the end of the game");
                }
            }
        }
    }
}
