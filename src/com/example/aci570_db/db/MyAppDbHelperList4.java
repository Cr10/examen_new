package com.example.aci570_db.db;

import com.example.aci570_db.db.MyAppContractList4.List4;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;



public class MyAppDbHelperList4 extends SQLiteOpenHelper {

	// If you change the database schema, you must increment the database version.
    public static final int DATABASE_VERSION = 7;
    public static final String DATABASE_NAME = "MyAppList4.db";
//  private static final String NULL_TYPE = " NULL";
	private static final String TEXT_TYPE = " TEXT";
//	private static final String INTEGER_TYPE = " INTEGER";
//	private static final String REAL_TYPE = " REAL";
//	private static final String BLOB_TYPE = " BLOB";
	
	/////////////////////////////////////////////////////////////
	 private static final String COMMA_SEPARATOR = ",";
	
	
	private static final String SQL_CREATE_ITEM_LIST4 =
		    "CREATE TABLE " + List4.TABLE_NAME_LIST4 + " (" +
		    List4._ID + " INTEGER PRIMARY KEY," +
		    List4.COLUMN_NAME_NAME_ITEM_LIST4 + TEXT_TYPE + COMMA_SEPARATOR +
		    List4.COLUMN_NAME_VALOR_ITEM_LIST4 + TEXT_TYPE + COMMA_SEPARATOR +
		    List4.COLUMN_NAME_CANTIDAD_ITEM_LIST4 + TEXT_TYPE +
		    " )";
	
	
		
	////////////////////////////////////////////////////////////////
	

	private static final String SQL_DROP_ITEM_LIST3 =
		    "DROP TABLE IF EXISTS " + List4.TABLE_NAME_LIST4;
	
	////////////////////////////////////////////////////////////////
	
	
    
    public MyAppDbHelperList4(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }
    
    
    //////////////////////////////////////////////////////////////////
    
    
    
    public void onCreate(SQLiteDatabase dblist4) {
    	dblist4.execSQL(SQL_CREATE_ITEM_LIST4);
    }
    
    
    
    ///////////////////////////////////////////////////////////////
    
   
    
    public void onUpgrade(SQLiteDatabase dblist4, int oldVersion, int newVersion) {
    	Log.w(
    			MyAppDbHelperList4.class.getName(),
    			"Upgrading database from version " + oldVersion + " to " + newVersion + ", which will destroy all old data"
    	);

    	dblist4.execSQL(SQL_DROP_ITEM_LIST3);
    	onCreate(dblist4);
    }
    
    /////////////////////////////////////////////////////////////////////////////////
    
    
    public void onDowngrade(SQLiteDatabase dblist4, int oldVersion, int newVersion) {
        onUpgrade(dblist4, oldVersion, newVersion);
    }
}
