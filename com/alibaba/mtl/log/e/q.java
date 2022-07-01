package com.alibaba.mtl.log.e;

import android.util.Log;

public class q {
  private static final String TAG = q.class.getSimpleName();
  
  public static String get(String paramString) {
    try {
      Class<?> clazz = Class.forName("android.os.SystemProperties");
      return (String)clazz.getMethod("get", new Class[] { String.class }).invoke(clazz.newInstance(), new Object[] { paramString });
    } catch (Exception exception) {
      Log.e(TAG, "get() ERROR!!! Exception!", exception);
      return "";
    } 
  }
  
  public static String get(String paramString1, String paramString2) {
    try {
      Class<?> clazz = Class.forName("android.os.SystemProperties");
      return (String)clazz.getMethod("get", new Class[] { String.class, String.class }).invoke(clazz.newInstance(), new Object[] { paramString1, paramString2 });
    } catch (Exception exception) {
      Log.e(TAG, "get() ERROR!!! Exception!", exception);
      return "";
    } 
  }
}


/* Location:              D:\code\BluedHook\classes.dex\com.soft.blued7646532-dex2jar.jar!\com\alibaba\mtl\log\e\q.class
 * Java compiler version: 6 (50.0)
 * JD-Core Version:       1.1.3
 */