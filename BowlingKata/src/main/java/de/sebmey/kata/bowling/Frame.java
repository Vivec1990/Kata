package de.sebmey.kata.bowling;

public interface Frame {
	public static final char SPARE = '/';
	public static final char STRIKE = 'X';
	public static final char ZERO = '-';
	
	public static final String VALID_STANDARD_FRAME_CHARACTERS = "123456789-";
	
	int getScore();
	int getFirstThrow();
	int getSecondThrow();

	default int getBonusThrow() {
		return 0;
	}
	
	public static int parseCharacterIntoScore(char c) {
		if(c==ZERO) {
			return 0;
		} else if(c==SPARE || c==STRIKE) {
			return 10;
		} else {
			return Integer.parseInt(c+"");
		}
	}
}
