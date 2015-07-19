package com.zcz.scoremaster;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.zxing.activity.CaptureActivity;

public class Aty_GetRecord extends Activity implements OnClickListener {
	private Button btnScan, btnCf, btnNext;
	private TextView tvNumber;
	private RadioButton radioA, radioB, radioC;
	private MyDB scoreDb;
	private SQLiteDatabase dbWriter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.aty_getrecord);
		btnScan = (Button) findViewById(R.id.btnScan);
		btnCf = (Button) findViewById(R.id.btnCf);
		btnNext = (Button) findViewById(R.id.btnNext);
		tvNumber = (TextView) findViewById(R.id.tvNumber);
		
		radioA = (RadioButton) findViewById(R.id.radioA);
		radioB = (RadioButton) findViewById(R.id.radioB);
		radioC = (RadioButton) findViewById(R.id.radioC);

		btnScan.setOnClickListener(this);
		btnCf.setOnClickListener(this);
		btnNext.setOnClickListener(this);
		
		scoreDb = new MyDB(this);
		dbWriter = scoreDb.getWritableDatabase();
		
	}
	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.btnScan:
			Toast.makeText(Aty_GetRecord.this, "请扫描二维码", Toast.LENGTH_SHORT).show();
			Intent startScan = new Intent(Aty_GetRecord.this, CaptureActivity.class);
			//startActivity(startScan);
			startActivityForResult(startScan, 0);
			break;

		case R.id.btnCf:
			addDB();
			Toast.makeText(this, "insert succeed!", Toast.LENGTH_SHORT).show();

			break;
		case R.id.btnNext:
			Toast.makeText(Aty_GetRecord.this, "请扫描二维码", Toast.LENGTH_SHORT).show();
			Intent startScanNext = new Intent(Aty_GetRecord.this, CaptureActivity.class);
			//startActivity(startScan);
			startActivityForResult(startScanNext, 0);

			break;

		default:
			break;
		}

	}
	
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
		// TODO Auto-generated method stub
		super.onActivityResult(requestCode, resultCode, data);
		if (resultCode == RESULT_OK) {
			String result = data.getExtras().getString("result");
			tvNumber.setText(result);
		}
	}
	
	public void addDB(){
		ContentValues cv = new ContentValues();
		cv.put(MyDB.NUMBER, tvNumber.getText().toString());
		if (radioA.isChecked()) {
			cv.put(MyDB.SCORE, radioA.getText().toString());
		}
		else if (radioB.isChecked()) {
			cv.put(MyDB.SCORE, radioB.getText().toString());
		}
		else {
			cv.put(MyDB.SCORE, radioC.getText().toString());
		}
		dbWriter.insert(MyDB.TABLE_NAME, null, cv);
	}
}
