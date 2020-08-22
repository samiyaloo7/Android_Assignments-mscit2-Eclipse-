package samiyal.a3;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Wlc extends Activity {
	TextView tv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.wlc);
		String name = this.getIntent().getExtras().getString("uid");
		
		tv = (TextView) findViewById(R.id.wclt);
		if(name != null) {
			String temp = "Hello "+name.toString();
			tv.setText(temp);
		}
	}
}
