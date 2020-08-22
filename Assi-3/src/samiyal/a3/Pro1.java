package samiyal.a3;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Pro1 extends Activity {
	EditText mail, pass;
	Button lbtn, cbtn;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pro1);
		mail =(EditText) findViewById(R.id.tmail);
		pass =(EditText) findViewById(R.id.tpass);
		lbtn =(Button) findViewById(R.id.lbtn);
		cbtn =(Button) findViewById(R.id.cbtn);
		
		lbtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				String uid = mail.getText().toString().trim();
				String pss = pass.getText().toString().trim();
				if(uid.equals("samiyal@gmail.com") && pss.equals("samiyal")){
					Intent i = new Intent(getApplicationContext(), samiyal.a3.Wlc.class);
					i.putExtra("uid", uid);
					startActivity(i);
				}else {
					Toast.makeText(getApplicationContext(), "Username or password is wrong", Toast.LENGTH_LONG).show();
				}
			}
		});
		cbtn.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				mail.setText("");
				pass.setText("");
				Toast.makeText(getApplicationContext(), "Login Canceled", Toast.LENGTH_SHORT).show();
			}
		});
	}
}
