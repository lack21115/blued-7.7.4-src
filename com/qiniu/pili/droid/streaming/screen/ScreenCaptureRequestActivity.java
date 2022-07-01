package com.qiniu.pili.droid.streaming.screen;

import a.a.a.a.a.e.e;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.media.projection.MediaProjectionManager;
import android.os.Bundle;
import android.os.Parcelable;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;

public class ScreenCaptureRequestActivity extends Activity {
  public static final String ACTION_REQUEST_SCREEN_CAPTURE_RESULT = "intent.ACTION_REQUEST_SCREEN_CAPTURE_RESULT";
  
  public static final String KEY_RESULT_CODE = "extra.KEY_RESULT_CODE";
  
  public static final String KEY_RESULT_DATA = "extra.KEY_RESULT_DATA";
  
  public static final int REQUEST_SCREEN_CAPTURE_CODE = 1234;
  
  public static final String TAG = "ScreenCaptureRequestActivity";
  
  public void onActivityResult(int paramInt1, int paramInt2, Intent paramIntent) {
    super.onActivityResult(paramInt1, paramInt2, paramIntent);
    if (paramInt1 == 1234) {
      e.g.c("ScreenCaptureRequestActivity", "send broadcast handle screen capturer");
      Intent intent = new Intent("intent.ACTION_REQUEST_SCREEN_CAPTURE_RESULT");
      intent.putExtra("extra.KEY_RESULT_CODE", paramInt2);
      intent.putExtra("extra.KEY_RESULT_DATA", (Parcelable)paramIntent);
      LocalBroadcastManager.getInstance((Context)this).sendBroadcast(intent);
    } else {
      e.g.d("ScreenCaptureRequestActivity", "unknown request code");
    } 
    finish();
  }
  
  public void onCreate(Bundle paramBundle) {
    super.onCreate(paramBundle);
    e.g.c("ScreenCaptureRequestActivity", "request screen capturer permission");
    startActivityForResult(((MediaProjectionManager)getSystemService("media_projection")).createScreenCaptureIntent(), 1234);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued9136188-dex2jar.jar!\com\qiniu\pili\droid\streaming\screen\ScreenCaptureRequestActivity.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */