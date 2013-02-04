package com.example.hangmanx;

import java.util.Timer;
import java.util.TimerTask;

import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;

public class singlex extends Activity {

	Handler handler = new Handler();
	Timer timer = new Timer();
	TimerTask timetask;

	private final long startTime = 40000; // 1000 = 1 second
	private final long interval = 1000;
	private Button b0;
	private EditText editTxt;
	private View b1;
	private View b2;
	private View b3;
	private View b4;
	private View b5;
	private View b6;
	private View b7;
	private View b8;
	private View b9;
	private Button del;
	private Button sent;
	private TextView quest;
	int numA = (int) (Math.random() * 12) + 1;
	int numB = (int) (Math.random() * 12) + 1;
	private TextView scoll;
	private int scoll_num = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.single);

		scoll_num = 0;
		scoll = (TextView) findViewById(R.id.scoll);
		scoll.setText("คะแนน : " + String.valueOf(scoll_num));
		quest = (TextView) findViewById(R.id.quest);
		quest.setText(String.valueOf(numA) + " x " + String.valueOf(numB)
				+ " = ?");

		sent = (Button) findViewById(R.id.sent);
		sent.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				if (String.valueOf((numA * numB)).equals(
						editTxt.getText().toString())) {
					Toast.makeText(getApplication(), "ถูก !", Toast.LENGTH_LONG)
							.show();
					numA = (int) (Math.random() * 12) + 1;
					numB = (int) (Math.random() * 12) + 1;
					quest.setText(String.valueOf(numA) + " x "
							+ String.valueOf(numB) + " = ?");
					editTxt.setText("");
					scoll_num++;
					scoll.setText("คะแนน : " + String.valueOf(scoll_num));

				} else {
					Toast.makeText(getApplication(), "ผิด !", Toast.LENGTH_LONG)
							.show();
					editTxt.setText("");
				}

			}
		});

		del = (Button) findViewById(R.id.del);
		del.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				char[] str = editTxt.getText().toString().toCharArray();
				String msg = "";
				for (int i = 0; i < str.length - 1; i++) {
					msg += str[i];
				}
				editTxt.setText(msg);
			}
		});

		b0 = (Button) findViewById(R.id.button1); // Button sent number
		editTxt = (EditText) findViewById(R.id.editText1);
		b0.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				editTxt.setText(editTxt.getText().toString() + "0");
			}
		});

		b1 = (Button) findViewById(R.id.button2);
		editTxt = (EditText) findViewById(R.id.editText1);
		b1.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				editTxt.setText(editTxt.getText().toString() + "1");
			}
		});

		b2 = (Button) findViewById(R.id.button3);
		editTxt = (EditText) findViewById(R.id.editText1);
		b2.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				editTxt.setText(editTxt.getText().toString() + "2");
			}
		});

		b3 = (Button) findViewById(R.id.button4);
		editTxt = (EditText) findViewById(R.id.editText1);
		b3.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				editTxt.setText(editTxt.getText().toString() + "3");
			}
		});

		b4 = (Button) findViewById(R.id.button5);
		editTxt = (EditText) findViewById(R.id.editText1);
		b4.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				editTxt.setText(editTxt.getText().toString() + "4");
			}
		});

		b5 = (Button) findViewById(R.id.button6);
		editTxt = (EditText) findViewById(R.id.editText1);
		b5.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				editTxt.setText(editTxt.getText().toString() + "5");
			}
		});

		b6 = (Button) findViewById(R.id.button7);
		editTxt = (EditText) findViewById(R.id.editText1);
		b6.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				editTxt.setText(editTxt.getText().toString() + "6");
			}
		});

		b7 = (Button) findViewById(R.id.button8);
		editTxt = (EditText) findViewById(R.id.editText1);
		b7.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				editTxt.setText(editTxt.getText().toString() + "7");
			}
		});

		b8 = (Button) findViewById(R.id.button9);
		editTxt = (EditText) findViewById(R.id.editText1);
		b8.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				editTxt.setText(editTxt.getText().toString() + "8");
			}
		});

		b9 = (Button) findViewById(R.id.button10);
		editTxt = (EditText) findViewById(R.id.editText1);
		b9.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				editTxt.setText(editTxt.getText().toString() + "9");
			}
		});

		final MyCountDown countdown = new MyCountDown(startTime, interval);

		countdown.start();
	}

	public class MyCountDown extends CountDownTimer {
		public MyCountDown(long millisInFuture, long countDownInterval) {
			super(millisInFuture, countDownInterval);
			// TODO Auto-generated constructor stub
		}

		@Override
		public void onFinish() {
			// TODO Auto-generated method stub
			TextView result = (TextView) findViewById(R.id.txtResult);
			result.setText("Time Out!");
			AlertDialog.Builder alt_bld = new AlertDialog.Builder(singlex.this);
			alt_bld.setMessage(
					"คะแนนที่คุณได้ : " + String.valueOf(scoll_num)
							+ "\nคุณจะเริ่มเกมใหม่หรือไม่ ?")
					.setCancelable(false)
					.setPositiveButton("Yes",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int id) {
									Intent intent = getIntent();
									finish();
									startActivity(intent);
								}
							})
					.setNegativeButton("No",
							new DialogInterface.OnClickListener() {
								public void onClick(DialogInterface dialog,
										int id) {
									// Action for 'NO' Button
									Intent intent = new Intent(singlex.this,
											MainActivity.class);
									finish();
									startActivity(intent);
								}
							});
			AlertDialog alert = alt_bld.create();
			// Title for AlertDialog
			alert.setTitle("หมดเวลา !!!");
			// Icon for AlertDialog
			alert.setIcon(R.drawable.ic_launcher);
			alert.show();
		}

		@Override
		public void onTick(long remain) {
			// TODO Auto-generated method stub
			TextView result = (TextView) findViewById(R.id.txtResult);
			int timeRemain = (int) (remain) / 1000;
			result.setText(" เวลา : " + timeRemain); // เวลาในการถอยหลัง
		}
	}

}
