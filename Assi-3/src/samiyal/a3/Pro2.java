package samiyal.a3;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Pro2 extends Activity {
	ListView fl;
	String fruits[] = {"Mango", "Apple", "Banana"}; 
	ArrayAdapter<String> ad;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pro2);
		fl = (ListView) findViewById(R.id.fruitlist);
		ad = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, fruits);
		fl.setAdapter(ad);
	}
}