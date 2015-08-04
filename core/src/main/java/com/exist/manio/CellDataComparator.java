package com.exist.manio.core;

import java.util.Comparator;

import com.exist.manio.model.CellData;

class CellDataComparator implements Comparator<CellData> {

    @Override
    public int compare(CellData cellData1, CellData cellData2) {
        if(cellData1.getXIndex() != cellData2.getXIndex()) {
        	return 0;
        }
        else {
        	String cellCompare1 = cellData1.getKey() + cellData1.getValue();
        	String cellCompare2 = cellData2.getKey() + cellData2.getValue();
            return cellCompare1.compareTo(cellCompare2);
        }
    }
	
}