package de.sebmey.kata.bowling;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ BowlingTest.class, FrameParserTest.class, SpareFrameTest.class, StandardFrameTest.class,
		StrikeFrameTest.class })
public class BowlingTestSuite {

}
