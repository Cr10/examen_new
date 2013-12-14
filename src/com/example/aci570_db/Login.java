package com.example.aci570_db;



import com.example.aci570_db.helpers.PreferencesHelper;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Login extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.login, menu);
		return true;
	}
public void LoginButton(View view) {
		
		SharedPreferences sharedPref = getSharedPreferences("app-data",Context.MODE_PRIVATE);
		
        Boolean isRegistered = sharedPref.getBoolean(PreferencesHelper.IS_REGISTERES_KEY, false);
        Boolean isLoggedIn = sharedPref.getBoolean(PreferencesHelper.IS_LOGGED_IN_KEY, false);
        
        String email = sharedPref.getString(PreferencesHelper.EMAIL_KEY, "");
        String password = sharedPref.getString(PreferencesHelper.PASSWORD_KEY, "");
        
		EditText emailField = (EditText) this.findViewById(R.id.correoLogin);
		String enteredEmail = emailField.getText().toString();
		
		EditText passField = (EditText) this.findViewById(R.id.passLogin);
		String enteredPassword = passField.getText().toString();
		
		if(isRegistered && !isLoggedIn && email.equals(enteredEmail) && password.equals(enteredPassword))
		{
			SharedPreferences.Editor editor = sharedPref.edit();
			editor.putBoolean(PreferencesHelper.IS_LOGGED_IN_KEY, true);
			editor.commit();
			
			Intent app = new Intent(this, Lista1.class);
			this.startActivity(app);
		}
		else
		{
			Toast.makeText(this, "Invalid email or password", Toast.LENGTH_LONG).show();
		}
	}


}
