package com.example.aci570_db;

import java.util.List;

import com.example.aci570_db.db.MyAppDataSource;
import com.example.aci570_db.db.MyAppDataSourceList4;
import com.example.aci570_db.listeners.ListViewItemClickListener2;
import com.example.aci570_db.model.Molist4;
import com.example.aci570_db.model.Person;


import android.os.Bundle;
import android.app.ListActivity;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class List4 extends ListActivity {

	
	public static final int REQUEST_CODE_ADD_ITEMS = 1;
    public static final int REQUEST_CODE_UPDATE_ITEMS = 2;
    
    public static final String EXTRA_ITEMS = "e_items";
    public static final String EXTRA_REMOVE_ITEMS = "e_remove_items";

    private MyAppDataSourceList4 dslist4;
    
   
    private MyAppDataSource ds;
  
	private Person personToUpdate;
	
    
    
    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_list4);
                
            setupActionBar();          


            dslist4 = new MyAppDataSourceList4(this);
			dslist4.open();
		
		List<Molist4> values2 = dslist4.getItem();
		
		// use the SimpleCursorAdapter to show the elements in a ListView
		ArrayAdapter<Molist4> adapter2 = new ArrayAdapter<Molist4>(
		             this,
		             android.R.layout.simple_list_item_1,
		             values2
		     );
		
		this.setListAdapter(adapter2);
		

		
		
		ListView lv2 = (ListView) this.findViewById(android.R.id.list);
		lv2.setOnItemClickListener(new ListViewItemClickListener2(this));
		
		
		ds = new MyAppDataSource(this);
	    ds.open();
	    
	    
    
    Intent i = this.getIntent();

 if(i.hasExtra(Lista1.EXTRA_PERSON))
 	{
	 Person p = (Person) i.getSerializableExtra(Lista1.EXTRA_PERSON);
     
	 		EditText firstNameField = (EditText) this.findViewById(R.id.editText1);
 			firstNameField.setText(p.getFirstName());
 			
 			
 	
			
			Button deleteButton = (Button) this.findViewById(R.id.Delete);
			deleteButton.setVisibility(Button.VISIBLE);
            

			
		
		
		this.personToUpdate = p;
            
     }
     else
     {
 			             
    	 this.personToUpdate = null;
             
}
}

	private void setupActionBar() {

    getActionBar().setDisplayHomeAsUpEnabled(true);

    

	
	
	
	}
	
	
	
	
	
    
    
    
    @Override
    protected void onActivityResult(int requestCode2, int resultCode2, Intent data2) {
            super.onActivityResult(requestCode2, resultCode2, data2);
            
            if(data2.hasExtra(EXTRA_ITEMS))
            {
                    List<Molist4> values2 = dslist4.getItem();
            
             // use the SimpleCursorAdapter to show the elements in a ListView
             ArrayAdapter<Molist4> adapter2 = new ArrayAdapter<Molist4>(
                             this,
                             android.R.layout.simple_list_item_1,
                             values2
                     );
            
             ListView lv2 = (ListView) this.findViewById(android.R.id.list);
             lv2.setAdapter(adapter2);
            
                    if(requestCode2 == REQUEST_CODE_ADD_ITEMS) {
                            // do something here when a person is added
                    }
                    else if(requestCode2 == REQUEST_CODE_UPDATE_ITEMS)
                    {
                            Boolean remove2 = data2.getBooleanExtra(EXTRA_REMOVE_ITEMS, false);
                            
                            if(remove2) {
                                    // do something here when a person is removed
                            }
                            else {
                                    // do something here when a person is updated
                            }
                    }
                    adapter2.notifyDataSetChanged();
            }
    }
    
    
    
    
    
    
    
    
    
    

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
            // Inflate the menu; this adds items to the action bar if it is present.
            getMenuInflater().inflate(R.menu.list4, menu);
            return true;
    }
    
    public void onAddItemClick4(View view) {
            Intent i = new Intent(this, List4Item.class);
            this.startActivityForResult(i, REQUEST_CODE_ADD_ITEMS);
    }
	
	
	
	
    
	public void onBackClick(View view) {
		Intent i = new Intent(this, Lista1.class);
		this.startActivityForResult(i, REQUEST_CODE_UPDATE_ITEMS);
 
		
	}	
	

	
	public void onDeleteButtonClicked(View view) {
		
		Person p = ds.deletePerson(this.personToUpdate);
		
		Intent i = new Intent();
		i.putExtra(Lista1.EXTRA_PERSON, p);
		i.putExtra(Lista1.EXTRA_REMOVE, true);
		this.setResult(RESULT_OK, i);
		
		this.finish();
	}
	
	@Override
	protected void onResume() {
		ds.open();
		super.onResume();
	}

	@Override
	protected void onPause() {
		ds.close();
		super.onPause();
	}
}

	
