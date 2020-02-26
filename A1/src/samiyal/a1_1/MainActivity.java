package samiyal.a1_1;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MainActivity extends Activity {
	Button b1, b2, b3, b4, b5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b1 = (Button) findViewById(R.id.p1b);
        b2 = (Button) findViewById(R.id.p2b);
        b3 = (Button) findViewById(R.id.p3b);
        b4 = (Button) findViewById(R.id.p4b);
        b5 = (Button) findViewById(R.id.p5b);
        b1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				startActivity(new Intent(getApplicationContext(), samiyal.a1_1.Pro1.class));
			}
		});
        b2.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				startActivity(new Intent(getApplicationContext(), samiyal.a1_1.Pro2.class));
			}
		});
        b3.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				startActivity(new Intent(getApplicationContext(), samiyal.a1_1.Pro3.class));
			}
		});
        b4.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				startActivity(new Intent(getApplicationContext(), samiyal.a1_1.Pro4.class));
			}
		});
        b5.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				startActivity(new Intent(getApplicationContext(), samiyal.a1_1.Pro5.class));
			}
		});
    }
}
