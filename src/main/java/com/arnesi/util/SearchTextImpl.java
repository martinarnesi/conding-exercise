package com.arnesi.util;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.arnesi.model.TextFile;

/**
 * @author MArnesi
 *
 */
public class SearchTextImpl implements SearchText {
	
	@Override
	public Map<String, Integer> performSearch(final List<TextFile> textFileList, String wordsToSearch) {

		Map<String, Integer> filesRank = new HashMap<>();
		String[] sanitizeWords = wordsToSearch 	// Sanitize input string.
				.replaceAll("\\P{Print}", "")
				.toLowerCase()
				.split(" ");

		int total = sanitizeWords.length; 		// Total numbers of words.

		for (TextFile textFile : textFileList) {
			int occurrence = 0;

			occurrence = textFile.findWords(sanitizeWords);
			if (occurrence == 0) { 				// if no words found in the text, continue with the next TextFile object.
				continue;
			}

			filesRank.put(textFile.getFileName(), 100 * occurrence / total);
		}
		return filesRank;
	}
}