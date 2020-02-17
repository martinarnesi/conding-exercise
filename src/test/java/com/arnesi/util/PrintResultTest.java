package com.arnesi.util;

import java.util.HashMap;
import java.util.Map;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @author MArnesi
 *
 */
public class PrintResultTest {
	
	private final PrintResult printResult = new PrintResultImpl();
	private final Map<String, Integer> mapTestEmpty = new HashMap<>();
	private final Map<String, Integer> mapTest = new HashMap<>();
	
	@Before
	public void setUp() throws Exception {
		mapTestEmpty.clear();

		mapTest.put("File1", 30);
		mapTest.put("File2", 100);
		mapTest.put("File3", 60);
		mapTest.put("File4", 45);
	}
	
	@Test
	public void printRankOrderEmptyMapTest() {
		final String NO_MATCHES_FOUND = "no matches found";
		final String result = printResult.printRankOrder(mapTestEmpty);
		
		Assert.assertEquals("Result value mismatch", NO_MATCHES_FOUND, result);
	}
	
	@Test
	public void printRankOrderResultTest() {
		final String sortedResult =	"File2 : 100%\n"+ 
									"File3 : 60%\n"  + 
									"File4 : 45%\n"  + 
									"File1 : 30%";
		
		final String result = printResult.printRankOrder(mapTest);
		
		Assert.assertEquals("Result value mismatch", sortedResult, result);
	}
}
