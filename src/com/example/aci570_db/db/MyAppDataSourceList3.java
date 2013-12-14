package com.example.aci570_db.db;

import java.util.ArrayList;
import java.util.List;

import com.example.aci570_db.db.MyAppContractList3.List3;
import com.example.aci570_db.model.Molist3;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;




public class MyAppDataSourceList3 {


	private MyAppDbHelperList3 dbHelperlist3;
	private SQLiteDatabase dblist3;
	
	

	private String[] allColumns1 = {
		    List3._ID,
		    List3.COLUMN_NAME_NAME_ITEM_LIST3,
		    List3.COLUMN_NAME_VALOR_ITEM_LIST3,
		    List3.COLUMN_NAME_CANTIDAD_ITEM_LIST3,
		    
		    };
	
	

	public MyAppDataSourceList3(Context context) {
		this.dbHelperlist3 = new MyAppDbHelperList3(context);
	}
	
	public void open() throws SQLException {
		this.dblist3 = dbHelperlist3.getWritableDatabase();
	}
	
	public void close() {
		dbHelperlist3.close();
	}

	/////////////////////////////////////////////////////////////////////////////////
	
	
	public Molist3 createItems(String nameItem, String valor, String cantidad) {
		ContentValues values2 = new ContentValues();
		values2.put(List3.COLUMN_NAME_NAME_ITEM_LIST3, nameItem);
		values2.put(List3.COLUMN_NAME_VALOR_ITEM_LIST3, valor);
		values2.put(List3.COLUMN_NAME_CANTIDAD_ITEM_LIST3, cantidad);
		
	    long insertId2 = dblist3.insert(List3.TABLE_NAME_LIST3, null, values2);
	    
	    Cursor c = dblist3.query(
	    		List3.TABLE_NAME_LIST3,
	    		this.allColumns1, List3._ID + " = " + insertId2, 
	    		null,
	    		null, 
	    		null, 
	    		null
	    	);
	    c.moveToFirst();
	    
	    Molist3 ls = cursorToList3(c);
	    c.close();
	    
	    return ls;
	}
	
	///////////////////////////////////////////////////////////////////////////
	
	
	
	public Molist3 updateItems(Molist3 ls, String nameItem, String valor, String cantidad) {
		ContentValues values2 = new ContentValues();
		values2.put(List3.COLUMN_NAME_NAME_ITEM_LIST3, nameItem);
		values2.put(List3.COLUMN_NAME_VALOR_ITEM_LIST3, valor);
		values2.put(List3.COLUMN_NAME_CANTIDAD_ITEM_LIST3, cantidad);
		
		
	    dblist3.update(List3.TABLE_NAME_LIST3, values2, List3._ID + " = " + ls.getId(), null);
	    
	    ls.setNameList3(nameItem);
	    
	    
	    return ls;
	}
	
	/////////////////////////////////////////////////////////////////////
		
	

	 
	
	
	public List<Molist3> getItem() {
	    List<Molist3> list3 = new ArrayList<Molist3>();
	    
	    String sortOrder = List3.COLUMN_NAME_NAME_ITEM_LIST3 + " DESC";
	    
	    Cursor c = dblist3.query(
	    		List3.TABLE_NAME_LIST3,	// The table to query
			    this.allColumns1,			// The columns to return
			    null,				// The columns for the WHERE clause
			    null,				// The values for the WHERE clause
			    null,				// don't group the rows
			    null,				// don't filter by row groups
			    sortOrder			// The sort order
		    );

	    c.moveToFirst();
	    while (!c.isAfterLast()) {
	    Molist3 ls = cursorToList3(c);
	      list3.add(ls);
	      c.moveToNext();
	    }
	    
	    // make sure to close the cursor
	    c.close();
	    
	    return list3;
	}
	
	
	
	
	
	//////////////////////////////////////////////////////////////////////////////
	

	public Molist3 deleteList3(Molist3 ls) {
	    long id = ls.getId();
	    dblist3.delete(List3.TABLE_NAME_LIST3, List3._ID + " = " + id, null);
	    ls.setId(0);
	    return ls;
	}
	
	/////////////////////////////////////////////////////////////////////////////////
	
	

	
	private Molist3 cursorToList3(Cursor cursor) {
		Molist3 ls = new Molist3();
		ls.setId(cursor.getLong(0));
		ls.setNameList3(cursor.getString(1));
		ls.setValorList3(cursor.getString(2));
		ls.setCantidadList3(cursor.getString(3));
	    
	
	    return ls;
	}
}



	
