package com.video.compressor;
import android.app.Activity;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.widget.ImageView;

import com.netcompss.ffmpeg4android_client.BaseWizard;


public class DemoClient extends BaseWizard {
	//ImageView iv;
	private String mediaFilePath;  // = "/storage/emulated/0/Download/in.mp4" ;
	private String compressedPath ; // = "/storage/emulated/0/Download" ;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		//iv = (ImageView) findViewById(R.id.imageview);
		
		copyLicenseAndDemoFilesFromAssetsToSDIfNeeded();
		setContentView(R.layout.ffmpeg_demo_client);
		
		Bundle b = getIntent().getExtras();
		mediaFilePath = b.getString("mediaFilePath");
		compressedPath = b.getString("compressedPath");
		//Log.i("Check", "Check.........");
		
		registerReceiver(new CompressionReceiver(), new IntentFilter(
						"yw.wemet.ngageapp.USER_ACTION_COMPRESSION"));
		
		if(mediaFilePath != null && compressedPath != null) 
		{
			compressMedia();
		}
	}

	private void compressMedia() 
	{
		String[] commandComplex = {"ffmpeg","-y" ,"-i", mediaFilePath,"-strict","experimental","-s", "320x240","-r","30", "-vcodec", "mpeg4", "-b", "100k", "-ab","48000", "-ac", "2", "-ar", "22050", compressedPath};
		setCommandComplex(commandComplex);
		setOutputFilePath(compressedPath);
		setProgressDialogTitle("Exporting As MP4 Video");
		setProgressDialogMessage("Depends on your media size, it can take a few minutes");
		setNotificationIcon(R.drawable.icon2);
		setNotificationMessage("Demo is running...");
		setNotificationTitle("Demo Client");
		setNotificationfinishedMessageTitle("Demo Transcoding finished");
		setNotificationfinishedMessageDesc("Click to play demo");
		setNotificationStoppedMessage("Demo Transcoding stopped");

		runTranscoing();		
	}


	public class CompressionReceiver extends BroadcastReceiver 
	{
		@Override
		public void onReceive(Context context, Intent intent) {

			if (intent.hasExtra("compression")) {
				// Failed to compress
				sendResultBackToActivity(false);
			} else {
				// Success to compress
				sendResultBackToActivity(true);
			}
			unregisterReceiver(this);
		}
	}

	public void sendResultBackToActivity(boolean b) {

		Intent resultIntent = new Intent();
		
		if(b) {
			setResult(Activity.RESULT_OK, resultIntent);
		} else {
			setResult(Activity.RESULT_CANCELED, resultIntent);
		}
		finish();
	}
}
