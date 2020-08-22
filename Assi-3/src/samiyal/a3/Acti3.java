package samiyal.a3;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class Acti3 extends Activity {
	TextView tv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.wlc);
		tv = (TextView) findViewById(R.id.wclt);
		tv.setText("Welcome to Activity-3");
	}
}
