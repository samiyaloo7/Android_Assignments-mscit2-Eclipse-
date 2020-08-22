package samiyal.a3;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.LinearLayout;
import android.widget.Spinner;

public class Pro5 extends Activity {
	LinearLayout ll;
	Spinner sp;
	String color[] = {"Red", "Green", "Blue", "Yellow"};
	ArrayAdapter<String> ad;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pro5);
		sp = (Spinner) findViewById(R.id.colorspn);
		ll = (LinearLayout) findViewById(R.id.cngbackll);
		ad = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, color);
		sp.setAdapter(ad);
		sp.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,int arg2, long arg3) {
				if(arg2 == 0){
					ll.setBackgroundColor(Color.rgb(255, 0, 0));
				}else if(arg2 == 1){
					ll.setBackgroundColor(Color.rgb(0, 255, 0));
				}else if(arg2 == 2){
					ll.setBackgroundColor(Color.rgb(0, 0, 255));
				}else if(arg2 == 3){
					ll.setBackgroundColor(Color.rgb(255, 255, 0));
				}
			}
			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				ll.setBackgroundColor(Color.GRAY);
			}
		});
	}
}
