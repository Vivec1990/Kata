package de.sebmey.kata.bowling;

public interface Frame {
	
	int firstThrow = 0;
	int secondThrow = 0;
	int bonusThrow = 0;
	
	default int getScore() {
		return 0;
	}	
}
