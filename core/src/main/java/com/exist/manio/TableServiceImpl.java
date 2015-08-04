package com.exist.manio.core;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.lang.StringBuilder;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.StringUtils;

import com.exist.manio.model.Table;
import com.exist.manio.model.CellData;


public class TableServiceImpl implements TableService {

	public Table readData(String filename) throws FileNotFoundException,IOException {
        List<CellData> listCellData = new ArrayList<CellData>();
        File file = new File(filename);
        String fileData = FileUtils.readFileToString(file);
        String[] lineStringArray = fileData.split(CoreConstants.LINE_DELIMITER);
        int xIndex = 0;
        int yIndex = 0;
        for(String lineString : lineStringArray) {
            yIndex = 0;
            String[] cellStringArray = lineString.split(CoreConstants.CELL_DELIMITER);
            for(String cellString : cellStringArray ) {
                String[] holder = cellString.split(CoreConstants.KEYVALUE_DELIMITER);
                if(holder.length < 2) {
                    continue;
                }
                listCellData.add(new CellData(holder[0], holder[1], xIndex, yIndex));
                yIndex++;
            }
            xIndex++;
        }

        Table table = new Table(listCellData, xIndex, yIndex);

        table.setCurrentFilePath(filename);

        System.out.println(printTable(table));

        return table;
	}

	public Table createRandomTable(int xSize, int ySize, int cellSize) {

		List<CellData> listCellData = new ArrayList<CellData>();

        String rndCellData1 = "", rndCellData2 = "";

        //create the random data
        for(int a = 0; a < xSize; a++) {
            for(int b = 0; b < ySize * 2; b++) {

                rndCellData1 = RandomStringUtils.random(cellSize, CoreConstants.RANDOM_CHAR);

                if(b % 2 == 0) {
                	rndCellData2 = rndCellData1;
                }
                else {
					CellData cellData = new CellData(rndCellData1, rndCellData2, a, b/2);
                	listCellData.add(cellData);
                }

            }//for ySize
        }//for xSize

        Table table = new Table(listCellData, xSize, ySize);

        System.out.println(printTable(table));

        return table;
	}

	public String printTable(Table table) {
        StringBuilder sb = new StringBuilder();
        int xIndex = 0;
        if(table.getData() == null) {
            return CoreConstants.TABLE_EMPTY;
        }
        for(CellData cellData : table.getData()) {
            String holder = cellData.getKey() + CoreConstants.KEYVALUE_DELIMITER + cellData.getValue();
            if(cellData.getXIndex() != xIndex) {
                sb.append(CoreConstants.LINE_DELIMITER);
                xIndex = cellData.getXIndex();
            }
            sb.append("[");
            sb.append(holder);
            sb.append("] ");

        }
        return sb.toString();
	}

	public void searchTable(Table table, String findString) {
        if(table.getData() == null) {
            System.out.println(CoreConstants.TABLE_EMPTY);
        }
        else {
            for(CellData cellData : table.getData()) {
                int keyResult = StringUtils.countMatches(cellData.getKey(), findString);
                int valueResult = StringUtils.countMatches(cellData.getValue(), findString);
                if(keyResult + valueResult > 0) {
                    System.out.println(cellData.toString() + " matched! " + "Results are " + keyResult + ", " + valueResult);
                }
            }
        }
	}

	public Table editTable(Table table, int xIndex, int yIndex, String replaceString, EditTypeEnum editType) {
        if(table.getData() == null) {
            System.out.println(CoreConstants.TABLE_EMPTY);
        }
        else {
            for(CellData cellData : table.getData()) {
                if(cellData.getXIndex() == xIndex && cellData.getYIndex() == yIndex ) {
                    switch (editType) {

                        case KEY    :   cellData.setKey(replaceString);
                                        break;

                        case VALUE  :   cellData.setValue(replaceString);
                                        break;

                        case BOTH   :   cellData.setValue(replaceString);
                                        cellData.setKey(replaceString);
                                        break;

                        default     :   System.out.println(CoreConstants.ENUM_ERROR);
                                        break;
                    }
                }
            }
            System.out.println(printTable(table));
        }
        return table;
	}

	public void sortTable(Table table, SortTypeEnum sortType) {
        if(table.getData() == null) {
            System.out.println(CoreConstants.TABLE_EMPTY);
        }
        else {

            switch (sortType) {

                case ASCENDING  :   Collections.sort(table.getData(), new CellDataComparator());
                                    break;

                case DESCENDING :   Collections.sort(table.getData(),Collections.reverseOrder(new CellDataComparator()));
                                    break;

                default         :   System.out.println(CoreConstants.ENUM_ERROR);
                                    break;

            }

            updateIndeces(table);

            System.out.println(printTable(table));

        }
        
	}

	public void saveToFile(Table table, String pathFile) throws IOException {

        File file = new File(pathFile);
        StringBuilder sb = new StringBuilder();
        int xIndex = 0;
        if(table.getData() == null) {
            System.out.println(CoreConstants.TABLE_EMPTY);
        }
        else {
            for(CellData cellData : table.getData()) {
                String holder = cellData.getKey() + CoreConstants.KEYVALUE_DELIMITER + cellData.getValue();
                if(cellData.getXIndex() != xIndex) {
                    sb.append(CoreConstants.LINE_DELIMITER);
                    xIndex = cellData.getXIndex();
                }
                sb.append(holder);
                sb.append(CoreConstants.CELL_DELIMITER);
            }
            FileUtils.writeStringToFile(file, sb.toString());
            table.setCurrentFilePath(pathFile);
            System.out.println(CoreConstants.SAVE_SUCCESS);
        }

	}

    private void updateIndeces(Table table) {
        int xSize = table.getXSize();
        int ySize = table.getYSize();
        int x = 0;
        int y = 0;
        if(table.getData() == null) {
            System.out.println(CoreConstants.TABLE_EMPTY);
        }
        else {
            for(CellData cellData : table.getData()) {
                if( y >= ySize) {
                    x++;
                    y = 0;
                }
                cellData.setXIndex(x);
                cellData.setYIndex(y++);
            }
        }
    }


    public Table readDataFromString(String fileData) throws FileNotFoundException,IOException {
        List<CellData> listCellData = new ArrayList<CellData>();
        String[] lineStringArray = fileData.split(CoreConstants.LINE_DELIMITER);
        int xIndex = 0;
        int yIndex = 0;
        for(String lineString : lineStringArray) {
            yIndex = 0;
            String[] cellStringArray = lineString.split(CoreConstants.CELL_DELIMITER);
            for(String cellString : cellStringArray ) {
                String[] holder = cellString.split(CoreConstants.KEYVALUE_DELIMITER);
                if(holder.length < 2) {
                    continue;
                }
                listCellData.add(new CellData(holder[0], holder[1], xIndex, yIndex));
                yIndex++;
            }
            xIndex++;
        }

        Table table = new Table(listCellData, xIndex, yIndex);

        System.out.println(printTable(table));

        return table;
    }

}