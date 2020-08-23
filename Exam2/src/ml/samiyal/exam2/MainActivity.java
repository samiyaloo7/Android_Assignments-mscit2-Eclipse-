package ml.samiyal.exam2;

/**
 * Author : Samiyal ;).
 * Data : 23-08-20.  
 * Description : Program to describe all the database operations.
 */

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;

public class MainActivity extends Activity {
	SQLiteDatabase db;
	Cursor c;
	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        /* starting DB operations activity. */
        
        startActivity(new Intent(getApplicationContext(), One.class));
        
        /* All the code required for database operations. */
        
//        try {
//        	db = openOrCreateDatabase("dbone", MODE_PRIVATE, null);
//        	db.execSQL("create table if not exists tblthree(name VARCHAR(255), age INT(3)); ");
//        	db.execSQL("insert into tblthree values('sagar', 1)");
//        	db.execSQL("insert into tblthree values('samiyal', 2)");
//        	db.execSQL("insert into tblthree values('sam', 3)");
//        	db.execSQL("insert into tblthree values('seven', 7)");
//        	db.execSQL("update tblthree set name='samiyal' where age=7");
//        	db.execSQL("delete from tblthree where age=1");
//        	c = db.rawQuery("select * from tblthree",null);
//        	
//        	String nm = "temp";
//        	int in = 77;
//        	
//        	if(c.getCount() > 0){
//        		c.moveToFirst();
//        		boolean is_recored = false;
//        		Log.e("dblog", "------------ start records ----------");
//        		while(!c.isAfterLast()) {
//        			if(c.getString(0).equals(nm)){
//        				is_recored = true;
//        			}
//        			Log.e("dblog - name : ", c.getString(0));
//        			Log.e("dblog - age : ", c.getString(1));
//        			c.moveToNext();
//        		}
//        		if(is_recored = true) {
//        			Log.e("dblog ", "name "+nm+" already exists.");
//        		}else{
//    				db.execSQL("insert into tblthree values('"+nm+"', "+in+")");
//    			}
//        		Log.e("dblog", "------------ start records ----------");
//        	}else {
//        		Log.e("dblog", "no recored found.");
//        	}
//        }catch(SQLiteException e){
//        	Log.e("dblog", "error in database creation.");
//        }
        
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
}
