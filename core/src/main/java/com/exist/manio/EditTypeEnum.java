package com.exist.manio.core;

// public class EditTypeEnum {

    public enum EditTypeEnum { 

    	KEY("k"), 
    	VALUE("v"), 
    	BOTH("b") ;

		private String code;

		private EditTypeEnum(String code){
			this.code=code;
		}

		public String getCode() {
			return code;
		}

		public static EditTypeEnum getByCode(String code) {
		    for(EditTypeEnum e : values()) {
		        if(e.code.equals(code)) {
		        	return e;
		        }
		    }
		    return null;
		}

    }

// }