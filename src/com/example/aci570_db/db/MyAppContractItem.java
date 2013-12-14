package com.example.aci570_db.db;

import android.provider.BaseColumns;


public final class MyAppContractItem {

	public MyAppContractItem() {
		// this empty constructor prevent accidentally instantiating the contract class
	}
		
	public static abstract class Item implements BaseColumns {
		public static final String TABLE_NAME = "item";
		public static final String COLUMN_NAME_NAME_ITEM = "item_name";
		public static final String COLUMN_NAME_VALOR_ITEM = "item_valor";
		public static final String COLUMN_NAME_CANTIDAD_ITEM = "item_cantidad";	
		
		
	}
	
	
	
}
