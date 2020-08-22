package samiyal.a2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Pro4 extends Activity {
	EditText mail, pass;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pro4);
		mail =(EditText) findViewById(R.id.email2);
		pass =(EditText) findViewById(R.id.pass2);
	
	}
	public void func(View v) {
		if(v.getId() == R.id.log2){
			String uid = mail.getText().toString().trim();
			String pss = pass.getText().toString().trim();
			if(uid.equals("samiyal@gmail.com") && pss.equals("samiyal")){
				startActivity(new Intent(getApplicationContext(), samiyal.a2.Welcome.class));
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
