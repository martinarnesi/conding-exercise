package com.arnesi.util;

import java.io.File;
import java.io.IOException;
import java.util.SortedSet;
import java.util.TreeSet;

import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TemporaryFolder;

/**
 * @author MArnesi
 *
 */
public class ReadFileTest {
	private final ReadFile readFile = new ReadFileImpl();
	private final SortedSet<String> tempText = new TreeSet<>(); 

	@Rule
	public TemporaryFolder tempFolder = new TemporaryFolder();
	
	@Before
	public void setUp() throws Exception {
		tempText.add("practice");
		tempText.add("quiz");
		tempText.add("code");
	}

	@Test
	@SuppressWarnings("deprecation")
    public void readFileContentTest() throws IOException {
		final File tempFile = tempFolder.newFile("tempFile.txt");
        
		// Note: File is guaranteed to be deleted after the test finishes.
		FileUtils.writeStringToFile(tempFile, "practice quiz code");
 
		// Read file content
		SortedSet<String> textResult = readFile.readFileContent(tempFile.getAbsolutePath());
        
        // Verify the content
        Assert.assertEquals("Result value mismatch",tempText , textResult);
    }
}