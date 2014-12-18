package com.video.compressor;

//import android.content.BroadcastReceiver;
//import android.content.Context;
//import android.content.Intent;
//import android.content.IntentFilter;
import android.util.Log;
//import android.view.Gravity;

import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
//import org.apache.cordova.LOG;
//import org.apache.cordova.PluginResult;
import org.json.JSONArray;
import org.json.JSONException;
//import org.json.JSONObject;
import com.netcompss.ffmpeg4android_client.BaseWizard;
import com.netcompss.ffmpeg4android_client.Prefs;
import android.content.Context;
import android.content.Intent;

public class VideoCompressor extends CordovaPlugin  {
	

  private static final String ACTION_SHOW_EVENT = "start";
  private BaseWizard baseWizard;



  @Override
  public boolean execute(String action, JSONArray args, final CallbackContext callbackContext) throws JSONException {
    if (ACTION_SHOW_EVENT.equals(action)) {
	cordova.getActivity().runOnUiThread(new Runnable() {
		public void run(){
		//Context context = cordova.getActivity().getApplicationContext();
		//Intent i = new Intent(context,DemoClient.class);
		/*
		String[] commandComplex = {"ffmpeg","-y" ,"-i", "/storage/sdcard0/videos/Other/VID-20130625-WA0002.3gp","-strict","experimental","-s", "160x120","-r","25", "-vcodec", "mpeg4", "-b", "150k", "-ab","48000", "-ac", "2", "-ar", "22050", "/storage/sdcard0/Ngage/Video/outgp.3gp"};
					Log.e("Complex command", commandComplex.toString());
					baseWizard = new BaseWizard();
					baseWizard.setCommandComplex(commandComplex);
					baseWizard.setOutputFilePath("/storage/sdcard0/Ngage/Video/outgp.3gp");
					baseWizard.setProgressDialogTitle("Compressing " + "Video"
							+ ", Please wait...");
					baseWizard.setProgressDialogMessage("Depends on your " + "Video"
							+ " size, it can take a few minutes");

					baseWizard.setProgressDialogTitle("Exporting As MP4 Video");
					baseWizard.setProgressDialogMessage("Depends on your video size, it can take a few minutes");
					//setNotificationIcon(R.drawable.icon2);
					baseWizard.setNotificationMessage("Demo is running...");
					baseWizard.setNotificationTitle("Demo Client");
					baseWizard.setNotificationfinishedMessageTitle("Demo Transcoding finished");
					baseWizard.setNotificationfinishedMessageDesc("Click to play demo");
					baseWizard.setNotificationStoppedMessage("Demo Transcoding stopped");
					///////////////

					Log.i(Prefs.TAG, "ffmpeg4android library version: " + Prefs.getLibraryVersionName());
					baseWizard.runTranscoing();
*/
		Context context = cordova.getActivity().getApplicationContext(); 
		Intent intent = new Intent(context,DemoClient.class);
		cordova.getActivity().startActivity(intent);
		}
	});
    	
    	
  
      return true;
    } else {
      callbackContext.error("Recording." + action + " is not a supported function. Did you mean '" + ACTION_SHOW_EVENT + "'?");
      return false;
    }
    
    
    
  }




}
// ActionScript Communications Document
