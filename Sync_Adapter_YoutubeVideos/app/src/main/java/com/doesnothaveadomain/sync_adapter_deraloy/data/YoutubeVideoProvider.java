package com.doesnothaveadomain.sync_adapter_deraloy.data;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

public class YoutubeVideoProvider extends ContentProvider
{
	
	// tag for the log messages
	public static final String LOG_TAG = YoutubeVideoProvider.class.getSimpleName();
	
	// URI matcher code for the content uri for the movies table
	public static final int VIDEOS = 25;
	
	// uri matcher code for the content uri for a single movie in the movies table
	private static final int VIDEO_ID = 101;
	
	
	private static final UriMatcher sUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
	
	static {
		sUriMatcher.addURI(YoutubeVideoContract.CONTENT_AUTHORITY, YoutubeVideoContract.PATH_YOUTUBE_VIDEOS, VIDEOS);
		
		sUriMatcher.addURI(YoutubeVideoContract.CONTENT_AUTHORITY, YoutubeVideoContract.PATH_YOUTUBE_VIDEOS, VIDEO_ID);
	}
	
	private YoutubeVideoDbHelper mDbHelper;
	
	@Override
	public boolean onCreate()
	{
		mDbHelper = new YoutubeVideoDbHelper(getContext());
		
		return true;
	}
	
	@Nullable
	@Override
	public Cursor query(@NonNull Uri uri, @Nullable String[] strings, @Nullable String s, @Nullable String[] strings1, @Nullable String s1)
	{
		return null;
	}
	
	@Nullable
	@Override
	public String getType(@NonNull Uri uri)
	{
		return null;
	}
	
	@Nullable
	@Override
	public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues)
	{
		final int match = sUriMatcher.match(uri);
		switch (match)
		{
			case VIDEOS:
				return insertVideos(uri, contentValues);
			default:
				throw new IllegalArgumentException("Insertion is not supported for " + uri);
		}
	}
	
	private Uri insertVideos(Uri uri, ContentValues values)
	{
		// get writable database
		SQLiteDatabase database = mDbHelper.getWritableDatabase();
		
		// insert the new video with the given value
		long id = database.insert(YoutubeVideoContract.VideoEntry.TABLE_NAME, null, values);
		
		if(id == -1)
		{
			Log.e(LOG_TAG, "Failed to insert row for" + uri);
			return null;
		}
		
		// notify all listners about that data change
		getContext().getContentResolver().notifyChange(uri, null);
		
		return ContentUris.withAppendedId(uri, id);
	}
	
	@Override
	public int delete(@NonNull Uri uri, @Nullable String s, @Nullable String[] strings)
	{
		return 0;
	}
	
	@Override
	public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String s, @Nullable String[] strings)
	{
		return 0;
	}
}
