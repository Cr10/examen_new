package com.example.aci570_db.db;

import java.util.ArrayList;
import java.util.List;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import com.example.aci570_db.db.MyAppContractItem.Item;
import com.example.aci570_db.model.Items;





public class MyAppDataSourceItem  {

	private MyAppDbHelperItem dbHelper2;
	private SQLiteDatabase db2;
	
	

	private String[] allColumns1 = {
		    Item._ID,
		    Item.COLUMN_NAME_NAME_ITEM,
		    Item.COLUMN_NAME_VALOR_ITEM,
		    Item.COLUMN_NAME_CANTIDAD_ITEM,
		    
		    };
	
	

	public MyAppDataSourceItem(Context context) {
		this.dbHelper2 = new MyAppDbHelperItem(context);
	}
	
	public void open() throws SQLException {
		this.db2 = dbHelper2.getWritableDatabase();
	}
	
	public void close() {
		dbHelper2.close();
	}

	/////////////////////////////////////////////////////////////////////////////////
	
	
	public Items createItems(String nameItem, String valor, String cantidad) {
		ContentValues values2 = new ContentValues();
		values2.put(Item.COLUMN_NAME_NAME_ITEM, nameItem);
		values2.put(Item.COLUMN_NAME_VALOR_ITEM, valor);
		values2.put(Item.COLUMN_NAME_CANTIDAD_ITEM, cantidad);
		
	    long insertId2 = db2.insert(Item.TABLE_NAME, null, values2);
	    
	    Cursor c = db2.query(
	    		Item.TABLE_NAME,
	    		this.allColumns1, Item._ID + " = " + insertId2, 
	    		null,
	    		null, 
	    		null, 
	    		null
	    	);
	    c.moveToFirst();
	    
	    Items it = cursorToItems(c);
	    c.close();
	    
	    return it;
	}
	
	///////////////////////////////////////////////////////////////////////////
	
	
	
	public Items updateItems(Items it, String nameItem, String valor, String cantidad) {
		ContentValues values2 = new ContentValues();
		values2.put(Item.COLUMN_NAME_NAME_ITEM, nameItem);
		values2.put(Item.COLUMN_NAME_VALOR_ITEM, valor);
		values2.put(Item.COLUMN_NAME_CANTIDAD_ITEM, cantidad);
		
		
	    db2.update(Item.TABLE_NAME, values2, Item._ID + " = " + it.getId(), null);
	    
	    it.setNameItem(nameItem);
	    
	    
	    return it;
	}
	
	/////////////////////////////////////////////////////////////////////
		
	

	 
	
	
	public List<Items> getItem() {
	    List<Items> item = new ArrayList<Items>();
	    
	    String sortOrder = Item.COLUMN_NAME_NAME_ITEM + " DESC";
	    
	    Cursor c = db2.query(
			    Item.TABLE_NAME,	// The table to query
			    this.allColumns1,			// The columns to return
			    null,				// The columns for the WHERE clause
			    null,				// The values for the WHERE clause
			    null,				// don't group the rows
			    null,				// don't filter by row groups
			    sortOrder			// The sort order
		    );

	    c.moveToFirst();
	    while (!c.isAfterLast()) {
	      Items it = cursorToItems(c);
	      item.add(it);
	      c.moveToNext();
	    }
	    
	    // make sure to close the cursor
	    c.close();
	    
	    return item;
	}
	
	
	
	
	
	//////////////////////////////////////////////////////////////////////////////
	

	public Items deleteItems(Items it) {
	    long id = it.getId();
	    db2.delete(Item.TABLE_NAME, Item._ID + " = " + id, null);
	    it.setId(0);
	    return it;
	}
	
	/////////////////////////////////////////////////////////////////////////////////
	
	

	
	private Items cursorToItems(Cursor cursor) {
		Items it = new Items();
	    it.setId(cursor.getLong(0));
	    it.setNameItem(cursor.getString(1));
	    it.setValorItem(cursor.getString(2));
	    it.setCantidad(cursor.getString(3));
	    
	
	    return it;
	}
}

