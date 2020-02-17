package com.arnesi.util;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.SortedSet;
import java.util.TreeSet;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.arnesi.model.TextFile;

/**
 * @author MArnesi
 *
 */
public class SearchTextTest {

	private final SearchText searchText = new SearchTextImpl();
	private final List<TextFile> tempFileListRepresentation = new ArrayList<>();
	private final Map<String, Integer> tempFileRank = new HashMap<>();

	@Before
	public void setUp() throws Exception {
		final String file1Name = "file1.txt";
		final SortedSet<String> file1Content = new TreeSet<>();

		file1Content.add("practice");
		file1Content.add("quiz");
		file1Content.add("code");

		final String file2Name = "file2.txt";
		final SortedSet<String> file2Content = new TreeSet<>();

		file2Content.add("practice");
		file2Content.add("quit");
		file2Content.add("code");

		tempFileListRepresentation.add(new TextFile(file1Name, file1Content));
		tempFileListRepresentation.add(new TextFile(file2Name, file2Content));

		tempFileRank.put("file1.txt", 100);
		tempFileRank.put("file2.txt", 66);
	}

	@Test
	public void performSearchTest() throws IOException {
		final String tempWordsToSearch1 = "practice quiz code";
		final String tempWordsToSearch2 = "any word present";

		final Map<String, Integer> mapResultWithResults = searchText.performSearch(tempFileListRepresentation,
				tempWordsToSearch1);
		final Map<String, Integer> mapResultWithoutResults = searchText.performSearch(tempFileListRepresentation,
				tempWordsToSearch2);

		Assert.assertEquals("Result value mismatch", tempFileRank, mapResultWithResults);
		Assert.assertTrue("Result value mismatch", mapResultWithoutResults.isEmpty());
	}
}
