package de.sebmey.kata.bowling;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class StandardFrameTest {

	@Rule
	public ExpectedException thrown = ExpectedException.none();

	@Test
	public void testStandardFrameCreationWithValidInput() {
		String validStandardFrameInput = "44";
		final int expectedScore = 8;
		final int expectedFirstThrowValue = 4;
		final int expectedSecondThrowValue = 4;
		
		StandardFrame frameToTest = new StandardFrame(validStandardFrameInput);

		assertNotNull(frameToTest);
		assertEquals(expectedScore, frameToTest.getScore());
		assertEquals(expectedFirstThrowValue, frameToTest.getFirstThrow());
		assertEquals(expectedSecondThrowValue, frameToTest.getSecondThrow());
	}

	@Test
	public void testStandardFrameCreationWithInvalidInputCharacters() {
		String invalidStandardFrameInput = "yz";
		thrown.expect(IllegalArgumentException.class);

		new StandardFrame(invalidStandardFrameInput);
	}
	
	@Test
	public void testStandardFrameCreationWithInvalidInputLength() {
		String tooShortFrameInput = "4";
		thrown.expect(IllegalArgumentException.class);
		
		new StandardFrame(tooShortFrameInput);
	}
	
	@Test
	public void testStandardFrameCreationWithEmptyInput() {
		thrown.expect(IllegalArgumentException.class);
		new StandardFrame(null);
	}

	@Test
	public void testStandardFrameCreationWithNonStandardFrameInput() {
		String strikeFrameInput = "X";
		Frame strike = new StrikeFrame(strikeFrameInput);
		final int expectedScore = 10;
		assertNotNull(strike);
		assertEquals(expectedScore, strike.getScore());
		
		thrown.expect(IllegalArgumentException.class);
		new StandardFrame(strikeFrameInput);
	}
}