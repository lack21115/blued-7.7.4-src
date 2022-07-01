package org.chromium.content.browser;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.IntentFilter;

@SuppressLint({"ParcelCreator"})
class TracingControllerAndroid$TracingIntentFilter extends IntentFilter {
  TracingControllerAndroid$TracingIntentFilter(Context paramContext) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(paramContext.getPackageName());
    stringBuilder.append(".GPU_PROFILER_START");
    addAction(stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramContext.getPackageName());
    stringBuilder.append(".GPU_PROFILER_STOP");
    addAction(stringBuilder.toString());
    stringBuilder = new StringBuilder();
    stringBuilder.append(paramContext.getPackageName());
    stringBuilder.append(".GPU_PROFILER_LIST_CATEGORIES");
    addAction(stringBuilder.toString());
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued2362740-dex2jar.jar!\org\chromium\content\browser\TracingControllerAndroid$TracingIntentFilter.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */