package com.exist.manio.app;

import java.io.File;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.EnumUtils;

import com.exist.manio.model.Table;
import com.exist.manio.core.EditTypeEnum;
import com.exist.manio.core.SortTypeEnum;

public class Validator {

    //check if the data is a decimal
    public static boolean isNumeric(String str) {
        if ("".equals(str)) {
            return false;
        }
        else {
          return str.matches("-?\\d+(\\.\\d+)?");  //match a number with optional '-' and decimal. Must start with 0 if only decimal eg 0.1
        }
    }

    //check if the data is int
    public static boolean isInt(String str) {
        if ("".equals(str)) {
            return false;
        }
        else {
          return str.matches("\\d*");  //match an int
        }
    }

    //checking if the user exited the menu
    public static boolean isDone(String chosen) {
        return "0".equals(chosen);
    }

    public static boolean validateFile(String filename) {
        File file = new File(filename);
        if(filename == null || !file.exists() || file.isDirectory()) {
            System.out.println(AppConstants.FILE_ERROR);
            return false;
        }
        return true;
    }

    public static boolean validateMinInt(int input, int min) {
        if(input < min) {
            System.out.println(AppConstants.INT_ERROR);
            return false;
        }
        return true;
    }

    public static boolean validateIndex(Table table, int xIndex, int yIndex) {
        return xIndex < table.getXSize() ? yIndex < table.getYSize() : false ;
    }

    public static boolean validateInput(String input) {
        if (input == null || "".equals(input) || StringUtils.contains(input, " ") ) {
            System.out.println(AppConstants.INPUT_ERROR);
            return false;
        }
        return true;
    }

    public static boolean validateEditType(String input) {
         if(EditTypeEnum.getByCode(input) == null ) {
            System.out.println(AppConstants.ENUM_ERROR);
            return false;
        }
        return true;
    }

    public static boolean validateSortType(String input) {
         if(SortTypeEnum.getByCode(input) == null ) {
            System.out.println(AppConstants.ENUM_ERROR);
            return false;
        }
        return true;
    }

    public static boolean validateSavePath(String pathFile) {
        File file = new File(pathFile);
        if(pathFile == null || file.isDirectory()) {
            System.out.println(AppConstants.SAVEFILE_ERROR);
            return false;
        }
        return true;        
    }

}
