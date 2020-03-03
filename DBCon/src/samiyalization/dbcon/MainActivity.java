package samiyalization.dbcon;

import java.util.ArrayList;

import android.app.Activity;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {
	SQLiteDatabase db;
	Cursor c;
	EditText et;
	Button btn;
	ListView lv;
	ArrayAdapter<String> ad;
	ArrayList<String> al;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        et = (EditText) findViewById(R.id.etname);
        btn = (Button) findViewById(R.id.badd);
        lv = (ListView) findViewById(R.id.lvusers);
        al = new ArrayList<String>();
        ad = new ArrayAdapter<String>(getApplicationContext(), R.layout.tforlv, al);
        
        try{
        	db = openOrCreateDatabase("test", MODE_PRIVATE, null);
        	db.execSQL("CREATE TABLE IF NOT EXISTS users(name VARCHAR)");
        	dispData();
        }catch(SQLException e) {}
        
        btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				String temp = et.getText().toString().trim();
				if(temp.equals("")){
					Toast.makeText(getApplicationContext(), "Enter name to Add", 500).show();
				}else{
					c = db.rawQuery("SELECT * FROM users WHERE name='"+temp+"' ", null);
					if (c.getCount() > 0){
						Toast.makeText(getApplicationContext(), "User already exists", 500).show();
					}else{
						db.execSQL("INSERT INTO users VALUES('"+temp+"')");
					}
				}
				et.setText("");
				dispData();
			}
		});
    }
    public void dispData() {
    	ad.clear();
    	try{
    		c = db.rawQuery("SELECT * FROM users", null);
        	int l = c.getCount(); // getting the no of recoreds selected(in this case 1)
        	if(l > 0){
        		c.moveToFirst(); // initialization
        		int i = 0;
        		while(i < l){  //condition
        			Log.e("sqlite data : ", c.getString(0));
        			al.add(c.getString(0).toString());
        			c.moveToNext(); // incre
        			i++;
        		}
        	}else {
        		Log.e("sqlite data : ", " No Recored Found");
        	}
    		
    	}catch(Exception e){}
    	lv.setAdapter(ad);
    }
}
