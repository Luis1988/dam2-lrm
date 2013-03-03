package com.fusioncube.enraya;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class AdminSQLite extends SQLiteOpenHelper {

	public AdminSQLite(Context context, String name, CursorFactory factory,
			int version) {
		super(context, name, factory, version);
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("create table jugadores (nombre text primary key, pganadas int, pempatadas int, pperdidas int)");

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int vOld, int vNew) {
		db.execSQL("drop table if exists jugadores");
		db.execSQL("create table jugadores (nombre text primary key, pganadas int, pempatadas int, pperdidas int)");
	}

}
