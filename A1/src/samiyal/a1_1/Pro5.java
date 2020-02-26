package samiyal.a1_1;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Toast;

public class Pro5 extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.pro5);		
		Toast.makeText(this, "OnCreate", Toast.LENGTH_SHORT).show();
	}
	@Override
	protected void onStart() {
		super.onStart();
		Toast.makeText(getApplicationContext(), "OnStart", Toast.LENGTH_SHORT).show();
	}
	@Override
	protected void onStop() {
		super.onStop();
		Toast.makeText(getApplicationContext(), "OnStop", Toast.LENGTH_SHORT).show();
	}
	@Override
	protected void onDestroy() {
		super.onDestroy();
		Toast.makeText(getApplicationContext(), "OnDestroy", Toast.LENGTH_SHORT).show();
	}
}
