package com.arnesi.util;

import java.util.List;
import java.util.Map;

import com.arnesi.model.TextFile;

public interface SearchText {

	/**
	 * Search engine that checks if the words are contained in the textFile.
	 * If so, add add the FileName and the % occurrence in a Map<String, Integer> 
	 * 
	 * @param textFileList
	 * @param wordsToSearch
	 * @return a Map<String, Integer> with the FileName as key and Rank as a value.
	 */
	Map<String, Integer> performSearch(List<TextFile> textFileList, String wordsToSearch);
}