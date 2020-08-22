package samiyal.a3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Pro3 extends Activity {
	ListView al;
	String alist[]; 
	ArrayAdapter<String> ad;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pro3);
		al = (ListView) findViewById(R.id.actlist);
		alist = getResources().getStringArray(R.array.actlistarray);
		ad = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, alist);
		al.setAdapter(ad);
		al.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int i, long arg3) {
				if(i == 0){
					startActivity(new Intent(getApplicationContext(), samiyal.a3.Acti1.class));
				}else if(i == 1){
					startActivity(new Intent(getApplicationContext(), samiyal.a3.Acti2.class));
				}else if(i == 2){
					startActivity(new Intent(getApplicationContext(), samiyal.a3.Acti3.class));
				}
			}
		});
	}
}
