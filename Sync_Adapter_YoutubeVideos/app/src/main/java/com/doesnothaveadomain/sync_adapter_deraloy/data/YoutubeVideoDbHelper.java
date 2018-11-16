package com.doesnothaveadomain.sync_adapter_deraloy.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class YoutubeVideoDbHelper extends SQLiteOpenHelper {
	private static final String TAG = YoutubeVideoDbHelper.class.getSimpleName();
	
	private static final String DATABASE_NAME = "youtube-videos.db";
	private static final int DATABASE_VERSION = 1;
	Context context;
	
	
	
	public YoutubeVideoDbHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		final String SQL_CREATE_MOVIE_TABLE = "CREATE TABLE " + YoutubeVideoContract.VideoEntry.TABLE_NAME + " (" +
				YoutubeVideoContract.VideoEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
				YoutubeVideoContract.VideoEntry.COLUMN_VIDEO_ID + " TEXT NOT NULL, " +
				YoutubeVideoContract.VideoEntry.COLUMN_TITLE + " TEXT NOT NULL, " +
				YoutubeVideoContract.VideoEntry.COLUMN_DESCRIPTION + " TEXT NULL, " +
				YoutubeVideoContract.VideoEntry.COLUMN_THUMBNAIL_URL + " TEXT NOT NULL, " +
				YoutubeVideoContract.VideoEntry.COLUMN_PUBLISHED_AT + " DATETIME NOT NULL, " +
				YoutubeVideoContract.VideoEntry.COLUMN_CHANNEL_NAME + " TEXT NOT NULL " +
				" );";
		
		
		db.execSQL(SQL_CREATE_MOVIE_TABLE);
		Log.d(TAG, "Database Created Successfully" );
		
	}
	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXISTS " + YoutubeVideoContract.VideoEntry.TABLE_NAME);
		onCreate(db);
	}
	
}