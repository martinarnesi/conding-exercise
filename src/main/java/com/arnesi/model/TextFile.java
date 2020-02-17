package com.arnesi.model;

import java.util.SortedSet;

/**
 * @author MArnesi
 *
 */
public class TextFile {

	private final String fileName;
	private final SortedSet<String> fileContent;
	
	public TextFile(String fileName, SortedSet<String> fileContent) {
		this.fileName = fileName;
		this.fileContent = fileContent;
	}

	public int findWords(String[] words) {
		int occurrence = 0; 	// Number of occurrences

		for (String word : words) {
			if (this.fileContent.contains(word)) {
				occurrence++; 	// We've found our word
			}
		}
		return occurrence;
	}
	public String getFileName() {
		return fileName;
	}
}