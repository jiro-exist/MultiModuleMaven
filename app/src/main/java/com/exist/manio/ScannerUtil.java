package com.exist.manio.app;

import java.util.Scanner;
import java.io.Console;

import org.apache.commons.lang3.StringUtils;

public class ScannerUtil {

    private static Console console = System.console();

    private ScannerUtil() {

    }

	public static String getInput() {
		if (console != null) {
			try (Scanner sc = new Scanner(console.reader())) {
				return sc.nextLine();
			}
			catch (Exception e) {
				System.out.println("Error in getInput");
			}
		}
		return null;
	}

	public static int getInt() {
        
		if (console != null) {
			try (Scanner sc = new Scanner(console.reader())) {
				String inputHandler = sc.nextLine();

		        //check if the data is an integer, else recursive
		        if ( StringUtils.isNumeric(inputHandler) ) {
		            return Integer.parseInt(inputHandler);
		        }
		        else {
		            System.out.println("Error: Please enter an integer.");
		            return getInt();
		        }
			}
			catch (Exception e) {
				System.out.println("Error in getInt");
			}
		}
		return 0;
		
	}

}