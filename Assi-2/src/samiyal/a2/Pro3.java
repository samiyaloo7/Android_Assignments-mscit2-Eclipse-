package samiyal.a2;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Pro3 extends Activity implements OnClickListener {
	EditText mail, pass;
	TextView tv;
	Button lbtn, cbtn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pro3);
		
		mail =(EditText) findViewById(R.id.email1);
		pass =(EditText) findViewById(R.id.pass1);
		tv =(TextView) findViewById(R.id.p3tv);
		lbtn =(Button) findViewById(R.id.log1);
		cbtn =(Button) findViewById(R.id.cnl1);
		
		lbtn.setOnClickListener(this);
		cbtn.setOnClickListener(this);
	
	}
	@Override
	public void onClick(View v) {
		if(v.getId() == R.id.log1){
			String uid = mail.getText().toString().trim();
			String pss = pass.getText().toString().trim();
			if(uid.equals("samiyal@gmail.com") && pss.equals("samiyal")){
				tv.setText(uid);
			}else {
				Toast.makeText(getApplicationContext(), "Username or password is wrong", Toast.LENGTH_LONG).show();
			}
		}else if(v.getId() == R.id.cnl2) {
			mail.setText("");
			pass.setText("");
			Toast.makeText(getApplicationContext(), "Login Canceled", Toast.LENGTH_SHORT).show();
		}
	}
}
