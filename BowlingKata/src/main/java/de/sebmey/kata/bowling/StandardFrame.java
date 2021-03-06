package de.sebmey.kata.bowling;

public class StandardFrame implements Frame {

	public static final int EXPECTED_INPUT_LENGTH = 2;
	
	private int firstThrow;
	private int secondThrow;
	
	public StandardFrame(String standardFrameInput) {
		if(!checkInputValidity(standardFrameInput)) {
			throw new IllegalArgumentException("The input is invalid to create a standard frame.");
		}
		this.firstThrow = Frame.parseCharacterIntoScore(standardFrameInput.charAt(0));
		this.secondThrow = Frame.parseCharacterIntoScore(standardFrameInput.charAt(1));
	}
	
	public static boolean checkInputValidity(String input) {
		return input != null && input.length() == 2 && VALID_STANDARD_FRAME_CHARACTERS.contains(input.charAt(0)+"") && VALID_STANDARD_FRAME_CHARACTERS.contains(input.charAt(1)+"");
	}

	@Override
	public int getScore() {
		return this.firstThrow + this.secondThrow;
	}

	@Override
	public int getFirstThrow() {
		return firstThrow;
	}

	@Override
	public int getSecondThrow() {
		return secondThrow;
	}

}
