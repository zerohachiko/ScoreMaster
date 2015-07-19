package com.zcz.scoremaster;

import android.app.ListActivity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.SimpleCursorAdapter;

public class Aty_ListView extends ListActivity {

	private MyDB scoreDb;
	private SQLiteDatabase dbRead;
	private SimpleCursorAdapter adapter;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		
		scoreDb = new MyDB(this);
        dbRead = scoreDb.getReadableDatabase();
        
        
        adapter = new SimpleCursorAdapter(this, R.layout.list_cell, null, new String[]{"number","score"}, new int[]{R.id.list_numer,R.id.list_score});
        setListAdapter(adapter);
        
    	Cursor cursor = dbRead.query(MyDB.TABLE_NAME, null, null, null, null, null, null);
    	adapter.changeCursor(cursor);
	}
}
