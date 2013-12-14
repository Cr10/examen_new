package com.example.aci570_db.db;

import java.util.ArrayList;
import java.util.List;

import com.example.aci570_db.db.MyAppContractList4.List4;
import com.example.aci570_db.model.Molist4;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;




public class MyAppDataSourceList4 {


	private MyAppDbHelperList4 dbHelperlist4;
	private SQLiteDatabase dblist4;
	
	

	private String[] allColumns1 = {
		    List4._ID,
		    List4.COLUMN_NAME_NAME_ITEM_LIST4,
		    List4.COLUMN_NAME_VALOR_ITEM_LIST4,
		    List4.COLUMN_NAME_CANTIDAD_ITEM_LIST4,
		    
		    };
	
	

	public MyAppDataSourceList4(Context context) {
		this.dbHelperlist4 = new MyAppDbHelperList4(context);
	}
	
	public void open() throws SQLException {
		this.dblist4 = dbHelperlist4.getWritableDatabase();
	}
	
	public void close() {
		dbHelperlist4.close();
	}

	/////////////////////////////////////////////////////////////////////////////////
	
	
	public Molist4 createItems(String nameItem, String valor, String cantidad) {
		ContentValues values2 = new ContentValues();
		values2.put(List4.COLUMN_NAME_NAME_ITEM_LIST4, nameItem);
		values2.put(List4.COLUMN_NAME_VALOR_ITEM_LIST4, valor);
		values2.put(List4.COLUMN_NAME_CANTIDAD_ITEM_LIST4, cantidad);
		
	    long insertId2 = dblist4.insert(List4.TABLE_NAME_LIST4, null, values2);
	    
	    Cursor c = dblist4.query(
	    		List4.TABLE_NAME_LIST4,
	    		this.allColumns1, List4._ID + " = " + insertId2, 
	    		null,
	    		null, 
	    		null, 
	    		null
	    	);
	    c.moveToFirst();
	    
	    Molist4 ls4 = cursorToList4(c);
	    c.close();
	    
	    return ls4;
	}
	
	///////////////////////////////////////////////////////////////////////////
	
	
	
	public Molist4 updateItems(Molist4 ls4, String nameItem, String valor, String cantidad) {
		ContentValues values2 = new ContentValues();
		values2.put(List4.COLUMN_NAME_NAME_ITEM_LIST4, nameItem);
		values2.put(List4.COLUMN_NAME_VALOR_ITEM_LIST4, valor);
		values2.put(List4.COLUMN_NAME_CANTIDAD_ITEM_LIST4, cantidad);
		
		
	    dblist4.update(List4.TABLE_NAME_LIST4, values2, List4._ID + " = " + ls4.getId(), null);
	    
	    ls4.setNameList4(nameItem);
	    
	    
	    return ls4;
	}
	
	/////////////////////////////////////////////////////////////////////
		
	

	 
	
	
	public List<Molist4> getItem() {
	    List<Molist4> list4 = new ArrayList<Molist4>();
	    
	    String sortOrder = List4.COLUMN_NAME_NAME_ITEM_LIST4 + " DESC";
	    
	    Cursor c = dblist4.query(
	    		List4.TABLE_NAME_LIST4,	// The table to query
			    this.allColumns1,			// The columns to return
			    null,				// The columns for the WHERE clause
			    null,				// The values for the WHERE clause
			    null,				// don't group the rows
			    null,				// don't filter by row groups
			    sortOrder			// The sort order
		    );

	    c.moveToFirst();
	    while (!c.isAfterLast()) {
	    Molist4 ls4 = cursorToList4(c);
	      list4.add(ls4);
	      c.moveToNext();
	    }
	    
	    // make sure to close the cursor
	    c.close();
	    
	    return list4;
	}
	
	
	
	
	
	//////////////////////////////////////////////////////////////////////////////
	

	public Molist4 deleteList4(Molist4 ls4) {
	    long id = ls4.getId();
	    dblist4.delete(List4.TABLE_NAME_LIST4, List4._ID + " = " + id, null);
	    ls4.setId(0);
	    return ls4;
	}
	
	/////////////////////////////////////////////////////////////////////////////////
	
	

	
	private Molist4 cursorToList4(Cursor cursor) {
		Molist4 ls4 = new Molist4();
		ls4.setId(cursor.getLong(0));
		ls4.setNameList4(cursor.getString(1));
		ls4.setValorList4(cursor.getString(2));
		ls4.setCantidadList4(cursor.getString(3));
	    
	
	    return ls4;
	}
}



	
