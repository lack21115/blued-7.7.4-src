package com.blued.android.module.media.audio.audio_manager;

import android.os.Build;
import android.util.Log;

public final class BLUtils {
  public static String a() {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("@[name=");
    stringBuilder.append(Thread.currentThread().getName());
    stringBuilder.append(", id=");
    stringBuilder.append(Thread.currentThread().getId());
    stringBuilder.append("]");
    return stringBuilder.toString();
  }
  
  public static void a(String paramString) {
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append("Android SDK: ");
    stringBuilder.append(Build.VERSION.SDK_INT);
    stringBuilder.append(", Release: ");
    stringBuilder.append(Build.VERSION.RELEASE);
    stringBuilder.append(", Brand: ");
    stringBuilder.append(Build.BRAND);
    stringBuilder.append(", Device: ");
    stringBuilder.append(Build.DEVICE);
    stringBuilder.append(", Id: ");
    stringBuilder.append(Build.ID);
    stringBuilder.append(", Hardware: ");
    stringBuilder.append(Build.HARDWARE);
    stringBuilder.append(", Manufacturer: ");
    stringBuilder.append(Build.MANUFACTURER);
    stringBuilder.append(", Model: ");
    stringBuilder.append(Build.MODEL);
    stringBuilder.append(", Product: ");
    stringBuilder.append(Build.PRODUCT);
    Log.d(paramString, stringBuilder.toString());
  }
  
  public static void a(boolean paramBoolean) {
    if (paramBoolean)
      return; 
    throw new AssertionError("Expected condition to be true");
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued5032032-dex2jar.jar!\com\blued\android\module\media\audio\audio_manager\BLUtils.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */