package com.example.aci570_db.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import com.example.aci570_db.db.MyAppContractItem.Item;



public class MyAppDbHelperItem extends SQLiteOpenHelper {

	// If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 2;
    public static final String DATABASE_NAME = "MyApp2.db";
//  private static final String NULL_TYPE = " NULL";
	private static final String TEXT_TYPE = " TEXT";
//	private static final String INTEGER_TYPE = " INTEGER";
//	private static final String REAL_TYPE = " REAL";
//	private static final String BLOB_TYPE = " BLOB";
	
	/////////////////////////////////////////////////////////////
	 private static final String COMMA_SEPARATOR = ",";
	
	
	private static final String SQL_CREATE_ITEM =
		    "CREATE TABLE " + Item.TABLE_NAME + " (" +
		    Item._ID + " INTEGER PRIMARY KEY," +
		    Item.COLUMN_NAME_NAME_ITEM + TEXT_TYPE + COMMA_SEPARATOR +
		    Item.COLUMN_NAME_VALOR_ITEM + TEXT_TYPE + COMMA_SEPARATOR +
		    Item.COLUMN_NAME_CANTIDAD_ITEM + TEXT_TYPE +
		    " )";
	
	
		
	////////////////////////////////////////////////////////////////
	

	private static final String SQL_DROP_ITEM =
		    "DROP TABLE IF EXISTS " + Item.TABLE_NAME;
	
	////////////////////////////////////////////////////////////////
	
	
    
    public MyAppDbHelperItem(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    
    
    //////////////////////////////////////////////////////////////////
    
    
    
    public void onCreate(SQLiteDatabase db2) {
        db2.execSQL(SQL_CREATE_ITEM);
    }
    
    
    
    ///////////////////////////////////////////////////////////////
    
   
    
    public void onUpgrade(SQLiteDatabase db2, int oldVersion, int newVersion) {
    	Log.w(
    			MyAppDbHelperItem.class.getName(),
    			"Upgrading database from version " + oldVersion + " to " + newVersion + ", which will destroy all old data"
    	);

    	db2.execSQL(SQL_DROP_ITEM);
    	onCreate(db2);
    }
    
    /////////////////////////////////////////////////////////////////////////////////
    
    
    public void onDowngrade(SQLiteDatabase db2, int oldVersion, int newVersion) {
        onUpgrade(db2, oldVersion, newVersion);
    }
}
