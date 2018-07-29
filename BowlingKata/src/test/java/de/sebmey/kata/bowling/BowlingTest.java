package de.sebmey.kata.bowling;

import static org.junit.Assert.*;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class BowlingTest {
	
	@Rule
	public ExpectedException thrown = ExpectedException.none();
	
	@Test
	public void testBowlingScoreWithPerfectGame() {
		final String perfectGame = "X X X X X X X X X XXX";
		final int expectedScore = 300;
		Bowling game = new Bowling(perfectGame);
		assertNotNull(game);
		assertEquals(expectedScore, game.calculateScore());
	}
	
	@Test
	public void testBowlingScoreWithTwoStrikesAndTwoSpares() {
		final String gameWithTwoStrikesAndTwoSpares = "-- X 6/ 71 6/ X 81 -- 21 44";
		final int expectedScore = 104;
		Bowling game = new Bowling(gameWithTwoStrikesAndTwoSpares);
		assertNotNull(game);
		assertEquals(expectedScore, game.calculateScore());
	}
	
	@Test
	public void testBowlingScoreTenPairsOfNineAndMiss() {
		final String tenPairsOfNineAndMiss = "9- 9- 9- 9- 9- 9- 9- 9- 9- 9-";
		final int expectedScore = 90;
		Bowling game = new Bowling(tenPairsOfNineAndMiss);
		assertNotNull(game);
		assertEquals(expectedScore, game.calculateScore());
	}
	
	@Test
	public void testBowlingScoreAllThrowsFivePins() {
		final String allThrowsFivePins = "5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/ 5/5";
		final int expectedScore = 150;
		Bowling game = new Bowling(allThrowsFivePins);
		assertNotNull(game);
		assertEquals(expectedScore, game.calculateScore());
	}
	
	@Test
	public void testBowlingGameWithNonFullGameInput() {
		final String fiveFrames = "-- 11 22 33 44";
		Bowling game = new Bowling(fiveFrames);
		thrown.expect(IndexOutOfBoundsException.class);
		game.calculateScore();
	}
	
	@Test
	public void testBowlingGameWithEmptyInput() {
		thrown.expect(IllegalArgumentException.class);
		new Bowling(null);
	}
}