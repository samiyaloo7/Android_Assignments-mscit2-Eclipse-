package samiyal.a2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Pro2 extends Activity {
	EditText et;
	Button btn;
	TextView tv;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pro2);
		btn = (Button) findViewById(R.id.tvbtn);
		et = (EditText) findViewById(R.id.ttotv);
		tv = (TextView) findViewById(R.id.tv);
		
		btn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				tv.setText(et.getText().toString());
				et.setText("");
			}
		});
	}
}
