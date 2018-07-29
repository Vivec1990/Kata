package de.sebmey.kata.bowling;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class SpareFrameTest {
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void testSpareFrameCreationWithValidInput() {
		final String validSpareFrameInput = "4/";
		SpareFrame spareFrame = new SpareFrame(validSpareFrameInput);
		
		assertNotNull(spareFrame);
		
		final int expectedFirstThrowValue = 4;
		final int expectedSecondThrowValue = 6;
		final int expectedScore = 10;
		
		assertEquals(expectedFirstThrowValue, spareFrame.getFirstThrow());
		assertEquals(expectedSecondThrowValue, spareFrame.getSecondThrow());
		assertEquals(expectedScore, spareFrame.getScore());
	}
	
	@Test
	public void testSpareFrameCreationWithInvalidInput() {
		final String invalidSpareFrameInput = "4p";
		thrown.expect(IllegalArgumentException.class);
		new SpareFrame(invalidSpareFrameInput);
	}
	
	@Test
	public void testSpareFrameCreationWithEmptyInput() {
		thrown.expect(IllegalArgumentException.class);
		new SpareFrame(null);
	}
	
	@Test
	public void testSpareFrameCreationWithNonSpareFrameInput() {
		final String nonSpareFrameInput = "44";
		thrown.expect(IllegalArgumentException.class);
		new SpareFrame(nonSpareFrameInput);
	}
	
	@Test
	public void testSpareFrameCreatioNWithInvalidInputLength() {
		final String tooShortInput = "/";
		thrown.expect(IllegalArgumentException.class);
		new SpareFrame(tooShortInput);
	}

}
