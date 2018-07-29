package de.sebmey.kata.bowling;

import java.util.ArrayList;
import java.util.List;

public class FrameParser {

	public static final String DELIMITER = " ";
	
	public static Frame parse(String singleFrame) {
		if(StandardFrame.checkInputValidity(singleFrame)) {
			return new StandardFrame(singleFrame);
		} else if(SpareFrame.checkInputValidity(singleFrame)) {
			return new SpareFrame(singleFrame);
		} else if(StrikeFrame.checkInputValidity(singleFrame)) {
			return new StrikeFrame(singleFrame);
		} else {
			throw new IllegalArgumentException("Cannot find a frame to parse this input in. Please provide valid input.");
		}
	}

	public static List<Frame> parseLine(String lineOfFrames) {
		if(lineOfFrames == null) {
			throw new IllegalArgumentException("The input to parse cannot be null.");
		}
		
		String[] frames = lineOfFrames.split(DELIMITER);
		List<Frame> parseResult = new ArrayList<Frame>();
		
		for(String frame : frames) {
			Frame parsedFrame = FrameParser.parse(frame);
			parseResult.add(parsedFrame);
		}
		
		return parseResult;
	}

}
