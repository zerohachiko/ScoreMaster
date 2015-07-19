package com.zcz.scoremaster;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MyDB extends SQLiteOpenHelper {
	public static final String TABLE_NAME = "CLesson";
	public static final String NUMBER = "number";
	public static final String SCORE = "score";
	public static final String ID = "_id";
	

	public MyDB(Context context) {
		super(context,"ScoreDB", null, 1);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE "+TABLE_NAME+"("
				+ID+" INTEGER PRIMARY KEY AUTOINCREMENT,"
				+NUMBER+" TEXT DEFAULT NONE,"
				+SCORE+" TEXT DEFAULT NONE)");

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub

	}

}
