package com.exist.manio.app;

import com.exist.manio.model.Table;

public interface TableMenuControllerInterface {

    public Table readFile(Table table);

    public Table createRandomTable();

	public void printTable(Table table);

	public void searchTable(Table table);

	public Table editTable(Table table);

	public void sortTable(Table table);

	public void saveTable(Table table);

}