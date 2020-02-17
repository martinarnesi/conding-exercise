package com.arnesi.util;

import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author MArnesi
 *
 */
public class PrintResultImpl implements PrintResult {
	private static final int MAX_RESULTS = 10;
	private static final String NO_MATCHES_FOUND = "no matches found";
	
	@Override
	public String printRankOrder(final Map<String, Integer> matchingFilenamesRank) {
		if(matchingFilenamesRank.isEmpty()) {
			return NO_MATCHES_FOUND;
		}
		
		return matchingFilenamesRank.entrySet()
				.stream()
				.sorted(Map.Entry.<String, Integer>comparingByValue().reversed()) 	// Sorted by value in reversed order.
				.limit(MAX_RESULTS)												 	// Top 10(max) matching filenames in rank order
				.map(entry -> entry.getKey() + " : " +entry.getValue() + "%")
				.collect(Collectors.joining("\n"));
	}
}