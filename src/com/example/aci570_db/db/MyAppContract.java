package com.example.aci570_db.db;

import android.provider.BaseColumns;

public final class MyAppContract {

	public MyAppContract() {
		// this empty constructor prevent accidentally instantiating the contract class
	}
	
	public static abstract class People implements BaseColumns {
		public static final String TABLE_NAME = "people";
		public static final String COLUMN_NAME_FIRST_NAME = "first_name";
		
	}
	
	
	
	
}
