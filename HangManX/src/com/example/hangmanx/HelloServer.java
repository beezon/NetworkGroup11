package com.example.hangmanx;

import com.androidquery.AQuery;
import com.androidquery.callback.AjaxCallback;
import com.androidquery.callback.AjaxStatus;
import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class HelloServer extends Activity {
	public AQuery aq = new AQuery(this);
	private ThreadCheck threadCheck;
	int count = 0;
	private EditText textIP;
	public static String IPadress = "";
	private TextView check;
	private Button submitip;
	public static String Playstatus = "";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.hello_server);
		textIP = (EditText) findViewById(R.id.ip);
		check = (TextView) findViewById(R.id.status);
		submitip = (Button) findViewById(R.id.submitip);
		threadCheck = new ThreadCheck(this.count, this);
		Playstatus = "";
		submitip.setOnClickListener(new OnClickListener() {

// ========================Connect Multiplier=================================//

			@Override
			public void onClick(View arg0) {
				Playstatus = "play";
				threadCheck.start(); 					// เริ่มการทำงานของ Thread
				IPadress = "http://" + textIP.getText().toString()
						+ ":8080/?cmd=";

			}
		});
	}

	public void threadProcess(int count) {

		aq.ajax(IPadress + "Playstatus", String.class,
				new AjaxCallback<String>() { 			// ใช้เปิด web ดึง html มา

					@Override
					public void callback(String url, String html,
							AjaxStatus status) {
						if (html.trim().equals("play")) {
							check.setText("Start");
							threadCheck.requestStop();
							Intent i = new Intent(getApplicationContext(),
									multix.class);
							startActivity(i);
						} else {
							check.setText("Wait");
						}
					}
				});

	}
}
