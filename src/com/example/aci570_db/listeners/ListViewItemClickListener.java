package com.example.aci570_db.listeners;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;





import com.example.aci570_db.List3;
import com.example.aci570_db.List4;
import com.example.aci570_db.Lista1;
import com.example.aci570_db.Lista2;
import com.example.aci570_db.model.Person;

public class ListViewItemClickListener implements AdapterView.OnItemClickListener {

	private Activity activity;
	
	public ListViewItemClickListener(Activity activity) {
		this.activity = activity;
	}
	
	public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
		Person p = (Person) parent.getItemAtPosition(position);
		
		switch (position) {
		case 0:
			
			Intent i0 = new Intent(this.activity, Lista2.class);
			i0.putExtra("person", p);
			this.activity.startActivityForResult(i0, Lista1.REQUEST_CODE_UPDATE_PERSON);
			
		
			break;
		case 1:
			
			Intent i1 = new Intent(this.activity, List3.class);
			i1.putExtra("person", p);
			this.activity.startActivityForResult(i1, Lista1.REQUEST_CODE_UPDATE_PERSON);
			
			break;
		case 2:
			
			Intent i2 = new Intent(this.activity, List4.class);
			i2.putExtra("person", p);
			this.activity.startActivityForResult(i2, Lista1.REQUEST_CODE_UPDATE_PERSON);
			
			break;	
			
				
	
			

		default:
			
			
			Intent idf = new Intent(this.activity, Lista2.class);
			idf.putExtra("person", p);
			this.activity.startActivity(idf);
			
			break;
		}
		
		
		
		
		
			
			
	}
}
