package com.example.hangmanx;

import java.io.IOException;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;

public class MainActivity extends Activity implements OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		View btnsingle = findViewById(R.id.imageButton1);
		btnsingle.setOnClickListener(this);

		View btnmulti = findViewById(R.id.imageButton2);
		btnmulti.setOnClickListener(this);

	}

	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.imageButton1:
			Intent i = new Intent(this, singlex.class);
			startActivity(i);
			break;

		case R.id.imageButton2:
			try {
				HTTPD_Server nanoHTTPD = new HTTPD_Server();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			Intent j = new Intent(this, HelloServer.class);
			startActivity(j);
			break;
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
