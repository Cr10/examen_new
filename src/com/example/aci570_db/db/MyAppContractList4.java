package com.example.aci570_db.db;

import android.provider.BaseColumns;

public class MyAppContractList4 {
	
	
	
	public MyAppContractList4() {
		// this empty constructor prevent accidentally instantiating the contract class
	}
	
	public static abstract class List4 implements BaseColumns {
		public static final String TABLE_NAME_LIST4 = "list4";
		public static final String COLUMN_NAME_NAME_ITEM_LIST4 = "item_name_list4";
		public static final String COLUMN_NAME_VALOR_ITEM_LIST4 = "item_valor_list4";
		public static final String COLUMN_NAME_CANTIDAD_ITEM_LIST4 = "item_cantidad_list4";
		
	}
	

}
