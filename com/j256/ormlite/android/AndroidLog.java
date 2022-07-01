package com.j256.ormlite.android;

import android.util.Log;
import com.j256.ormlite.logger.Log;
import com.j256.ormlite.logger.LoggerFactory;

public class AndroidLog implements Log {
  private static final String ALL_LOGS_NAME = "ORMLite";
  
  private static final int MAX_TAG_LENGTH = 23;
  
  private static final int REFRESH_LEVEL_CACHE_EVERY = 200;
  
  private String className;
  
  private final boolean[] levelCache;
  
  private volatile int levelCacheC;
  
  public AndroidLog(String paramString) {
    int i = 0;
    this.levelCacheC = 0;
    this.className = LoggerFactory.getSimpleClassName(paramString);
    int j = this.className.length();
    if (j > 23)
      this.className = this.className.substring(j - 23, j); 
    Log.Level[] arrayOfLevel = Log.Level.values();
    int k = arrayOfLevel.length;
    for (j = 0; i < k; j = m) {
      int n = levelToAndroidLevel(arrayOfLevel[i]);
      int m = j;
      if (n > j)
        m = n; 
      i++;
    } 
    this.levelCache = new boolean[j + 1];
    refreshLevelCache();
  }
  
  private boolean isLevelEnabledInternal(int paramInt) {
    return (Log.isLoggable(this.className, paramInt) || Log.isLoggable("ORMLite", paramInt));
  }
  
  private int levelToAndroidLevel(Log.Level paramLevel) {
    switch (paramLevel) {
      default:
        return 4;
      case ERROR:
      case null:
        return 6;
      case WARNING:
        return 5;
      case INFO:
        return 4;
      case DEBUG:
        return 3;
      case TRACE:
        break;
    } 
    return 2;
  }
  
  private void refreshLevelCache() {
    Log.Level[] arrayOfLevel = Log.Level.values();
    int j = arrayOfLevel.length;
    for (int i = 0; i < j; i++) {
      int k = levelToAndroidLevel(arrayOfLevel[i]);
      boolean[] arrayOfBoolean = this.levelCache;
      if (k < arrayOfBoolean.length)
        arrayOfBoolean[k] = isLevelEnabledInternal(k); 
    } 
  }
  
  public boolean isLevelEnabled(Log.Level paramLevel) {
    int i = this.levelCacheC + 1;
    this.levelCacheC = i;
    if (i >= 200) {
      refreshLevelCache();
      this.levelCacheC = 0;
    } 
    i = levelToAndroidLevel(paramLevel);
    boolean[] arrayOfBoolean = this.levelCache;
    return (i < arrayOfBoolean.length) ? arrayOfBoolean[i] : isLevelEnabledInternal(i);
  }
  
  public void log(Log.Level paramLevel, String paramString) {
    switch (paramLevel) {
      default:
        Log.i(this.className, paramString);
        return;
      case null:
        Log.e(this.className, paramString);
        return;
      case ERROR:
        Log.e(this.className, paramString);
        return;
      case WARNING:
        Log.w(this.className, paramString);
        return;
      case INFO:
        Log.i(this.className, paramString);
        return;
      case DEBUG:
        Log.d(this.className, paramString);
        return;
      case TRACE:
        break;
    } 
    Log.v(this.className, paramString);
  }
  
  public void log(Log.Level paramLevel, String paramString, Throwable paramThrowable) {
    switch (paramLevel) {
      default:
        Log.i(this.className, paramString, paramThrowable);
        return;
      case null:
        Log.e(this.className, paramString, paramThrowable);
        return;
      case ERROR:
        Log.e(this.className, paramString, paramThrowable);
        return;
      case WARNING:
        Log.w(this.className, paramString, paramThrowable);
        return;
      case INFO:
        Log.i(this.className, paramString, paramThrowable);
        return;
      case DEBUG:
        Log.d(this.className, paramString, paramThrowable);
        return;
      case TRACE:
        break;
    } 
    Log.v(this.className, paramString, paramThrowable);
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued6949884-dex2jar.jar!\com\j256\ormlite\android\AndroidLog.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */