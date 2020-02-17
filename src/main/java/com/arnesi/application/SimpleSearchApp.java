package com.arnesi.application;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.logging.Logger;

import com.arnesi.model.TextFile;
import com.arnesi.util.PrintResult;
import com.arnesi.util.PrintResultImpl;
import com.arnesi.util.ReadFile;
import com.arnesi.util.ReadFileImpl;
import com.arnesi.util.SearchText;
import com.arnesi.util.SearchTextImpl;

/**
 * @author MArnesi
 *
 */
public class SimpleSearchApp {

	private static final Logger LOGGER = Logger.getLogger(SimpleSearchApp.class.getName());

	private final ReadFile readFile;
	private final PrintResult printResult;
	private final SearchText searchText;

	public SimpleSearchApp() {
		readFile = new ReadFileImpl();
		printResult = new PrintResultImpl();
		searchText = new SearchTextImpl();
	}

	/**
	 * Start point
	 * @param args: String[] array having directory name. 
	 */
	public void startApp(String[] args) {
		if (args.length == 0) {
			throw new IllegalArgumentException("No directory given to index.");
		}

		final String folderName = args[0];
		final File files = new File(folderName);
		final String directoryInfo = String.format("%s files read in directory %s%n", files.list().length, folderName);

		LOGGER.info(directoryInfo);

		// Creating memory representation for all the files inside folder
		final List<TextFile> fileListRepresentation = new ArrayList<>();
		for (File file : files.listFiles()) {
			fileListRepresentation.add(new TextFile(file.getName(), readFile.readFileContent(file.getAbsolutePath())));
		}

		getUserInput(fileListRepresentation);
	}

	/**
	 * Obtain user input and perform the search
	 * 
	 * @param fileListRepresentation: in memory representation
	 */
	private void getUserInput(final List<TextFile> fileListRepresentation) {
		Scanner keyboard = new Scanner(System.in);
		String wordsToSearch;
		while (true) {
			System.out.printf("%nsearch> ");
			wordsToSearch = keyboard.nextLine();

			// Assuming same input show in exercise, check for ":quit" string at first position in array.
			if (wordsToSearch.contains(":quit")) {
				keyboard.close();
				System.out.printf("goodbye...");
				break;
			}
			
			Map<String, Integer> rankedWords = searchText.performSearch(fileListRepresentation, wordsToSearch);
			System.out.println(printResult.printRankOrder(rankedWords));
		}
	}
}