package de.sebmey.kata.bowling;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class FrameParserTest {
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void testParsingOfStandardFrame() {
		final String standardFrameInput = "44";
		final int expectedScore = 8;
		final int expectedFirstThrow = 4;
		final int expectedSecondThrow = 4;
		
		Frame parsedFrame = FrameParser.parse(standardFrameInput);
		
		assertNotNull(parsedFrame);
		assertEquals(StandardFrame.class, parsedFrame.getClass());
		
		assertEquals(expectedScore, parsedFrame.getScore());
		assertEquals(expectedFirstThrow, parsedFrame.getFirstThrow());
		assertEquals(expectedSecondThrow, parsedFrame.getSecondThrow());
	}
	
	@Test
	public void testParsingOfSpareFrame() {
		final String spareFrameInput = "4/";
		final int expectedScore = 10;
		final int expectedFirstThrow = 4;
		final int expectedSecondThrow = 6;
		
		Frame parsedFrame = FrameParser.parse(spareFrameInput);
		
		assertNotNull(parsedFrame);
		assertEquals(SpareFrame.class, parsedFrame.getClass());
		
		assertEquals(expectedScore, parsedFrame.getScore());
		assertEquals(expectedFirstThrow, parsedFrame.getFirstThrow());
		assertEquals(expectedSecondThrow, parsedFrame.getSecondThrow());
	}
	
	@Test
	public void testParsingOfStrikeFrame() {
		final String strikeFrameInput = "X";
		final int expectedScore = 10;
		
		Frame parsedFrame = FrameParser.parse(strikeFrameInput);
		
		assertNotNull(parsedFrame);
		assertEquals(StrikeFrame.class, parsedFrame.getClass());
		assertEquals(expectedScore, parsedFrame.getScore());
	}
	
	@Test
	public void testParsingOfInvalidInput() {
		final String invalidInput = "lorem ipsum";
		thrown.expect(IllegalArgumentException.class);
		FrameParser.parse(invalidInput);
	}
	
	@Test
	public void testParsingOfCompleteLineOfStandardFrames() {
		final String lineOfStandardFrames = "-- 1- 2- 3- 4- 5- 6- 7- 8- 9-";
		List<Frame> framesToTest = FrameParser.parseLine(lineOfStandardFrames);
		
		assertNotNull(framesToTest);
		final int expectedListLength = 10;
		assertEquals(expectedListLength, framesToTest.size());
		
		for(int i = 0; i < framesToTest.size(); i++) {
			Frame singleFrame = framesToTest.get(i);
			assertEquals(StandardFrame.class, singleFrame.getClass());
			final int expectedScore = i;
			assertEquals(expectedScore, singleFrame.getScore());
		}
	}
	
	@Test
	public void testParsingOfCompleteLineOfSpares() {
		final String lineOfSpares = "-/ 1/ 2/ 3/ 4/ 5/ 6/ 7/ 8/ 9/-";
		List<Frame> framesToTest = FrameParser.parseLine(lineOfSpares);
		
		assertNotNull(framesToTest);
		final int expectedListLength = 10;
		assertEquals(expectedListLength, framesToTest.size());
		
		for(int i = 0; i < framesToTest.size(); i++) {
			Frame singleFrame = framesToTest.get(i);
			assertEquals(SpareFrame.class, singleFrame.getClass());
			final int expectedScore = 10;
			final int expectedFirstThrow = i;
			assertEquals(expectedScore, singleFrame.getScore());
			assertEquals(expectedFirstThrow, singleFrame.getFirstThrow());
		}
	}
	
	@Test
	public void testParsingOfCompleteLineOfStrikes() {
		final String perfectGame = "X X X X X X X X X XXX";
		List<Frame> framesToTest = FrameParser.parseLine(perfectGame);
		
		assertNotNull(framesToTest);
		final int expectedListLength = 10;
		assertEquals(expectedListLength, framesToTest.size());
		
		for(int i = 0; i < framesToTest.size(); i++) {
			Frame singleFrame = framesToTest.get(i);
			assertEquals(StrikeFrame.class, singleFrame.getClass());
			final int expectedScore = 10;
			assertEquals(expectedScore, singleFrame.getScore());
		}
	}
	
	@Test
	public void testParsingOfCompleteLineWithInvalidFrames() {
		final String lineWithInvalidFrames = "-- cc v lorem ipsum 5/ X 11 -- --";
		thrown.expect(IllegalArgumentException.class);
		FrameParser.parseLine(lineWithInvalidFrames);
	}

}
