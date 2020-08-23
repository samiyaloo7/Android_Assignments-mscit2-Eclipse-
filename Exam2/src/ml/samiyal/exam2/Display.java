package ml.samiyal.exam2;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class Display extends Activity {
	/* Variable declaration. */
	SQLiteDatabase db;
	Cursor c;
	
	ListView lv;
	ArrayAdapter<String> ad;
	ArrayList<String> a = new ArrayList<String>();
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.display);
		
		/* Variable initialization/creating objects/referencing. */
		lv = (ListView) findViewById(R.id.lv_names);
		/* creating array adapter with context, in-built in list item layout and array */
		ad = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, a);
		
		try{
			/* opening database. */
			db = openOrCreateDatabase("info", MODE_APPEND, null);
			/* selecting all data from table */
			c = db.rawQuery("select * from names;", null);
			/* checking if any record selected or not */
        	if(c.getCount() <= 0){
        		/* if no record found. */
        		Toast.makeText(getApplicationContext(), "no recoreds found", Toast.LENGTH_LONG).show();
        	}else{
        		/* clearing adapter data before adding all the items. */
        		ad.clear();
        		/* cursor to first positions. */
        		c.moveToFirst();
        		/* loop to the last record. */
        		while(!c.isAfterLast()){
        			/* get all records and store in to data. */
        			String data = String.valueOf(c.getInt(0))+" | "+c.getString(1);
        			Log.e("datalog - data : ", data);
        			/* adding data to array list. */
        			a.add(data);
        			/* moving cursor to next record. */
        			c.moveToNext();
        		}
        		/* setting adapter to list view. */
        		lv.setAdapter(ad);
        	}
		}catch(SQLiteException e){
			Log.e("datalog : ", "Error in connection..");
		}
		
		/* code for back button */
		((Button) findViewById(R.id.btn_back)).setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View arg0) {
				startActivity(new Intent(getApplicationContext(), One.class));
			}
		});
		
	}
}
