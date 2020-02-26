package samiyal.a1_1;

import android.app.Activity;
import android.os.Bundle;
import android.widget.LinearLayout;

public class Pro4 extends Activity {
	LinearLayout l;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pro4);
		
		l = (LinearLayout) findViewById(R.id.ll);
		
		l.setBackgroundResource(R.drawable.square);
	}
}
