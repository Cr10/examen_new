package com.example.aci570_db.db;

import android.provider.BaseColumns;

public class MyAppContractList3 {
	
	
	
	public MyAppContractList3() {
		// this empty constructor prevent accidentally instantiating the contract class
	}
	
	public static abstract class List3 implements BaseColumns {
		public static final String TABLE_NAME_LIST3 = "list3";
		public static final String COLUMN_NAME_NAME_ITEM_LIST3 = "item_name_list3";
		public static final String COLUMN_NAME_VALOR_ITEM_LIST3 = "item_valor_list3";
		public static final String COLUMN_NAME_CANTIDAD_ITEM_LIST3 = "item_cantidad_list3";
		
	}
	

}
