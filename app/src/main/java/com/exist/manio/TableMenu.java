package com.exist.manio.app;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.exist.manio.model.Table;
import com.exist.manio.core.TableService;
import com.exist.manio.core.TableServiceImpl;

class TableMenu {

    Table menuOptions(Table table, String optionChosen) {

        TableMenuControllerInterface tableMenuController = new TableMenuController();

        switch(optionChosen) {
            case "1" :  table = tableMenuController.readFile(table);
                        break;

            case "2" :  table = tableMenuController.createRandomTable();
                        break;

            case "3" :  tableMenuController.printTable(table);
                        break;

            case "4" :  tableMenuController.searchTable(table);
                        break;

            case "5" :  table = tableMenuController.editTable(table);
                        break;

            case "6" :  tableMenuController.sortTable(table);
                        break;

            case "7" :  tableMenuController.saveTable(table);
                        break;

            case "0" :  System.out.println(AppConstants.EXIT_MSG);
                        break;
                        
            default : System.out.println(AppConstants.MENU_ERROR);
                      break;
        }

        return table;

    }

    Table readFileArg(String filename) {

        TableService tableService = new TableServiceImpl();
    
        try {
            return tableService.readData(filename);
        }
        catch (FileNotFoundException e) {
            System.out.println (AppConstants.ARG_ERROR);
        }
        catch (IOException e) {
            System.out.println (e);
        }

        return new Table();
    }

    Table readDefaultFile(String filedata) {

        TableServiceImpl tableService = new TableServiceImpl();
    
        try {
            return tableService.readDataFromString(filedata);
        }
        catch (FileNotFoundException e) {
            System.out.println (AppConstants.ARG_ERROR);
        }
        catch (IOException e) {
            System.out.println (e);
        }

        return new Table();
    }

    void printMenu() {

        System.out.println(AppConstants.MENU_OPTIONS);

    }

}
