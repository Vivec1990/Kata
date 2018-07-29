package de.sebmey.kata.bowling;

public interface Frame {
	public static final char SPARE = '/';
	public static final char STRIKE = 'X';
	public static final char ZERO = '-';
	public static final int LOOKAHEAD_THROWS = 0;
	
	public static final String VALID_INPUT_CHARACTERS = "123456789-/X";
	
	int getScore();

	boolean checkInputValidity(String input);
	
	default int getLookAheadThrows() {
		return LOOKAHEAD_THROWS;
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
