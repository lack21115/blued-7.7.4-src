package org.chromium.content.browser;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import org.chromium.base.Log;
import org.chromium.content.R;

final class TracingControllerAndroid$TracingBroadcastReceiver extends BroadcastReceiver {
  public final void onReceive(Context paramContext, Intent paramIntent) {
    TracingControllerAndroid tracingControllerAndroid;
    if (paramIntent.getAction().endsWith("GPU_PROFILER_START")) {
      String str3;
      String str1 = paramIntent.getStringExtra("categories");
      if (TextUtils.isEmpty(str1)) {
        str1 = TracingControllerAndroid.access$000(TracingControllerAndroid.this);
      } else {
        str1 = str1.replaceFirst("_DEFAULT_CHROME_CATEGORIES", TracingControllerAndroid.access$000(TracingControllerAndroid.this));
      } 
      if (paramIntent.getStringExtra("continuous") == null) {
        str3 = "record-until-full";
      } else {
        str3 = "record-continuously";
      } 
      String str2 = paramIntent.getStringExtra("file");
      if (str2 != null) {
        TracingControllerAndroid.this.startTracing(str2, true, str1, str3);
        return;
      } 
      tracingControllerAndroid = TracingControllerAndroid.this;
      tracingControllerAndroid.mShowToasts = true;
      String str4 = TracingControllerAndroid.generateTracingFilePath();
      if (str4 == null)
        tracingControllerAndroid.logAndToastError(tracingControllerAndroid.mContext.getString(R.string.profiler_no_storage_toast)); 
      tracingControllerAndroid.startTracing(str4, true, str1, str3);
      return;
    } 
    if (tracingControllerAndroid.getAction().endsWith("GPU_PROFILER_STOP")) {
      TracingControllerAndroid tracingControllerAndroid1 = TracingControllerAndroid.this;
      if (tracingControllerAndroid1.mIsTracing)
        tracingControllerAndroid1.nativeStopTracing(tracingControllerAndroid1.mNativeTracingControllerAndroid, tracingControllerAndroid1.mFilename); 
      return;
    } 
    if (tracingControllerAndroid.getAction().endsWith("GPU_PROFILER_LIST_CATEGORIES")) {
      TracingControllerAndroid tracingControllerAndroid1 = TracingControllerAndroid.this;
      tracingControllerAndroid1.initializeNativeControllerIfNeeded();
      if (!tracingControllerAndroid1.nativeGetKnownCategoryGroupsAsync(tracingControllerAndroid1.mNativeTracingControllerAndroid))
        Log.e("cr.TracingController", "Unable to fetch tracing record groups list.", new Object[0]); 
      return;
    } 
    Log.e("cr.TracingController", "Unexpected intent: %s", new Object[] { tracingControllerAndroid });
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\TracingControllerAndroid$TracingBroadcastReceiver.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */