package com.example.aci570_db.db;

import com.example.aci570_db.db.MyAppContractList3.List3;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;



public class MyAppDbHelperList3 extends SQLiteOpenHelper {

	// If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 7;
    public static final String DATABASE_NAME = "MyAppList3.db";
//  private static final String NULL_TYPE = " NULL";
	private static final String TEXT_TYPE = " TEXT";
//	private static final String INTEGER_TYPE = " INTEGER";
//	private static final String REAL_TYPE = " REAL";
//	private static final String BLOB_TYPE = " BLOB";
	
	/////////////////////////////////////////////////////////////
	 private static final String COMMA_SEPARATOR = ",";
	
	
	private static final String SQL_CREATE_ITEM_LIST3 =
		    "CREATE TABLE " + List3.TABLE_NAME_LIST3 + " (" +
		    List3._ID + " INTEGER PRIMARY KEY," +
		    List3.COLUMN_NAME_NAME_ITEM_LIST3 + TEXT_TYPE + COMMA_SEPARATOR +
		    List3.COLUMN_NAME_VALOR_ITEM_LIST3 + TEXT_TYPE + COMMA_SEPARATOR +
		    List3.COLUMN_NAME_CANTIDAD_ITEM_LIST3 + TEXT_TYPE +
		    " )";
	
	
		
	////////////////////////////////////////////////////////////////
	

	private static final String SQL_DROP_ITEM_LIST3 =
		    "DROP TABLE IF EXISTS " + List3.TABLE_NAME_LIST3;
	
	////////////////////////////////////////////////////////////////
	
	
    
    public MyAppDbHelperList3(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    
    
    //////////////////////////////////////////////////////////////////
    
    
    
    public void onCreate(SQLiteDatabase dblist3) {
    	dblist3.execSQL(SQL_CREATE_ITEM_LIST3);
    }
    
    
    
    ///////////////////////////////////////////////////////////////
    
   
    
    public void onUpgrade(SQLiteDatabase dblist3, int oldVersion, int newVersion) {
    	Log.w(
    			MyAppDbHelperList3.class.getName(),
    			"Upgrading database from version " + oldVersion + " to " + newVersion + ", which will destroy all old data"
    	);

    	dblist3.execSQL(SQL_DROP_ITEM_LIST3);
    	onCreate(dblist3);
    }
    
    /////////////////////////////////////////////////////////////////////////////////
    
    
    public void onDowngrade(SQLiteDatabase dblist3, int oldVersion, int newVersion) {
        onUpgrade(dblist3, oldVersion, newVersion);
    }
}
