package samiyal.a3;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class Pro4 extends Activity {
	Spinner cs;
	ArrayAdapter<String> ad;
	String[] str;
	EditText et;
	TextView tv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pro4);
		et = (EditText) findViewById(R.id.etcur);
		tv = (TextView) findViewById(R.id.tvcur);
		cs = (Spinner) findViewById(R.id.curspn);
		str = getResources().getStringArray(R.array.curarray);
		ad = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_spinner_item, str);
		cs.setAdapter(ad);
		cs.setOnItemSelectedListener(new OnItemSelectedListener() {
			@Override
			public void onItemSelected(AdapterView<?> arg0, View arg1,int i, long arg3) {
				String t = et.getText().toString();
				if(!t.equals("")){
					double temp = Double.parseDouble(t);
					if(i == 0) {
						tv.setText(String.valueOf(temp/71.46));
					}else if(i == 1) {
						tv.setText(String.valueOf(temp/81.01));
					}else if(i == 2) {
						tv.setText(String.valueOf(temp/235.27));
					}
				}else {
					tv.setText("Enter Amount");
				}
			}
			@Override
			public void onNothingSelected(AdapterView<?> arg0) {
				tv.setText("0.0");
			}
		});
	}
}