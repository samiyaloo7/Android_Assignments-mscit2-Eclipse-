package samiyal.a2;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

public class Pro5 extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.wlc);
		Log.i("Info Name", "Samiyal");
		Log.v("Verbose Name", "Samiyal");
		Log.w("Warning Name", "Samiyal");
		Log.d("d Name", "Samiyal");
		Log.e("Error Name", "Samiyal");
	}
}
