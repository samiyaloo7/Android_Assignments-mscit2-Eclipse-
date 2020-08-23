package ml.samiyal.exam2;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class One extends Activity {
	
	/* Variable declaration. */
	EditText etin, etold, etnew, etdel;
	Button ins, up, del, disp;
	SQLiteDatabase db;
	Cursor c, c_all;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.one);
		
		/* Variable initialization/creating objects/referencing. */
		etin = (EditText) findViewById(R.id.et_in);
		etdel = (EditText) findViewById(R.id.et_del);
		etnew = (EditText) findViewById(R.id.et_new_up);
		etold = (EditText) findViewById(R.id.et_old_up);
		
		ins = (Button) findViewById(R.id.btn_in);
		up = (Button) findViewById(R.id.btn_up);
		del = (Button) findViewById(R.id.btn_del);
		disp = (Button) findViewById(R.id.btn_disp);
		
		/* DB and Table creation with exception handling. */
		try {
			/* opening of creating db. */
        	db = openOrCreateDatabase("info", MODE_PRIVATE, null);
        	/* creating table if not exists. */
        	db.execSQL("create table if not exists names(ids INT(3),name VARCHAR(255));");
		}catch(SQLiteException e){
			Log.e("dblog", "error in database creation.");
		}
		
		/* Inserting data to table. */
		ins.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				/* Get the user input in name variable. */
				String name = etin.getText().toString().trim();
				/* checking user input is empty or not */
				if(name.equals("")){
					/* if user tries to insert empty data  */
					Log.e("dblog", "Enter a name to insert");
					Toast.makeText(getApplicationContext(), "Enter a name to insert", Toast.LENGTH_LONG).show();
				}else{
					try {
						/* getting id of user by its name for checking if user exists. */
			        	c = db.rawQuery("select ids from names where name='"+name+"';", null);
			        	
			        	/* selecting all the records of names table. */
			        	c_all = db.rawQuery("select * from names;", null);
			        	
			        	/*checking any id found or not.*/
			        	if(c.getCount() > 0){
			        		/* prompt user that user name already exists. */
			        		Toast.makeText(getApplicationContext(), "already exists", Toast.LENGTH_LONG).show();
			        	}else{
			        		/* if user name not exists then  */
			        		
			        		/* getting last recored's id. */
			        		int id;
			        		
			        		/* if there are no records then set id = 1*/
			        		if(c_all.getCount() == 0){
			        			id = 1;
			        		}else {
			        			/* if there are any records then move cursor to last record.*/
				        		c_all.moveToLast();
				        		
				        		Log.e("dbloc - last ", String.valueOf(c_all.getInt(0)));
				        		
				        		/* increment last record's id and set to id */
				        		id = c_all.getInt(0) + 1;
			        		}
			        		/* after getting the new id insert the new id and name to database. */
			        		db.execSQL("insert into names values("+id+",'"+name+"');");
			        		
			        		Log.e("dblog", name+"rec inserted.");
			        	}
					}catch(SQLiteException e){
						Log.e("dblog", "not inserted.");
					}
				}
				
				/* clean up all fields. */
				cleanUp();
			}
		});
		
		del.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				/* Get the user input in name variable. */
				String name = etdel.getText().toString().trim();
				/* checking user input is empty or not */
				if(name.equals("")){
					/* if user tries to insert empty data  */
					Log.e("dblog", "Enter a name to delete");
					Toast.makeText(getApplicationContext(), "Enter a name to delete", Toast.LENGTH_LONG).show();
				}else{
					try {
						/* getting id of user by its name for checking if user exists. */
			        	c = db.rawQuery("select ids from names where name='"+name+"';", null);
			        	/*checking any id found or not.*/
			        	if(c.getCount() > 0){
			        		/* move cursor to first record.*/
			        		c.moveToFirst();
			        		/* deleting record by id. */
			        		db.execSQL("delete from names where ids="+c.getInt(0)+";");
			        		Log.e("dblog", name+"rec deleted.");
			        	}else{
			        		/* prompt user that user name not found for deleting. */
			        		Toast.makeText(getApplicationContext(), "no match found", Toast.LENGTH_LONG).show();
			        	}
					}catch(SQLiteException e){
						Log.e("dblog", "not deleted.");
					}
				}
				/* clean up all fields. */
				cleanUp();
			}
		});
		
		up.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				/* Get the user input in to variables. */
				String newn = etnew.getText().toString().trim();
				String oldn = etold.getText().toString().trim();
				/* checking user input is empty or not */
				if(newn.equals("") || oldn.equals("")){
					/* if user tries to insert empty data  */
					Log.e("dblog", "new name and old name must not be empty");
					Toast.makeText(getApplicationContext(), "new name and old name must not be empty", Toast.LENGTH_LONG).show();
				}else{
					try {
						/* getting id of user by its name for checking if user exists. */
			        	c = db.rawQuery("select ids from names where name='"+oldn+"';", null);
			        	/*checking any id found or not.*/
			        	if(c.getCount() > 0){
			        		/* move cursor to first record.*/
			        		c.moveToFirst();
			        		/* updating record by id. */
			        		db.execSQL("update names set name='"+newn+"' where ids="+c.getInt(0)+";");
			        		Log.e("dblog",  oldn+"rec updated to "+newn+".");
			        	}else{
			        		/* prompt user that user name not found for updating. */
			        		Toast.makeText(getApplicationContext(), "no match found", Toast.LENGTH_LONG).show();
			        	}
					}catch(SQLiteException e){
						Log.e("dblog", "not updated.");
					}
				}
				/* clean up all fields. */
				cleanUp();
			}
		});
		
		
		/* goto main activity on back button. */
		disp.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Toast.makeText(getApplicationContext(), "Displaying...", Toast.LENGTH_LONG).show();
				startActivity(new Intent(getApplicationContext(), Display.class));
			}
		});
		
	}

	/* function to clean up all fields. */
	void cleanUp() {
		etin.setText("");
		etdel.setText("");
		etnew.setText("");
		etold.setText("");
	}
	
}
