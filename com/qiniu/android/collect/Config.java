package com.qiniu.android.collect;

import android.os.Environment;
import com.qiniu.android.utils.ContextGetter;

public final class Config {
  public static String dnscacheDir;
  
  public static int interval = 0;
  
  public static boolean isRecord = true;
  
  public static boolean isUpload = true;
  
  public static int maxRecordFileSize = 0;
  
  public static String preQueryHost;
  
  public static int rePreHost = 0;
  
  public static String recordDir;
  
  public static final String serverURL = "https://uplog.qbox.me/log/4";
  
  public static int uploadThreshold = 4096;
  
  static {
    interval = 10;
    StringBuilder stringBuilder = new StringBuilder();
    stringBuilder.append(Environment.getExternalStorageDirectory());
    stringBuilder.append("/dnschache/");
    dnscacheDir = stringBuilder.toString();
    preQueryHost = "uc.qbox.me";
    rePreHost = 2;
  }
  
  public static void normal() {
    uploadThreshold = 4096;
    interval = 10;
  }
  
  public static void quick() {
    uploadThreshold = 1024;
    interval = 2;
  }
  
  public static void slow() {
    uploadThreshold = 153600;
    interval = 300;
  }
  
  static {
    try {
      recordDir = ContextGetter.applicationContext().getCacheDir().getAbsolutePath();
    } finally {
      Exception exception = null;
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\qiniu\android\collect\Config.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */