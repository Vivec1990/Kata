package de.sebmey.kata.bowling;

import java.util.List;

public class Bowling {

	public static final int FRAMES_PER_GAME = 10;
	
	private List<Frame> frames;
	
	public Bowling(String lineOfFrames) {
		this.frames = FrameParser.parseLine(lineOfFrames);
	}

	public int calculateScore() {
		int score = 0;
		for(int i = 0; i < FRAMES_PER_GAME; i++) {
			Frame currentFrame = frames.get(i);
			if(currentFrame instanceof StandardFrame) {
				score += currentFrame.getScore();
			} else if(currentFrame instanceof SpareFrame) {
				score += getTotalScoreForSpare(currentFrame, i);
			} else if(currentFrame instanceof StrikeFrame) {
				score += getTotalScoreForStrike(currentFrame, i);
			}
		}
		return score;
	}
	
	private int getTotalScoreForSpare(Frame spareFrame, int frameIndex) {
		if(this.isLastFrame(frameIndex)) {
			return spareFrame.getScore() + spareFrame.getBonusThrow();
		}
		Frame nextFrame = frames.get(frameIndex+1);
		return spareFrame.getScore() + nextFrame.getFirstThrow();
	}
	
	private int getTotalScoreForStrike(Frame strikeFrame, int frameIndex) {
		if(this.isLastFrame(frameIndex)) {
			return strikeFrame.getScore() + strikeFrame.getSecondThrow() + strikeFrame.getBonusThrow();
		}
		Frame nextFrame = frames.get(frameIndex+1);
		if(nextFrame instanceof StrikeFrame && !isLastFrame(frameIndex+1)) {
			Frame afterNextFrame = frames.get(frameIndex+1);
			return strikeFrame.getScore() + nextFrame.getScore() + afterNextFrame.getFirstThrow();
		} else {
			return strikeFrame.getScore() + nextFrame.getFirstThrow() + nextFrame.getSecondThrow();
		}
	}
	
	private boolean isLastFrame(int frameNumber) {
		return FRAMES_PER_GAME == frameNumber+1;
	}

}
