package com.exist.manio.app;

import java.io.File;
import java.lang.ClassNotFoundException;
import java.io.IOException;

import org.apache.commons.io.IOUtils;

import com.exist.manio.model.Table;

public class TableMain {

    public static void main(String args[]) {

        Table table = null;

        TableMenu tableMenu = new TableMenu();
            
        System.out.println(AppConstants.WELCOME_MSG);

        if(args.length > 0) {
            System.out.println(AppConstants.ARG_READ_MSG);
            System.out.println();
            table = tableMenu.readFileArg(args[0]);
        }
        else {
            try {
                Class cls = Class.forName("com.exist.manio.app.TableMain");
                ClassLoader classLoader = cls.getClassLoader();
                String result = IOUtils.toString(classLoader.getResourceAsStream(AppConstants.DEFAULT_FILE));
                System.out.println(AppConstants.DEFAULT_FILE_READ_MSG);
                table = tableMenu.readDefaultFile(result);
            }
            catch (IOException e) {
                System.out.println(e);
            }
            catch (ClassNotFoundException e) {
                System.out.println(e);
                System.out.println(AppConstants.DEFAULT_FILE_ERROR);
                table = new Table();
            }
        }

        String chosen = "";

        while(!Validator.isDone(chosen)) {

            System.out.println();
            tableMenu.printMenu();
            System.out.println();

            chosen = ScannerUtil.getInput();

            table = tableMenu.menuOptions(table, chosen);

        }

    }

}