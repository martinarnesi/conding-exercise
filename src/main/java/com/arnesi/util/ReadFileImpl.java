package com.arnesi.util;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.SortedSet;
import java.util.TreeSet;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import com.arnesi.application.SimpleSearchApp;

/**
 * @author MArnesi
 *
 */
public class ReadFileImpl implements ReadFile {
	
	private static final Logger LOGGER = Logger.getLogger(SimpleSearchApp.class.getName());

	@Override
	public SortedSet<String> readFileContent(String filePath){
		
		SortedSet<String> text = new TreeSet<>();					// Assuming that two equal words will be omitted
	    try (Stream<String> stream = Files.lines(Paths.get(filePath), StandardCharsets.UTF_8)) {
	    	text = stream
	    			.flatMap(s -> Arrays.stream(s.split("\\W+"))) 	// Separate a String based on non-word characters.
	    			.filter(s -> !s.matches("\\d+")) 				// Find a remove Strings that are all digits.
	    			.map(s -> s.toLowerCase().trim())				// Lower case the word and shave off surrounding whitespace.
	    			.filter(s -> s.length() >= 2)  					// Assuming a word have a less 2 characters.
	    			.collect(Collectors.toCollection(TreeSet::new));
	        
	    } catch (IOException e) {
	    	LOGGER.severe(e.getMessage());
	    }
	    return text;
	}
}