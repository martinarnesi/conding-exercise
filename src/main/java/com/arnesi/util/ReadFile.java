package com.arnesi.util;

import java.util.SortedSet;

public interface ReadFile {

	/**
	 * Read the content of files and store the words in a Set
	 * 
	 * @param filePath
	 * @return the content of the file
	 */
	SortedSet<String> readFileContent(String filePath);
}