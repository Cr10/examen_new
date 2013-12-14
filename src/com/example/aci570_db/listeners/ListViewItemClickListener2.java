package com.example.aci570_db.listeners;

import com.example.aci570_db.Lista2;
import com.example.aci570_db.ListaItem;
import com.example.aci570_db.model.Items;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;

	
public class ListViewItemClickListener2 implements AdapterView.OnItemClickListener {

        private Activity activity;
        
        public ListViewItemClickListener2(Activity activity) {
                this.activity = activity;
        }
        
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Items it = (Items) parent.getItemAtPosition(position);
                
                if(it != null)
                {
                        Intent i = new Intent(this.activity, ListaItem.class);
                        i.putExtra("e_items", it);
                        this.activity.startActivityForResult(i, Lista2.REQUEST_CODE_UPDATE_ITEMS);                        
                }
        }
}


