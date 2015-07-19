package com.zcz.scoremaster;

import android.support.v7.app.ActionBarActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainActivity extends ActionBarActivity implements OnClickListener {

	private Button btnStart;
	private Button btnLook;
	private Button btnExit;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btnStart = (Button) findViewById(R.id.btnStart);
		btnLook = (Button) findViewById(R.id.btnLook);
		btnExit = (Button) findViewById(R.id.btnExit);

		btnStart.setOnClickListener(this);
		btnLook.setOnClickListener(this);
		btnExit.setOnClickListener(this);
	}


	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}


	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnStart:
			Intent i = new Intent(this, Aty_GetRecord.class);
			startActivity(i);
			break;

		case R.id.btnLook:
			Intent j = new Intent(this,Aty_ListView.class);
			startActivity(j);
			break;
			
		case R.id.btnExit:
			finish();
			break;

		default:
			break;
		}

	}
}
