package com.doesnothaveadomain.sync_adapter_deraloy.data;

import android.content.ContentResolver;
import android.net.Uri;
import android.provider.BaseColumns;

public class YoutubeVideoContract
{
	/*
	* ---YOUTUBE API---
	* GET search result: https://www.googleapis.com/youtube/v3/search?maxResults=25&key=AIzaSyB4sCP3VPyfYDrfoohCpWn12Vlo6B0qIrQ&part=snippet&q=arabic-learning
	* GET video details by ids (at most 50): https://www.googleapis.com/youtube/v3/videos?id=npc2XAwyXRk&part=contentDetails&key=AIzaSyB4sCP3VPyfYDrfoohCpWn12Vlo6B0qIrQ
	 * */
	
	/**
	 * The "Content authority" is a name for the entire content provider, similar to the
	 * relationship between a domain name and its website.  A convenient string to use for the
	 * content authority is the package name for the app, which is guaranteed to be unique on the
	 * device.
	 */
	public static final String CONTENT_AUTHORITY = "com.doesnothaveadomain.sync_adapter_deraloy";
	
	/**
	 * Use CONTENT_AUTHORITY to create the base of all URI's which apps will use to contact
	 * the content provider.
	 */
	public static final Uri BASE_CONTENT_URI = Uri.parse("content://" + CONTENT_AUTHORITY);
	
	
	public static final String PATH_YOUTUBE_VIDEOS = "youtube-videos-path";
	
	public static class VideoEntry implements BaseColumns {
		
		/** The content URI to access the movie data in the provider */
		public static final Uri CONTENT_URI = Uri.withAppendedPath(BASE_CONTENT_URI, PATH_YOUTUBE_VIDEOS);
		
		/**
		 * The MIME type of the {@link #CONTENT_URI} for a list of movies.
		 */
		public static final String CONTENT_LIST_TYPE =
				ContentResolver.CURSOR_DIR_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_YOUTUBE_VIDEOS;
		
		/**
		 * The MIME type of the {@link #CONTENT_URI} for a single movie.
		 */
		public static final String CONTENT_ITEM_TYPE =
				ContentResolver.CURSOR_ITEM_BASE_TYPE + "/" + CONTENT_AUTHORITY + "/" + PATH_YOUTUBE_VIDEOS;
		
		/** Name of database table for movies */
		public final static String TABLE_NAME = "youtube-video";
		
		/**
		 * Unique ID number for the movie (only for use in the database table).
		 *
		 * Type: INTEGER
		 */
		public final static String _ID = BaseColumns._ID;
		
		public static final String COLUMN_VIDEO_ID = "videoId";
		public static final String COLUMN_TITLE = "title";
		public static final String COLUMN_DESCRIPTION = "description";
		public static final String COLUMN_THUMBNAIL_URL = "thumbnailUrl";
		public static final String COLUMN_PUBLISHED_AT = "publishedAt";
		public static final String COLUMN_CHANNEL_NAME = "channelName";
		
	}
}
