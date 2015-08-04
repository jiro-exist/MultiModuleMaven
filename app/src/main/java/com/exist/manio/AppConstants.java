package com.exist.manio.app;

public final class AppConstants {

	public static final String MENU_OPTIONS = 	"1: Read from file" + "\n"
								     +  "2: Create Random Data" + "\n"
								     +  "3: Display map" + "\n"
								     +  "4: Search" + "\n"
								     +  "5: Edit value" + "\n"
								     +  "6: Sort" + "\n"
								     +  "7: Save to Current File" + "\n"
								     +  "0: Exit";

    public static final String WELCOME_MSG = "Welcome!~";
    public static final String EXIT_MSG = "System exiting...";
    public static final String ARG_READ_MSG = "Reading the file provided...";
    public static final String DEFAULT_FILE_READ_MSG = "Reading the default file...";
    public static final String DEFAULT_FILE_ERROR = "Error in reading the default file...";

    public static final String DEFAULT_FILE = "default.txt";
    
    public static final String GET_XINDEX = "Enter the index of X:";
    public static final String GET_YINDEX = "Enter the index of Y:";
    public static final String GET_STRLENGTH = "Enter the length of the strings:";
    public static final String GET_FINDSTR = "Enter the string to be searched:";
    public static final String GET_REPLACESTR = "Enter the new string to replace:";
    public static final String GET_FILENAME = "Enter the filename:";
    public static final String GET_FILEPATH = "Enter the path and the filename:";
    public static final String GET_SORTTYPE = "Sort by ascending(a) or descending(d)?:";
    public static final String GET_EDITTYPE = "Change the key(k), the value(v) or both(b)?:";

    public static final String MENU_ERROR = "Kindly choose within scope";
    public static final String ARG_ERROR = "File not found, creating an empty table";
    public static final String FILE_ERROR = "File does not exist";
    public static final String INT_ERROR = "The number you have entered is too small.";
    public static final String INPUT_ERROR = "Empty string and spaces are not allowed";
    public static final String ENUM_ERROR = "Invalid option";
    public static final String SAVEFILE_ERROR = "Incorrect path and filename";
    public static final String INDEX_ERROR = "Incorrect index";

	private AppConstants () {

	}

}