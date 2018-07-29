package de.sebmey.kata.bowling;

public class SpareFrame implements Frame {
	
	private static final int SCORE = 10;
	private static final int LOOKAHEAD_THROWS = 1;
	
	private int firstThrow;
	private int secondThrow;
	private int bonusThrow;
	
	public SpareFrame(String spareFrameInput) {
		if(!checkInputValidity(spareFrameInput)) {
			throw new IllegalArgumentException("The input is invalid to create a standard frame. Please make sure it is exactly 2 characters long and only contains characters from this list: " + VALID_INPUT_CHARACTERS);
		}
		this.firstThrow = Frame.parseCharacterIntoScore(spareFrameInput.charAt(0));
		this.secondThrow = 10 - this.firstThrow;
		if(spareFrameInput.length() == 3) {
			this.bonusThrow = Frame.parseCharacterIntoScore(spareFrameInput.charAt(2));
		}
	}
	
	@Override
	public int getScore() {
		return SCORE;
	}

	public int getFirstThrow() {
		return firstThrow;
	}

	public int getSecondThrow() {
		return secondThrow;
	}

	public int getBonusThrow() {
		return bonusThrow;
	}
	
	@Override
	public int getLookAheadThrows() {
		return LOOKAHEAD_THROWS;
	}

	public static boolean checkInputValidity(String input) {
		if(input == null || input.length() < 2 || input.length() > 3) {
			return false;
		}
		if(input.charAt(1) != Frame.SPARE) {
			return false;
		}
		return true;
	}
	
}
