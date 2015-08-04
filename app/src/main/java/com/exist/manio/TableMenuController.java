package com.exist.manio.app;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.exist.manio.model.Table;
import com.exist.manio.model.CellData;
import com.exist.manio.core.TableService;
import com.exist.manio.core.TableServiceImpl;
import com.exist.manio.core.EditTypeEnum;
import com.exist.manio.core.SortTypeEnum;

public class TableMenuController implements TableMenuControllerInterface {

    public Table readFile(Table table) {

        TableService tableService = new TableServiceImpl();

        System.out.println(AppConstants.GET_FILENAME);
        String filename = ScannerUtil.getInput();
        if (Validator.validateFile(filename)) {
            try {
                table = tableService.readData(filename);
            }
            catch (FileNotFoundException e) {
                System.out.println (e);
            }
            catch (IOException e) {
                System.out.println (e);
            }
        }
        return table;
    }

    public Table createRandomTable() {

        TableService tableService = new TableServiceImpl();

        int xSize = 0, ySize = 0, stringLength = 0;

        System.out.println(AppConstants.GET_XINDEX);
        int holder = ScannerUtil.getInt();
        if(Validator.validateMinInt(holder, 1)){
            xSize = holder;
        }
        else {
            return null;
        }

        System.out.println(AppConstants.GET_YINDEX);
        holder = ScannerUtil.getInt();
        if(Validator.validateMinInt(holder, 1)){
            ySize = holder;
        }
        else {
            return null;
        }

        System.out.println(AppConstants.GET_STRLENGTH);
        holder = ScannerUtil.getInt();
        if(Validator.validateMinInt(holder, 1)){
            stringLength = holder;
        }
        else {
            return null;
        }

        return tableService.createRandomTable(xSize, ySize, stringLength);
    }

    public void printTable(Table table) {

        TableService tableService = new TableServiceImpl();
        System.out.println(tableService.printTable(table));
    }

    public void searchTable(Table table) {

        System.out.println(AppConstants.GET_FINDSTR);
   		String findStr = ScannerUtil.getInput();

        if(Validator.validateInput(findStr)) {
            TableService tableService = new TableServiceImpl();
            tableService.searchTable(table, findStr);
        }

    }

    public Table editTable(Table table) {

        System.out.println(AppConstants.GET_XINDEX);
        int xIndex = ScannerUtil.getInt();

        System.out.println(AppConstants.GET_YINDEX);
        int yIndex = ScannerUtil.getInt();

        if(Validator.validateIndex(table, xIndex, yIndex)) {

            System.out.println(AppConstants.GET_EDITTYPE);
            String replaceOption = ScannerUtil.getInput();
            if(Validator.validateEditType(replaceOption)) {

                System.out.println(AppConstants.GET_REPLACESTR);
                String replaceString = ScannerUtil.getInput();

                if(Validator.validateInput(replaceString)) {
                    TableService tableService = new TableServiceImpl();
                    return tableService.editTable(table, xIndex, yIndex, replaceString, EditTypeEnum.getByCode(replaceOption));
                }

            }
        }
        else {
            System.out.println(AppConstants.INDEX_ERROR);
        }
        return table;
    }

    public void sortTable(Table table) {

        System.out.println(AppConstants.GET_SORTTYPE);
        String sortType = ScannerUtil.getInput();
        if(Validator.validateSortType(sortType)) {

            TableService tableService = new TableServiceImpl();
            tableService.sortTable(table, SortTypeEnum.getByCode(sortType));

        }
    }

    public void saveTable(Table table) {

        String pathFile = "";
        if(table.getCurrentFilePath() != null && table.getCurrentFilePath() != "") {
            pathFile = table.getCurrentFilePath();
        }
        else {
            System.out.println(AppConstants.GET_FILEPATH);
            pathFile = ScannerUtil.getInput();
        }
        if(Validator.validateSavePath(pathFile)) {
            TableService tableService = new TableServiceImpl();
            try {
                tableService.saveToFile(table, pathFile);
            }
            catch (IOException e) {
                System.out.println (e);           
            }
        }

    }

}