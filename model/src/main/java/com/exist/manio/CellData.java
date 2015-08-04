package com.exist.manio.model;

public class CellData implements Comparable<CellData> {

    private String key;
    private String value;
    private int xIndex;
    private int yIndex;

    public CellData() {}

    public CellData(String key, String value, int xIndex, int yIndex) {
        this.key = key;
        this.value = value;
        this.xIndex = xIndex;
        this.yIndex = yIndex;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getKey() {
        return this.key;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public void setYIndex(int yIndex) {
        this.yIndex = yIndex;
    }

    public int getYIndex() {
        return this.yIndex;
    }

    public void setXIndex(int xIndex) {
        this.xIndex = xIndex;
    }

    public int getXIndex() {
        return this.xIndex;
    }

    public String toString() {
        return "Index [" + xIndex + "," + yIndex + "] containing [" + key + "," + value + "]";
    }

    public int compareTo(CellData cellData2) {

        int keyCompare = this.key.compareTo(cellData2.key);
        int valueCompare = (keyCompare == 0) ? this.value.compareTo(cellData2.value) : keyCompare;

        return valueCompare;
        
    }

}