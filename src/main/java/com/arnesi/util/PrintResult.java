 package com.arnesi.util;

import java.util.Map;

/**
 * @author MArnesi
 *
 */
public interface PrintResult {
	
	/**
	 * @param matchingFilenamesRank
	 * @return Return a String with results for the matching files that contains words. 
	 */
	String printRankOrder(Map<String, Integer> matchingFilenamesRank);
}