package com.exist.manio.model;

import java.util.List;

public class Table {

    private String currentFilePath;

    private List<CellData> listCellData;

    private int xSize;
    private int ySize;

    public Table() {
        
    }

    public Table (List<CellData> listCellData, int xSize, int ySize) {
        if(listCellData != null) {
            this.listCellData = listCellData;
            this.xSize = xSize;
            this.ySize = ySize;
        }
    }

    public void setData(List<CellData> listCellData) {
		this.listCellData = listCellData;
	}

    public List<CellData> getData() {
    	return this.listCellData;
    }

    public void setCurrentFilePath(String filePath) {
        this.currentFilePath = filePath;
    }

    public String getCurrentFilePath() {
        return currentFilePath;
    }

    public void setXSize(int xSize) {
        this.xSize = xSize;
    }

    public int getXSize() {
        return this.xSize;
    }

    public void setYSize(int ySize) {
        this.ySize = ySize;
    }

    public int getYSize() {
        return this.ySize;
    }

}