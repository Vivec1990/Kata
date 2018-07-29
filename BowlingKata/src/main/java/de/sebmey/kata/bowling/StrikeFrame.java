package de.sebmey.kata.bowling;

public class StrikeFrame implements Frame {

	private static final int SCORE = 10;
	private static final int LOOKAHEAD_THROWS = 1;
	
	private int firstThrow;	
	private int bonusThrow;
	private int secondBonusThrow;
	
	public StrikeFrame(String strikeFrameInput) {
		if(!checkInputValidity(strikeFrameInput)) {
			throw new IllegalArgumentException("The input is invalid to create a strike frame. Please make sure it is exactly 2 characters long and only contains characters from this list: " + VALID_INPUT_CHARACTERS);
		}
		this.firstThrow = Frame.parseCharacterIntoScore(strikeFrameInput.charAt(0));
		this.secondBonusThrow = 10 - this.firstThrow;
		if(strikeFrameInput.length() == 3) {
			this.bonusThrow = Frame.parseCharacterIntoScore(strikeFrameInput.charAt(2));
		}
	}
	
	@Override
	public int getScore() {
		return SCORE;
	}

	@Override
	public int getFirstThrow() {
		return firstThrow;
	}

	@Override
	public int getSecondThrow() {
		return bonusThrow;
	}

	@Override
	public int getBonusThrow() {
		return secondBonusThrow;
	}
	
	@Override
	public int getLookAheadThrows() {
		return LOOKAHEAD_THROWS;
	}

	public static boolean checkInputValidity(String input) {
		if(input == null || input.length() < 1 || input.length() > 3) {
			return false;
		}
		if(input.charAt(0) != Frame.STRIKE) {
			return false;
		}
		if(input.length() == 3 && input.charAt(1) != Frame.STRIKE) {
			return false;
		}
		return true;
	}
	
}
