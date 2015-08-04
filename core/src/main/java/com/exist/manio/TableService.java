package com.exist.manio.core;

import java.io.FileNotFoundException;
import java.io.IOException;

import com.exist.manio.model.Table;
import com.exist.manio.core.EditTypeEnum;
import com.exist.manio.core.SortTypeEnum;

public interface TableService {

	public Table readData(String filename) throws FileNotFoundException,IOException;

	public Table createRandomTable(int xSize, int ySize, int cellSize);

	public String printTable(Table table);

	public void searchTable(Table table, String findString);

	public Table editTable(Table table, int xIndex, int yIndex, String replaceString, EditTypeEnum editType);

	public void sortTable(Table table, SortTypeEnum sortType);

	public void saveToFile(Table table, String pathFile) throws IOException;

}