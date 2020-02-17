Java Coding Exercise
~~~~~~~~~~~~~~~~~~~~
	The exercise is to write a command line driven text search engine, usage being: 
	
	$java mainClassFile pathToDirectoryContainingTextFiles
	
	This should read all the text files in the given directory, building an in memory representation of the
	files and their contents, and then give a command prompt at which interactive searches can be
	performed.	

Maven Build
~~~~~~~~~~~~
	* Maven is use for testing and packaging the application. Check pom.xml
	* Project Folder: coding-exercise2\


Run/Use the application
~~~~~~~~~~~~~~~~~~~~~~~

	λ java -jar SimpleSearch.jar text-files\
	Feb 17, 2020 11:55:38 AM com.arnesi.application.SimpleSearchApp startApp
	INFO: 15 files read in directory text-files\
	
	search> be or not to be     ----> words to search
	no matches found
	
	search> un hombre			----> words to search
	simplefile1.txt : 100%
	simplefile10.txt : 100%
	simplefile9.txt : 100%
	simplefile12.txt : 50%
	simplefile5.txt : 50%
	simplefile4.txt : 50%
	simplefile2.txt : 50%
	simplefile3.txt : 50%
	simplefile13.txt : 50%
	simplefile14.txt : 50%
	
	search> :quit				----> type ":quit" for exit 
	goodbye...

Created by: Martin Arnesi - martinarnesi@gmail.com 02-16-2020