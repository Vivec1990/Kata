package de.sebmey.kata.bowling;

public class StandardFrame implements Frame {

	public static final int EXPECTED_INPUT_LENGTH = 2;
	
	private int firstThrow;
	private int secondThrow;
	
	public StandardFrame(String standardFrameInput) {
		if(!checkInputValidity(standardFrameInput)) {
			throw new IllegalArgumentException("The input is invalid to create a standard frame. Please make sure it is exactly 2 characters long and only contains characters from this list: " + VALID_INPUT_CHARACTERS);
		}
		this.firstThrow = Frame.parseCharacterIntoScore(standardFrameInput.charAt(0));
		this.secondThrow = Frame.parseCharacterIntoScore(standardFrameInput.charAt(1));
	}
	
	public static boolean checkInputValidity(String input) {
		return input != null && input.length() == 2 && VALID_INPUT_CHARACTERS.contains(input.charAt(0)+"") && VALID_INPUT_CHARACTERS.contains(input.charAt(1)+"");
	}

	@Override
	public int getScore() {
		return this.firstThrow + this.secondThrow;
	}

	public int getFirstThrow() {
		return firstThrow;
	}

	public int getSecondThrow() {
		return secondThrow;
	}

}
