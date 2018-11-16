package com.doesnothaveadomain.sync_adapter_deraloy.sync;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

public class YoutubeVideoAuthService extends Service
{
	// instance field that stores the authenticator object
	private YoutubeVideoAuthenticator mAuthenticator;
	
	@Override
	public void onCreate()
	{
		mAuthenticator = new YoutubeVideoAuthenticator(this);
	}
	
	/*
	* when the system bind to this service to make the RPC call
	* return the authenticator's IBinder
	*/
	@Nullable
	@Override
	public IBinder onBind(Intent intent)
	{
		return mAuthenticator.getIBinder();
	}
}
