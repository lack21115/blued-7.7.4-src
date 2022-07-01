package org.chromium.content.browser;

import android.content.Context;
import android.os.Environment;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import org.chromium.base.Log;
import org.chromium.base.annotations.CalledByNative;
import org.chromium.content.R;
import org.chromium.ui.widget.Toast;

public class TracingControllerAndroid {
  final TracingControllerAndroid$TracingBroadcastReceiver mBroadcastReceiver;
  
  final Context mContext;
  
  String mFilename;
  
  final TracingControllerAndroid$TracingIntentFilter mIntentFilter;
  
  boolean mIsTracing;
  
  long mNativeTracingControllerAndroid;
  
  boolean mShowToasts = true;
  
  public TracingControllerAndroid(Context paramContext) {
    this.mContext = paramContext;
    this.mBroadcastReceiver = new TracingControllerAndroid$TracingBroadcastReceiver(this);
    this.mIntentFilter = new TracingControllerAndroid$TracingIntentFilter(paramContext);
  }
  
  @CalledByNative
  static String generateTracingFilePath() {
    if (!"mounted".equals(Environment.getExternalStorageState()))
      return null; 
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd-HHmmss", Locale.US);
    simpleDateFormat.setTimeZone(TimeZone.getTimeZone("UTC"));
    File file = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
    StringBuilder stringBuilder = new StringBuilder("chrome-profile-results-");
    stringBuilder.append(simpleDateFormat.format(new Date()));
    return (new File(file, stringBuilder.toString())).getPath();
  }
  
  private static void logForProfiler(String paramString) {
    Log.i("cr.TracingController", paramString, new Object[0]);
  }
  
  private native void nativeDestroy(long paramLong);
  
  private native String nativeGetDefaultCategories();
  
  private native long nativeInit();
  
  private native boolean nativeStartTracing(long paramLong, String paramString1, String paramString2);
  
  private void showToast(String paramString) {
    if (this.mShowToasts)
      (Toast.makeText(this.mContext, paramString, 0)).mToast.show(); 
  }
  
  final void initializeNativeControllerIfNeeded() {
    if (this.mNativeTracingControllerAndroid == 0L)
      this.mNativeTracingControllerAndroid = nativeInit(); 
  }
  
  final void logAndToastError(String paramString) {
    Log.e("cr.TracingController", paramString, new Object[0]);
    if (this.mShowToasts)
      (Toast.makeText(this.mContext, paramString, 0)).mToast.show(); 
  }
  
  native boolean nativeGetKnownCategoryGroupsAsync(long paramLong);
  
  native void nativeStopTracing(long paramLong, String paramString);
  
  @CalledByNative
  protected void onTracingStopped() {
    if (!this.mIsTracing) {
      Log.e("cr.TracingController", "Received onTracingStopped, but we aren't tracing", new Object[0]);
      return;
    } 
    logForProfiler(String.format("Profiler finished. Results are in %s.", new Object[] { this.mFilename }));
    showToast(this.mContext.getString(R.string.profiler_stopped_toast, new Object[] { this.mFilename }));
    this.mIsTracing = false;
    this.mFilename = null;
  }
  
  public final boolean startTracing(String paramString1, boolean paramBoolean, String paramString2, String paramString3) {
    this.mShowToasts = paramBoolean;
    if (this.mIsTracing) {
      Log.e("cr.TracingController", "Received startTracing, but we're already tracing", new Object[0]);
      return false;
    } 
    initializeNativeControllerIfNeeded();
    if (!nativeStartTracing(this.mNativeTracingControllerAndroid, paramString2, paramString3.toString())) {
      logAndToastError(this.mContext.getString(R.string.profiler_error_toast));
      return false;
    } 
    logForProfiler(String.format("Profiler started: %s", new Object[] { paramString2 }));
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(this.mContext.getString(R.string.profiler_started_toast));
    stringBuilder.append(": ");
    stringBuilder.append(paramString2);
    showToast(stringBuilder.toString());
    this.mFilename = paramString1;
    this.mIsTracing = true;
    return true;
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\TracingControllerAndroid.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */