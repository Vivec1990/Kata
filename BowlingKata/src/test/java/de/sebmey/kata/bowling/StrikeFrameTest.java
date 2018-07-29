package de.sebmey.kata.bowling;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class StrikeFrameTest {
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void testStrikeFrameCreationWithValidInput() {
		final int expectedScore = 10;
		
		StrikeFrame strikeFrame = new StrikeFrame(Frame.STRIKE+"");
		assertEquals(expectedScore, strikeFrame.getScore());
	}
	
	@Test
	public void testStrikeFrameCreationWithInvalidInput() {
		final String invalidStrikeFrameInput = "u";
		thrown.expect(IllegalArgumentException.class);
		new StrikeFrame(invalidStrikeFrameInput);
	}
	
	@Test
	public void testStrikeFrameCreationWithNonStrikeFrameInput() {
		final String standardFrameInput = "44";
		
		StandardFrame frame = new StandardFrame(standardFrameInput);
		
		final int expectedFirstThrow = 4;
		final int expectedSecondThrow = 4;
		final int expectedScore = 8;
		
		assertNotNull(frame);
		assertEquals(expectedFirstThrow, frame.getFirstThrow());
		assertEquals(expectedSecondThrow, frame.getSecondThrow());
		assertEquals(expectedScore, frame.getScore());
		
		thrown.expect(IllegalArgumentException.class);
		new StrikeFrame(standardFrameInput);
	}
	
	@Test
	public void testStrikeFrameCreationWithEmptyInput() {
		thrown.expect(IllegalArgumentException.class);
		new StrikeFrame(null);
	}
	
	@Test
	public void testStrikeFrameCreationWithWrongInputLength() {
		final String wrongStrikeFrameInputLength = "X45678";
		thrown.expect(IllegalArgumentException.class);
		new StrikeFrame(wrongStrikeFrameInputLength);
	}
	
}
